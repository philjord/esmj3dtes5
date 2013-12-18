package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class FACT extends RECO
{

	public ZString EDID = null;

	public FACT(Record recordData)
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
			else if (sr.getType().equals("XNAM"))
			{
			}
			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("CRVA"))
			{
			}
			else if (sr.getType().equals("VENV"))
			{
			}
			else if (sr.getType().equals("FULL"))
			{
			}
			else if (sr.getType().equals("VEND"))
			{
			}
			else if (sr.getType().equals("VENC"))
			{
			}
			else if (sr.getType().equals("PLVD"))
			{
			}
			else if (sr.getType().equals("WAIT"))
			{
			}
			else if (sr.getType().equals("STOL"))
			{
			}
			else if (sr.getType().equals("PLCN"))
			{
			}
			else if (sr.getType().equals("CRGR"))
			{
			}
			else if (sr.getType().equals("JOUT"))
			{
			}
			else if (sr.getType().equals("RNAM"))
			{
			}
			else if (sr.getType().equals("MNAM"))
			{
			}
			else if (sr.getType().equals("JAIL"))
			{
			}
			else if (sr.getType().equals("CITC"))
			{
			}
			else if (sr.getType().equals("CTDA"))
			{
			}
			else if (sr.getType().equals("CIS2"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
