package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class PERK extends RECO
{

	public ZString EDID = null;

	public PERK(Record recordData)
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
			else if (sr.getType().equals("FULL"))
			{

			}
			else if (sr.getType().equals("DESC"))
			{

			}

			else if (sr.getType().equals("DATA"))
			{

			}
			else if (sr.getType().equals("PRKE"))
			{

			}
			else if (sr.getType().equals("PRKF"))
			{

			}
			else if (sr.getType().equals("PRKC"))
			{

			}
			else if (sr.getType().equals("CTDA"))
			{

			}
			else if (sr.getType().equals("EPFT"))
			{

			}
			else if (sr.getType().equals("EPFD"))
			{

			}
			else if (sr.getType().equals("EPF2"))
			{

			}
			else if (sr.getType().equals("EPF3"))
			{

			}
			else if (sr.getType().equals("CIS2"))
			{

			}
			else if (sr.getType().equals("NNAM"))
			{

			}
			else if (sr.getType().equals("VMAD"))
			{

			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
