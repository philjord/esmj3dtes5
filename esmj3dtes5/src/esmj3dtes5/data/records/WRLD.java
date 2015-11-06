package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.CommonWRLD;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class WRLD extends CommonWRLD
{

	public WRLD(Record recordData)
	{
		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			//byte[] bs = sr.getSubrecordData();

			if (sr.getType().equals("NAM0"))
			{
				//
			}
			else if (sr.getType().equals("NAM9"))
			{
				//
			}
			else if (sr.getType().equals("OFST"))
			{
				//
			}
			else if (sr.getType().equals("MNAM"))
			{
				//
			}
			else if (sr.getType().equals("RNAM"))
			{
				//
			}
			else if (sr.getType().equals("NAM3"))
			{
				//
			}
			else if (sr.getType().equals("NAM4"))
			{
				//
			}
			else if (sr.getType().equals("DNAM"))
			{
				//
			}
			else if (sr.getType().equals("ONAM"))
			{
				//
			}
			else if (sr.getType().equals("NAMA"))
			{
				//
			}
			else if (sr.getType().equals("ZNAM"))
			{
				//
			}
			else if (sr.getType().equals("TNAM"))
			{
				//
			}
			else if (sr.getType().equals("UNAM"))
			{
				//
			}
			else
			{
				//System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

	public String showDetails()
	{
		return "WRLD : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str;
	}

}
