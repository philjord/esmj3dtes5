package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class WTHR extends RECO
{
	public ZString EDID = null;

	public WTHR(Record recordData)
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
			else if (sr.getType().endsWith("0TX"))
			{
				//Clouds dds strings from 00TX to L0TX by acsii number, odd 
			}
			else if (sr.getType().equals("LNAM"))
			{
			}
			else if (sr.getType().equals("MNAM"))
			{
			}
			else if (sr.getType().equals("NNAM"))
			{
			}
			else if (sr.getType().equals("RNAM"))
			{
			}
			else if (sr.getType().equals("QNAM"))
			{
			}
			else if (sr.getType().equals("PNAM"))
			{
			}
			else if (sr.getType().equals("JNAM"))
			{
			}
			else if (sr.getType().equals("NAM0"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("NAM1"))
			{
			}
			else if (sr.getType().equals("SNAM"))
			{
			}
			else if (sr.getType().equals("TNAM"))
			{
			}
			else if (sr.getType().equals("IMSP"))
			{
			}
			else if (sr.getType().equals("DALC"))
			{
			}
			else if (sr.getType().equals("MODL"))
			{
			}
			else if (sr.getType().equals("MODT"))
			{
			}
			else if (sr.getType().equals("NAM2"))
			{
			}
			else if (sr.getType().equals("NAM3"))
			{
			}
			else if (sr.getType().equals("DNAM"))
			{
			}
			else if (sr.getType().equals("CNAM"))
			{
			}
			else if (sr.getType().equals("ANAM"))
			{
			}
			else if (sr.getType().equals("BNAM"))
			{
			}
			else if (sr.getType().equals("ONAM"))
			{
			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
