package esmj3dtes5.j3d.cell;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Texture;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import nif.NiObjectList;
import nif.NifFile;
import nif.NifToJ3d;
import nif.j3d.J3dNiTriShape;
import nif.niobject.NiTriShapeData;
import nif.niobject.bs.BSShaderTextureSet;
import utils.source.MeshSource;
import utils.source.TextureSource;

import com.sun.j3d.utils.geometry.GeometryInfo;

import esmj3d.j3d.j3drecords.inst.J3dLAND;

public class Tes5LODLandscape extends BranchGroup
{

	public Tes5LODLandscape(int lodX, int lodY, int scale, String worldFormName, MeshSource meshSource, TextureSource textureSource)
	{
		String meshName = "terrain\\" + worldFormName + "\\" + worldFormName + "." + scale + "." + lodX + "." + lodY + ".btr";

		setCapability(BranchGroup.ALLOW_DETACH);
		NifFile nf = NifToJ3d.loadNiObjects(meshName, meshSource);
		if (nf != null)
		{
			NiObjectList blocks = nf.blocks;

			// we know it is a NiTriStripsData at block 1
			NiTriShapeData data = (NiTriShapeData) blocks.getNiObjects()[2];
			GeometryInfo gi = J3dNiTriShape.makeGeometryInfo(data);
			if (gi != null)
			{
				GeometryArray baseItsa = J3dNiTriShape.makeGeometry(gi, true, data);

				Shape3D shape = new Shape3D();
				shape.setGeometry(baseItsa);
				Appearance app = new Appearance();
				app.setMaterial(J3dLAND.getLandMaterial());

				BSShaderTextureSet ts = (BSShaderTextureSet) blocks.getNiObjects()[4];

				Texture tex = textureSource.getTexture(ts.textures[0]);
				app.setTexture(tex);

				shape.setAppearance(app);
				TransformGroup tg = new TransformGroup();

				Transform3D t = new Transform3D(new Quat4f(0, 0, 0, 1), new Vector3f((lodX * J3dLAND.LAND_SIZE), 0,
						(-lodY * J3dLAND.LAND_SIZE)), scale);
				tg.setTransform(t);
				tg.addChild(shape);
				addChild(tg);
			}
			else
			{
				System.out.println("Bad landscape GI " + meshName);
			}

		}
		else
		{
			//ignore
			System.out.println("Bad landscape name " + meshName);
		}

	}
}
