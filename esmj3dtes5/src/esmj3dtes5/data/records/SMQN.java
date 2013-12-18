package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class SMQN extends RECO
{
	public ZString EDID;

	public SMQN(Record recordData)
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
			else if (sr.getType().equals("SNAM")){}
			else if (sr.getType().equals("CITC")){}
			else if (sr.getType().equals("CTDA")){}
			else if (sr.getType().equals("DNAM")){}
			else if (sr.getType().equals("XNAM")){}
			else if (sr.getType().equals("QNAM")){}
			else if (sr.getType().equals("NNAM")){}
			else if (sr.getType().equals("CIS2")){}
			else if (sr.getType().equals("RNAM")){}
			else if (sr.getType().equals("MNAM")){}
			else if (sr.getType().equals("FNAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
