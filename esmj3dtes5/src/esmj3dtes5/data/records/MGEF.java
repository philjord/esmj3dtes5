package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class MGEF extends RECO
{

	public ZString EDID = null;

	public MGEF(Record recordData)
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
			else if (sr.getType().equals("MDOB"))
			{
			}
			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("SNDD"))
			{
			}
			else if (sr.getType().equals("DNAM"))
			{
			}
			else if (sr.getType().equals("CTDA"))
			{
			}
			else if (sr.getType().equals("KSIZ"))
			{
			}
			else if (sr.getType().equals("KWDA"))
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
