package esmj3dtes5.data.records;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.InstRECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.XRGD;

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
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("NAME"))
			{
				NAME = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XESP"))
			{
				XESP = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XHRS"))
			{
				XHRS = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XMRC"))
			{
				XMRC = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XRGD"))
			{
				XRGD = new XRGD(bs);
			}
			else if (sr.getSubrecordType().equals("XSCL"))
			{
				scale = ESMByteConvert.extractFloat(bs, 0);
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{
				this.extractInstData(bs);
			}
			else if (sr.getSubrecordType().equals("XLCM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLKR"))
			{

			}
			else if (sr.getSubrecordType().equals("XLCN"))
			{

			}
			else if (sr.getSubrecordType().equals("XLRT"))
			{

			}
			else if (sr.getSubrecordType().equals("VMAD"))
			{
			}
			else if (sr.getSubrecordType().equals("XAPD"))
			{
			}
			else if (sr.getSubrecordType().equals("XAPR"))
			{
			}
			else if (sr.getSubrecordType().equals("XRGB"))
			{
			}
			else if (sr.getSubrecordType().equals("XEZN"))
			{
			}
			else if (sr.getSubrecordType().equals("XOWN"))
			{
			}
			else if (sr.getSubrecordType().equals("XHOR"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}

		}
	}

}
