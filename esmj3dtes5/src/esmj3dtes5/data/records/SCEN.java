package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class SCEN extends RECO
{
	public ZString EDID;

	public SCEN(Record recordData)
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
			else if (sr.getSubrecordType().equals("VMAD")){}
			else if (sr.getSubrecordType().equals("FNAM")){}
			else if (sr.getSubrecordType().equals("HNAM")){}
			else if (sr.getSubrecordType().equals("NAM0")){}
			else if (sr.getSubrecordType().equals("NEXT")){}
			else if (sr.getSubrecordType().equals("WNAM")){}
			else if (sr.getSubrecordType().equals("ALID")){}
			else if (sr.getSubrecordType().equals("LNAM")){}
			else if (sr.getSubrecordType().equals("DNAM")){}
			else if (sr.getSubrecordType().equals("ANAM")){}
			else if (sr.getSubrecordType().equals("INAM")){}
			else if (sr.getSubrecordType().equals("SNAM")){}
			else if (sr.getSubrecordType().equals("ENAM")){}
			else if (sr.getSubrecordType().equals("DATA")){}
			else if (sr.getSubrecordType().equals("HTID")){}
			else if (sr.getSubrecordType().equals("DMAX")){}
			else if (sr.getSubrecordType().equals("DMIN")){}
			else if (sr.getSubrecordType().equals("DEMO")){}
			else if (sr.getSubrecordType().equals("DEVA")){}
			else if (sr.getSubrecordType().equals("PNAM")){}
			else if (sr.getSubrecordType().equals("VNAM")){}
			else if (sr.getSubrecordType().equals("CTDA")){}
			else if (sr.getSubrecordType().equals("CIS2")){}
			else if (sr.getSubrecordType().equals("SCHR")){}
			else if (sr.getSubrecordType().equals("QNAM")){}
			else if (sr.getSubrecordType().equals("SCTX")){}
			else if (sr.getSubrecordType().equals("SCDA")){}
			else if (sr.getSubrecordType().equals("SCRO")){}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
