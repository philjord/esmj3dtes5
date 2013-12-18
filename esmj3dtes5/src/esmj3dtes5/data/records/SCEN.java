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
			byte[] bs = sr.getData();

			if (sr.getType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getType().equals("VMAD")){}
			else if (sr.getType().equals("FNAM")){}
			else if (sr.getType().equals("HNAM")){}
			else if (sr.getType().equals("NAM0")){}
			else if (sr.getType().equals("NEXT")){}
			else if (sr.getType().equals("WNAM")){}
			else if (sr.getType().equals("ALID")){}
			else if (sr.getType().equals("LNAM")){}
			else if (sr.getType().equals("DNAM")){}
			else if (sr.getType().equals("ANAM")){}
			else if (sr.getType().equals("INAM")){}
			else if (sr.getType().equals("SNAM")){}
			else if (sr.getType().equals("ENAM")){}
			else if (sr.getType().equals("DATA")){}
			else if (sr.getType().equals("HTID")){}
			else if (sr.getType().equals("DMAX")){}
			else if (sr.getType().equals("DMIN")){}
			else if (sr.getType().equals("DEMO")){}
			else if (sr.getType().equals("DEVA")){}
			else if (sr.getType().equals("PNAM")){}
			else if (sr.getType().equals("VNAM")){}
			else if (sr.getType().equals("CTDA")){}
			else if (sr.getType().equals("CIS2")){}
			else if (sr.getType().equals("SCHR")){}
			else if (sr.getType().equals("QNAM")){}
			else if (sr.getType().equals("SCTX")){}
			else if (sr.getType().equals("SCDA")){}
			else if (sr.getType().equals("SCRO")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
