package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class IMAD extends RECO
{
	public ZString EDID = null;

	public IMAD(Record recordData)
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
			else if (sr.getType().equals("DNAM"))
			{

			}
			else if (sr.getType().equals("BNAM"))
			{

			}
			else if (sr.getType().equals("VNAM"))
			{

			}
			else if (sr.getType().equals("TNAM"))
			{

			}
			else if (sr.getType().equals("NAM3"))
			{

			}
			else if (sr.getType().equals("RNAM"))
			{

			}
			else if (sr.getType().equals("SNAM"))
			{

			}
			else if (sr.getType().equals("UNAM"))
			{

			}
			else if (sr.getType().equals("NAM1"))
			{

			}
			else if (sr.getType().equals("NAM2"))
			{

			}
			else if (sr.getType().equals("WNAM"))
			{

			}
			else if (sr.getType().equals("XNAM"))
			{

			}
			else if (sr.getType().equals("YNAM"))
			{

			}
			else if (sr.getType().equals("NAM4"))
			{

			}
			else if (sr.getType().endsWith("IAD"))
			{
				//many records here
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
