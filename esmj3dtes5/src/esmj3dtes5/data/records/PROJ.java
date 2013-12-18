package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class PROJ extends RECO
{
	public ZString EDID;

	public PROJ(Record recordData)
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
			else if (sr.getType().equals("OBND")){}
			else if (sr.getType().equals("MODL")){}
			else if (sr.getType().equals("MODT")){}
			else if (sr.getType().equals("DATA")){}
			else if (sr.getType().equals("NAM1")){}
			else if (sr.getType().equals("VNAM")){}
			else if (sr.getType().equals("FULL")){}
			else if (sr.getType().equals("DEST")){}
			else if (sr.getType().equals("DSTD")){}
			else if (sr.getType().equals("DSTF")){}
			else if (sr.getType().equals("NAM2")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
