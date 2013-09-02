package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class ASTP extends RECO
{
	public ZString EDID;

	public ASTP(Record recordData)
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
			else if (sr.getSubrecordType().equals("MPRT")){}
			else if (sr.getSubrecordType().equals("FPRT")){}
			else if (sr.getSubrecordType().equals("MCHT")){}
			else if (sr.getSubrecordType().equals("FCHT")){}
			else if (sr.getSubrecordType().equals("DATA")){}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}
		}
	}

}
