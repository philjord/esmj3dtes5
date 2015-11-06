package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class CSTY extends RECO
{

	public ZString EDID = null;

	public CSTY(Record recordData)
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
			else if (sr.getType().equals("CSGD"))
			{
			}
			else if (sr.getType().equals("CSME"))
			{
			}
			else if (sr.getType().equals("CSCR"))
			{
			}
			else if (sr.getType().equals("CSLR"))
			{
			}
			else if (sr.getType().equals("CSFL"))
			{
			}
			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("CSMD"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
