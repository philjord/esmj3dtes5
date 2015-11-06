package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class DIAL extends RECO
{

	public ZString EDID = null;

	public DIAL(Record recordData)
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
			else if (sr.getType().equals("PNAM")){}
			else if (sr.getType().equals("QNAM")){}
			else if (sr.getType().equals("DATA")){}
			else if (sr.getType().equals("SNAM")){}
			else if (sr.getType().equals("TIFC")){}
			else if (sr.getType().equals("EDID")){}
			else if (sr.getType().equals("FULL")){}
			else if (sr.getType().equals("BNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
