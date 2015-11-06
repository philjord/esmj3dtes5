package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.GenericSOUN;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class SOUN extends GenericSOUN
{
	public SOUN(Record recordData)
	{

		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			//byte[] bs = sr.getData();

			if (sr.getType().equals("OBND"))
			{

			}
			else if (sr.getType().equals("SDSC"))
			{

			}
			else if (sr.getType().equals("SNDD"))
			{

			}

		}
	}

}
