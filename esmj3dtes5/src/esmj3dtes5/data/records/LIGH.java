package esmj3dtes5.data.records;

import java.util.ArrayList;

import javax.vecmath.Color3f;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class LIGH extends RECO
{
	/*
	 Light flags:

	 0x00000001 = Dynamic
	 0x00000002 = Can be Carried
	 0x00000004 = Negative
	 0x00000008 = Flicker
	 0x00000020 = Off By Default
	 0x00000040 = Flicker Slow
	 0x00000080 = Pulse
	 0x00000100 = Pulse Slow
	 0x00000200 = Spot Light
	 0x00000400 = Spot Shadow 
	 */
	public ZString EDID = null;

	public FormID FULL;

	public MODL MODL;

	public float fade = 0;

	public byte[] SNAM = null;

	public Color3f color = null;

	public float radius = 0;

	public float falloffExponent = 1f;

	public float fieldOfView = 90.0f;

	public int flags = 0;

	public LIGH(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{
				radius = ESMByteConvert.extractInt(bs, 4);

				int r = ESMByteConvert.extractUnsignedByte(bs, 8);
				int g = ESMByteConvert.extractUnsignedByte(bs, 9);
				int b = ESMByteConvert.extractUnsignedByte(bs, 10);
				color = new Color3f(r, g, b);

				flags = ESMByteConvert.extractInt(bs, 12);
				falloffExponent = ESMByteConvert.extractFloat(bs, 16);

				fieldOfView = ESMByteConvert.extractFloat(bs, 20);

				/*	System.out.println("EDID " + EDID.editorId);
				 System.out.println("radius " + radius);
				 System.out.println("color " + color);
				 System.out.println("falloffExponent " + falloffExponent);
				 System.out.println("fieldOfView " + fieldOfView);

				 System.out.println("flags " + ((flags & 0x00000200) != 0));
				 */
			}

			else if (sr.getSubrecordType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getSubrecordType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}

			else if (sr.getSubrecordType().equals("FNAM"))
			{
				fade = ESMByteConvert.extractFloat(bs, 0);
				//			System.out.println("FNAM " + fade);
			}
			else if (sr.getSubrecordType().equals("SNAM"))
			{
				SNAM = bs;
			}
			else if (sr.getSubrecordType().equals("OBND"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
