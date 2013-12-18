package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class MESG extends RECO
{

	public ZString EDID = null;

	public MESG(Record recordData)
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
			else if (sr.getType().equals("DESC"))
			{

			}
			else if (sr.getType().equals("FULL"))
			{

			}
			else if (sr.getType().equals("INAM"))
			{

			}
			else if (sr.getType().equals("DNAM"))
			{

			}
			else if (sr.getType().equals("ITXT"))
			{

			}
			else if (sr.getType().equals("TNAM"))
			{

			}
			else if (sr.getType().equals("CTDA"))
			{

			}
			else if (sr.getType().equals("NAM0"))
			{

			}
			else if (sr.getType().equals("NAM1"))
			{

			}
			else if (sr.getType().equals("NAM2"))
			{

			}
			else if (sr.getType().equals("NAM3"))
			{

			}
			else if (sr.getType().equals("NAM4"))
			{

			}
			else if (sr.getType().equals("NAM5"))
			{

			}
			else if (sr.getType().equals("NAM6"))
			{

			}
			else if (sr.getType().equals("NAM7"))
			{

			}
			else if (sr.getType().equals("NAM8"))
			{

			}
			else if (sr.getType().equals("NAM9"))
			{

			}
			else if (sr.getType().equals("QNAM"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
