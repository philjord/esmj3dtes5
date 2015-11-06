package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class AVIF extends RECO
{

	public ZString EDID = null;

	public AVIF(Record recordData)
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
			else if (sr.getType().equals("CNAM"))
			{
			}
			else if (sr.getType().equals("FULL"))
			{
			}
			else if (sr.getType().equals("AVSK"))
			{
			}
			else if (sr.getType().equals("PNAM"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else if (sr.getType().equals("XNAM"))
			{
			}
			else if (sr.getType().equals("YNAM"))
			{
			}
			else if (sr.getType().equals("HNAM"))
			{
			}
			else if (sr.getType().equals("VNAM"))
			{
			}
			else if (sr.getType().equals("SNAM"))
			{
			}
			else if (sr.getType().equals("INAM"))
			{
			}
			else if (sr.getType().equals("ANAM"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
