package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;

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

			if (sr.getSubrecordType().equals("NVER"))
			{

			}
			else if (sr.getSubrecordType().equals("NVMI"))
			{

			}
			else if (sr.getSubrecordType().equals("NVPP"))
			{

			}

			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}

		}
	}
}
