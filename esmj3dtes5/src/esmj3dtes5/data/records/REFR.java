package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonREFR;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.XMBO;
import esmj3d.data.shared.subrecords.XPRM;

public class REFR extends CommonREFR
{
	//OCCLUSION DATA
	public XPRM XPRM; // primitve data for bounds type objects, see occulsion in spacetrader

	//OCCLUSION DATA
	public XMBO XMBO; // multi bounds objects info 

	public byte[] XRMR; //XRMR 	reference marker 	struct 	ubyte - count of following XLRM, ubyte[3] - seems to be flags 0x10000 - seen in 0x000C6B47, 48 

	public ArrayList<FormID> XLMRs = new ArrayList<FormID>(); //XLRM 	location room marker 	formid 	REFR usually to a STAT

	public REFR(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getData();

			//also in fallout3
			if (sr.getType().equals("XPRM"))
			{
				XPRM = new XPRM(bs);
			}
			else if (sr.getType().equals("XMBO"))
			{
				XMBO = new XMBO(bs);
			}
			else if (sr.getType().equals("XRMR"))
			{
				XRMR = bs;
			}
			else if (sr.getType().equals("XLRM"))
			{
				XLMRs.add(new FormID(bs));
			}
			else if (sr.getType().equals("VMAD"))
			{
			}
			else if (sr.getType().equals("XLCM"))
			{
			}
			else if (sr.getType().equals("XLKR"))
			{
			}
			else if (sr.getType().equals("XLCN"))
			{
			}
			else if (sr.getType().equals("XNDP"))
			{
			}
			else if (sr.getType().equals("XPRD"))
			{
			}
			else if (sr.getType().equals("XPPA"))
			{
			}
			else if (sr.getType().equals("PDTO"))
			{
			}
			else if (sr.getType().equals("INAM"))
			{
			}
			else if (sr.getType().equals("XEMI"))
			{
			}
			else if (sr.getType().equals("XLIB"))
			{
			}
			else if (sr.getType().equals("XRDS"))
			{
			}
			else if (sr.getType().equals("XLIG"))
			{
			}
			else if (sr.getType().equals("XALP"))
			{
			}
			else if (sr.getType().equals("XRGD"))
			{
			}
			else if (sr.getType().equals("XPOD"))
			{
			}
			else if (sr.getType().equals("XLRT"))
			{
			}
			else if (sr.getType().equals("XMBR"))
			{
			}
			else if (sr.getType().equals("XTRI"))
			{
			}
			else if (sr.getType().equals("XAPD"))
			{
			}
			else if (sr.getType().equals("XAPR"))
			{
			}
			else if (sr.getType().equals("XTNM"))
			{
			}
			else if (sr.getType().equals("XWCU"))
			{
			}
			else if (sr.getType().equals("XWCN"))
			{
			}
			else if (sr.getType().equals("XIS2"))
			{
			}
			else if (sr.getType().equals("XPWR"))
			{
			}
			else if (sr.getType().equals("XEZN"))
			{
			}
			else if (sr.getType().equals("XOCP"))
			{
			}
			else
			{
				//CommonREFR makes this no use now
				//	System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}

	}
}
