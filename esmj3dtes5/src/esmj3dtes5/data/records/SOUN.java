package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class SOUN extends RECO
{
	public ZString EDID = null;

	public ZString FNAM = null;

	public SOUN(Record recordData)
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
			else if (sr.getType().equals("OBND"))
			{
				//
			}
			else if (sr.getType().equals("SDSC"))
			{

			}
			else if (sr.getType().equals("SNDD"))
			{
				//
			}
			else if (sr.getType().equals("FNAM"))
			{
				FNAM = new ZString(bs);
			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

	public String showDetails()
	{
		return "SOUN : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str;
	}

}
