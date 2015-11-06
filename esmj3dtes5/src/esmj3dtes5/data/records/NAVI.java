package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class NAVI extends RECO
{

	public NAVI(Record recordData)
	{
		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			//byte[] bs = sr.getSubrecordData();

			if (sr.getType().equals("NVER"))
			{

			}
			else if (sr.getType().equals("NVMI"))
			{

			}
			else if (sr.getType().equals("NVPP"))
			{

			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
