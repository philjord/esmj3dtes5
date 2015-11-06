package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class COLL extends RECO
{
	public ZString EDID;

	public COLL(Record recordData)
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
			else if (sr.getType().equals("DESC")){}
			else if (sr.getType().equals("BNAM")){}
			else if (sr.getType().equals("FNAM")){}
			else if (sr.getType().equals("GNAM")){}
			else if (sr.getType().equals("MNAM")){}
			else if (sr.getType().equals("INTV")){}
			else if (sr.getType().equals("CNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
