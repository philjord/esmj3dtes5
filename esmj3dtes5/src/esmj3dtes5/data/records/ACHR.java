package esmj3dtes5.data.records;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmj3d.data.shared.records.InstRECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.XRGD;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class ACHR extends InstRECO
{
	public ZString EDID = null;

	public FormID NAME = null;

	public FormID XESP = null;

	public FormID XHRS = null;

	public FormID XMRC = null;

	public XRGD XRGD = null;

	public ACHR(Record recordData)
	{

		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getData();

			if (sr.getType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getType().equals("NAME"))
			{
				NAME = new FormID(bs);
			}
			else if (sr.getType().equals("XESP"))
			{
				//8-byte struct

				// formid - Parent reference (Object to take enable state from)
				// uint32 - Flags

				//     0x0001 = Set Enable State to Opposite of Parent
				//     0x0002 = Pop In

				//also all other ACHRs

				//XESP = new FormID(bs);
			}
			else if (sr.getType().equals("XHRS"))
			{
				XHRS = new FormID(bs);
			}
			else if (sr.getType().equals("XMRC"))
			{
				XMRC = new FormID(bs);
			}
			else if (sr.getType().equals("XRGD"))
			{
				XRGD = new XRGD(bs);
			}
			else if (sr.getType().equals("XSCL"))
			{
				scale = ESMByteConvert.extractFloat(bs, 0);
			}
			else if (sr.getType().equals("DATA"))
			{
				this.extractInstData(bs);
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
			else if (sr.getType().equals("XLRT"))
			{

			}
			else if (sr.getType().equals("VMAD"))
			{
			}
			else if (sr.getType().equals("XAPD"))
			{
			}
			else if (sr.getType().equals("XAPR"))
			{
			}
			else if (sr.getType().equals("XRGB"))
			{
			}
			else if (sr.getType().equals("XEZN"))
			{
			}
			else if (sr.getType().equals("XOWN"))
			{
			}
			else if (sr.getType().equals("XHOR"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}

}
