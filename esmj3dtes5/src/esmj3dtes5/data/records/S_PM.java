package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class S_PM extends RECO
{
	public ZString EDID;

	public S_PM(Record recordData)
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
			else if (sr.getType().equals("NAM1")){}
			else if (sr.getType().equals("MNAM")){}
			else if (sr.getType().equals("ANAM")){}
			else if (sr.getType().equals("ONAM")){}
			else if (sr.getType().equals("FNAM")){}
			else if (sr.getType().equals("CNAM")){}
			else if (sr.getType().equals("SNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
