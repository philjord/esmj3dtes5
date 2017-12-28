package esmj3dtes5.data.records;

import java.util.List;

import esmio.common.data.record.Record;
import esmio.common.data.record.Subrecord;
import esmj3d.data.shared.records.GenericSOUN;

public class SOUN extends GenericSOUN
{
	public SOUN(Record recordData)
	{

		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			//byte[] bs = sr.getData();

			if (sr.getSubrecordType().equals("OBND"))
			{

			}
			else if (sr.getSubrecordType().equals("SDSC"))
			{

			}
			else if (sr.getSubrecordType().equals("SNDD"))
			{

			}

		}
	}

}
