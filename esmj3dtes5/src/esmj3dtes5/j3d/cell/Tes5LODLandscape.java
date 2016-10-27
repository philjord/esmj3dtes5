package esmj3dtes5.j3d.cell;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import org.jogamp.java3d.BranchGroup;
import org.jogamp.java3d.IndexedGeometryArray;
import org.jogamp.java3d.Shape3D;
import org.jogamp.java3d.Transform3D;
import org.jogamp.java3d.TransformGroup;

import esmj3d.j3d.cell.MorphingLandscape;
import esmj3d.j3d.j3drecords.inst.J3dLAND;
import nif.NiObjectList;
import nif.NifFile;
import nif.NifToJ3d;
import nif.basic.NifRef;
import nif.j3d.J3dNiTriShape;
import nif.niobject.NiAVObject;
import nif.niobject.NiObject;
import nif.niobject.NiTriShape;
import nif.niobject.NiTriShapeData;
import nif.niobject.bs.BSLightingShaderProperty;
import nif.niobject.bs.BSMultiBoundNode;
import nif.niobject.bs.BSShaderTextureSet;
import utils.source.MeshSource;
import utils.source.TextureSource;

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
				BSMultiBoundNode root = (BSMultiBoundNode) blocks.root();

				TransformGroup tg = new TransformGroup();
				Transform3D t = new Transform3D(new Quat4f(0, 0, 0, 1), new Vector3f((lodX * J3dLAND.LAND_SIZE), 0,
						(-lodY * J3dLAND.LAND_SIZE)), scale);
				tg.setTransform(t);

				for (NifRef cnr : root.children)
				{
					NiAVObject child = (NiAVObject) nf.blocks.get(cnr);

					if (child instanceof NiTriShape)
					{
						// regular lod terrains
						NiTriShape niTriShape = (NiTriShape) child;
						NiTriShapeData data = (NiTriShapeData) blocks.get(niTriShape.data);

						//scale 4 will get morph treatment later
						boolean morphable = (scale == 4);
						IndexedGeometryArray baseItsa = J3dNiTriShape.createGeometry(data, morphable);

						if (morphable)
						{
							this.addGeometryArray(baseItsa);
						}

						Shape3D shape = new Shape3D();
						shape.setPickable(false);
						shape.setCollidable(false);
						shape.setGeometry(baseItsa);

						BSLightingShaderProperty lp = getLightingProperty(niTriShape, blocks);
						if (lp != null)
						{
							BSShaderTextureSet ts = (BSShaderTextureSet) blocks.get(lp.TextureSet);
							shape.setAppearance(createAppearance(textureSource.getTexture(ts.textures[0])));
							tg.addChild(shape);
						}
						else
						{
							System.out.println("unpropertied trishape in skyrim lod " + niTriShape + " in " + meshName);
						}
					}
					else if (child instanceof BSMultiBoundNode)
					{
						//Skyrim has water under it's own bounds node
						BSMultiBoundNode waterRoot = (BSMultiBoundNode) child;

						for (NifRef wcnr : waterRoot.children)
						{
							NiAVObject waterChild = (NiAVObject) nf.blocks.get(wcnr);

							if (waterChild instanceof NiTriShape)
							{
								// regular lod terrains
								NiTriShape niTriShape = (NiTriShape) waterChild;
								NiTriShapeData data = (NiTriShapeData) blocks.get(niTriShape.data);

								//scale 4 will get morph treatment later
								boolean morphable = (scale == 4);
								IndexedGeometryArray baseItsa = J3dNiTriShape.createGeometry(data, morphable);

								if (morphable)
								{
									this.addGeometryArray(baseItsa);
								}

								Shape3D shape = new Shape3D();
								shape.setGeometry(baseItsa);

								BSLightingShaderProperty lp = getLightingProperty(niTriShape, blocks);
								if (lp != null)
								{
									System.out.println("Skyrim water child has properties! " + waterChild + " in " + meshName);
								}
								else
								{
									shape.setAppearance(createBasicWaterApp());
									tg.addChild(shape);
								}
							}
							else
							{
								System.out.println("Lod file water child odd " + waterChild + " in " + meshName);
							}
						}
					}
					else
					{
						System.out.println("Lod file child odd " + child + " in " + meshName);
					}
				}

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

	private BSLightingShaderProperty getLightingProperty(NiTriShape niTriShape, NiObjectList blocks)
	{
		for (NifRef pnr : niTriShape.properties)
		{
			NiObject p = blocks.get(pnr);
			if (p instanceof BSLightingShaderProperty)
				return (BSLightingShaderProperty) p;
		}
		return null;
	}
}
