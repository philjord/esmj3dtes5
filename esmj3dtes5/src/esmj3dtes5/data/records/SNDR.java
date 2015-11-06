package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class SNDR extends RECO
{
	public ZString EDID;

	public SNDR(Record recordData)
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
			else if (sr.getType().equals("CNAM")){}
			else if (sr.getType().equals("GNAM")){}
			else if (sr.getType().equals("ANAM")){}
			else if (sr.getType().equals("ONAM")){}
			else if (sr.getType().equals("LNAM")){}
			else if (sr.getType().equals("BNAM")){}
			else if (sr.getType().equals("SNAM")){}
			else if (sr.getType().equals("CTDA")){}
			else if (sr.getType().equals("FNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
