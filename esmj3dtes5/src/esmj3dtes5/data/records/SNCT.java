package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class SNCT extends RECO
{
	public ZString EDID;

	public SNCT(Record recordData)
	{
		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("FULL")){}
			else if (sr.getSubrecordType().equals("FNAM")){}
			else if (sr.getSubrecordType().equals("PNAM")){}
			else if (sr.getSubrecordType().equals("VNAM")){}
			else if (sr.getSubrecordType().equals("UNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}
		}
	}

}
