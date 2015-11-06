package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class IPCT extends RECO
{

	public ZString EDID = null;

	public MODL MODL = null;

	public IPCT(Record recordData)
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

			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("DODT"))
			{
			}
			else if (sr.getType().equals("SNAM"))
			{
			}
			else if (sr.getType().equals("NAM1"))
			{
			}
			else if (sr.getType().equals("DNAM"))
			{
			}
			else if (sr.getType().equals("NAM2"))
			{
			}
			else if (sr.getType().equals("ENAM"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
