package esmj3dtes5.j3d.j3drecords.type;

import java.util.ArrayList;

import org.jogamp.java3d.BranchGroup;
import org.jogamp.java3d.Node;
import org.jogamp.java3d.utils.shader.Cube;

import esmj3d.data.shared.records.RECO;
import esmj3d.j3d.BethRenderSettings;
import esmj3d.j3d.j3drecords.type.J3dRECOType;
import esmj3dtes5.data.records.STAT;
import nif.j3d.J3dNiAVObject;
import tools3d.utils.Utils3D;
import tools3d.utils.scenegraph.BetterDistanceLOD;
import utils.source.MediaSources;

public class J3dSTAT extends J3dRECOType
{

	public static boolean SHOW_FADE_OUT_MARKER = false;

	private BetterDistanceLOD dl;

	private ArrayList<BranchGroup> myNodes = new ArrayList<BranchGroup>();

	/**
	 * Has Tree LOD = 0x00000040
	        Not On Local Map = 0x00000200
	        Has Distance LOD = 0x00008000
	 High Detail LOD Texture = 0x00020000
	            Has Currents = 0x00080000
	               Is Marker = 0x00800000
	                Obstacle = 0x02000000
	       Show On World Map = 0x10000000
	 * @param stat
	 * @param makePhys
	 * @param meshSource
	 * @param textureSource
	 */

	public J3dSTAT(STAT stat, boolean makePhys, MediaSources mediaSources)
	{
		super(stat, stat.MODL.model.str);

		//TEST! if return is not commented mind you
		//|| stat.MODL.model.str.indexOf("CliffSm01.nif") == -1 is fixed?
		//if (stat.isFlagSet(RECO.VisibleWhenDistant_Flag) || stat.MODL.model.str.indexOf("Firewood") == -1)
		{
			//	return;
		}

		if (makePhys)
		{
			Node node = J3dRECOType.loadNif(stat.MODL.model.str, makePhys, mediaSources);
			addChild(node);
		}
		else
		{

			if (!stat.isFlagSet(RECO.VisibleWhenDistant_Flag))
			{
				J3dNiAVObject node = J3dRECOType.loadNif(stat.MODL.model.str, makePhys, mediaSources);
				myNodes.add(node.getRootNode());

				//add a blank for final fade out	
				BranchGroup bg = new BranchGroup();
				BranchGroup blank = new BranchGroup();
				bg.addChild(SHOW_FADE_OUT_MARKER ? new Cube(0.1) : blank);
				myNodes.add(bg);

			}
			else
			{
				J3dNiAVObject node = J3dRECOType.loadNif(stat.MODL.model.str, makePhys, mediaSources);
				myNodes.add(node.getRootNode());

				if (stat.lodModel1 != null && stat.lodModel1.length() > 0)
				{
					J3dNiAVObject node1 = J3dRECOType.loadNif(stat.lodModel1, makePhys, mediaSources);
					myNodes.add(node1.getRootNode());

					if (stat.lodModel2 != null && stat.lodModel2.length() > 0)
					{
						J3dNiAVObject node2 = J3dRECOType.loadNif(stat.lodModel2, makePhys, mediaSources);
						myNodes.add(node2.getRootNode());

						if (stat.lodModel3 != null && stat.lodModel3.length() > 0)
						{
							J3dNiAVObject node3 = J3dRECOType.loadNif(stat.lodModel3, makePhys, mediaSources);
							myNodes.add(node3.getRootNode());

							if (stat.lodModel4 != null && stat.lodModel4.length() > 0)
							{
								J3dNiAVObject node4 = J3dRECOType.loadNif(stat.lodModel4, makePhys, mediaSources);
								myNodes.add(node4.getRootNode());
							}
						}
					}
				}

				//add a blank for final fade out				 
				//BranchGroup bg = new BranchGroup();
				//bg.addChild(SHOW_FADE_OUT_MARKER ? new ColorCube(0.1) : new BranchGroup());
				//myNodes.add(bg);

			}
			float[] dists = calcDistances(BethRenderSettings.getItemFade());
			dl = new BetterDistanceLOD(this, myNodes, dists);
			addChild(dl);
			dl.setSchedulingBounds(Utils3D.defaultBounds);
			dl.setEnable(true);
		}

		//TODO: I ant to call fireIdle about now to be honest
	}

	@Override
	public void renderSettingsUpdated()
	{
		if (dl != null)
		{
			float[] dist = calcDistances(BethRenderSettings.getItemFade());
			for (int d = 0; d < dist.length; d++)
			{
				dl.setDistance(d, dist[d]);
			}
			dl.setSchedulingBounds(Utils3D.defaultBounds);
		}
	}

	@Override
	public void setOutlined(boolean b)
	{
		//ignored
	}

	/**
	 * For Lod enabled stats only
	 * @param baseDist
	 * @return
	 */
	private float[] calcDistances(float baseDist)
	{
		float[] dist = null;
		//case of no lod models just base and blank
		if (myNodes.size() <= 2)
		{
			dist = new float[] { baseDist };
		}
		else if (myNodes.size() == 3)
		{
			dist = new float[] { baseDist, baseDist * 5f };
		}
		else if (myNodes.size() == 4)
		{
			dist = new float[] { baseDist, baseDist * 2f, baseDist * 5f };
		}
		else if (myNodes.size() == 5)
		{
			dist = new float[] { baseDist, baseDist * 2f, baseDist * 3f, baseDist * 5f };
		}
		else if (myNodes.size() == 6)
		{
			dist = new float[] { baseDist, baseDist * 2f, baseDist * 3f, baseDist * 4f, baseDist * 5f };
		}

		return dist;
	}

}
