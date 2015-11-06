package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class LCTN extends RECO
{
	public ZString EDID;

	public LCTN(Record recordData)
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
			else if (sr.getType().equals("LCSR")){}
			else if (sr.getType().equals("FULL")){}
			else if (sr.getType().equals("KSIZ")){}
			else if (sr.getType().equals("KWDA")){}
			else if (sr.getType().equals("PNAM")){}
			else if (sr.getType().equals("CNAM")){}
			else if (sr.getType().equals("MNAM")){}
			else if (sr.getType().equals("RNAM")){}
			else if (sr.getType().equals("LCEC")){}
			else if (sr.getType().equals("LCID")){}
			else if (sr.getType().equals("LCPR")){}
			else if (sr.getType().equals("NAM1")){}
			else if (sr.getType().equals("LCEP")){}
			else if (sr.getType().equals("LCUN")){}
			else if (sr.getType().equals("NAM0")){}
			else if (sr.getType().equals("FNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
