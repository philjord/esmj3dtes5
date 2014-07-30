package esmj3dtes5.j3d.cell;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.IndexedGeometryArray;
import javax.media.j3d.Shape3D;
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
import esmj3d.j3d.cell.MorphingLandscape;
import esmj3d.j3d.j3drecords.inst.J3dLAND;

public class Tes5LODLandscape extends MorphingLandscape
{
	public Tes5LODLandscape(int lodX, int lodY, int scale, String worldFormName, MeshSource meshSource, TextureSource textureSource)
	{
		super(lodX, lodY, scale);
		String meshName = "terrain\\" + worldFormName + "\\" + worldFormName + "." + scale + "." + lodX + "." + lodY + ".btr";

		setCapability(BranchGroup.ALLOW_DETACH);
		if (meshSource.nifFileExists(meshName))
		{
			NifFile nf = NifToJ3d.loadNiObjects(meshName, meshSource);
			if (nf != null)
			{
				NiObjectList blocks = nf.blocks;

				// we know it is a NiTriShapeData at block 2
				NiTriShapeData data = (NiTriShapeData) blocks.getNiObjects()[2];

				//scale 4 will get morph treatment later
				boolean morphable = (scale == 4);
				IndexedGeometryArray baseItsa = J3dNiTriShape.createGeometry(data, morphable);

				if (morphable)
				{
					this.setGeometryArray(baseItsa);
				}

				Shape3D shape = new Shape3D();
				shape.setGeometry(baseItsa);

				//we know it's a textureset at block 4
				BSShaderTextureSet ts = (BSShaderTextureSet) blocks.getNiObjects()[4];
				shape.setAppearance(createAppearance(textureSource.getTexture(ts.textures[0])));

				TransformGroup tg = new TransformGroup();
				Transform3D t = new Transform3D(new Quat4f(0, 0, 0, 1), new Vector3f((lodX * J3dLAND.LAND_SIZE), 0,
						(-lodY * J3dLAND.LAND_SIZE)), scale);
				tg.setTransform(t);
				tg.addChild(shape);
				addChild(tg);
			}
			else
			{
				System.out.println("Bad landscape NifFile " + meshName);
			}
		}
		else
		{
			//fine the systems just asking for empty space which is fine
			//System.out.println("Bad landscape name " + meshName);
		}
	}
}
