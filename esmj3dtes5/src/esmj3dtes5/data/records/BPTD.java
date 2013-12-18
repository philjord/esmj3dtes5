package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class BPTD extends RECO
{

	public ZString EDID = null;

	public MODL MODL = null;

	public BPTD(Record recordData)
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
			else if (sr.getType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}
			else if (sr.getType().equals("BPTN"))
			{

			}
			else if (sr.getType().equals("BPNN"))
			{

			}
			else if (sr.getType().equals("BPNT"))
			{

			}
			else if (sr.getType().equals("BPNI"))
			{

			}
			else if (sr.getType().equals("BPND"))
			{

			}
			else if (sr.getType().equals("NAM1"))
			{

			}
			else if (sr.getType().equals("NAM4"))
			{

			}
			else if (sr.getType().equals("NAM5"))
			{

			}
			else if (sr.getType().equals("RAGA"))
			{

			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
