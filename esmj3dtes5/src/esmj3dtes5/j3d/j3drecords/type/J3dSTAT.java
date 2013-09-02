package esmj3dtes5.j3d.j3drecords.type;

import javax.media.j3d.BoundingSphere;
import javax.media.j3d.DistanceLOD;
import javax.media.j3d.Group;
import javax.media.j3d.Node;
import javax.media.j3d.Switch;
import javax.vecmath.Point3d;

import utils.source.MeshSource;
import utils.source.TextureSource;
import esmj3d.j3d.BethRenderSettings;
import esmj3d.j3d.j3drecords.type.J3dRECOType;
import esmj3d.j3d.j3drecords.type.J3dRECOTypeGeneral;
import esmj3dtes5.data.records.STAT;

public class J3dSTAT extends J3dRECOType 
{
	private Switch switchGroup;

	private DistanceLOD dl;

	private STAT stat;

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

	public J3dSTAT(STAT stat, boolean makePhys, MeshSource meshSource, TextureSource textureSource)
	{
		super(stat, stat.MODL.model.str);

		this.stat = stat;

		//TEST! if return is not commentd mind you
		if (makePhys || stat.MODL.model.str.toLowerCase().indexOf("impexttower03") == -1)
		{
		//	return;
		}

		switchGroup = new Switch(0);
		switchGroup.setCapability(Switch.ALLOW_SWITCH_WRITE);
		addChild(switchGroup);

		if (!stat.isFlagSet(0x00008000))
		{
			Node node = J3dRECOTypeGeneral.loadSharedGroup(stat.MODL.model.str, makePhys, meshSource, textureSource);

			switchGroup.addChild(node);
			switchGroup.addChild(new Group());
		}
		else
		{

			Node node = J3dRECOTypeGeneral.loadSharedGroup(stat.MODL.model.str, makePhys, meshSource, textureSource);
			switchGroup.addChild(node);

			if (stat.lodModel1.length() > 0)
			{
				Node node1 = J3dRECOTypeGeneral.loadSharedGroup(stat.lodModel1, makePhys, meshSource, textureSource);
				switchGroup.addChild(node1);

				if (stat.lodModel2.length() > 0)
				{
					Node node2 = J3dRECOTypeGeneral.loadSharedGroup(stat.lodModel2, makePhys, meshSource, textureSource);
					switchGroup.addChild(node2);

					if (stat.lodModel3.length() > 0)
					{
						Node node3 = J3dRECOTypeGeneral.loadSharedGroup(stat.lodModel3, makePhys, meshSource, textureSource);
						switchGroup.addChild(node3);

						if (stat.lodModel4.length() > 0)
						{
							Node node4 = J3dRECOTypeGeneral.loadSharedGroup(stat.lodModel4, makePhys, meshSource, textureSource);
							switchGroup.addChild(node4);
						}
					}
				}
			}

			//add a blank if there's no lod 4
			if (!(stat.lodModel4.length() > 0))
			{
				switchGroup.addChild(new Group());
			}
		}

		float[] dist = calcDistances(BethRenderSettings.getItemFade());

		dl = new DistanceLOD(dist);
		dl.addSwitch(switchGroup);
		addChild(dl);
		dl.setSchedulingBounds(new BoundingSphere(new Point3d(0.0, 0.0, 0.0), Double.POSITIVE_INFINITY));
		dl.setEnable(true);

		
	}

	@Override
	public void renderSettingsUpdated()
	{
		float[] dist = calcDistances(BethRenderSettings.getItemFade());
		for (int d = 0; d < dist.length; d++)
		{
			dl.setDistance(d, dist[d]);
		}
	}

	private float[] calcDistances(float baseDist)
	{
		float dist0 = baseDist;
		float dist1 = baseDist * 2;
		float dist2 = baseDist * 3;
		float dist3 = baseDist * 4;

		if (!stat.isFlagSet(0x00008000))
		{
			dist0 = baseDist * 3;
		}

		float[] dist = null;
		if (switchGroup.numChildren() == 2)
		{
			dist = new float[]
			{ dist0 };
		}
		else if (switchGroup.numChildren() == 3)
		{
			dist = new float[]
			{ dist0, dist1 };
		}
		else if (switchGroup.numChildren() == 4)
		{
			dist = new float[]
			{ dist0, dist1, dist2 };
		}
		else if (switchGroup.numChildren() == 5)
		{
			dist = new float[]
			{ dist0, dist1, dist2, dist3 };
		}

		return dist;
	}
}
