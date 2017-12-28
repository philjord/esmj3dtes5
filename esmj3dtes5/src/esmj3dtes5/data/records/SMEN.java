package esmj3dtes5.data.records;

import java.util.List;

import esmio.common.data.record.Record;
import esmio.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class SMEN extends RECO
{
	public ZString EDID;

	public SMEN(Record recordData)
	{
		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("PNAM")){}
			else if (sr.getSubrecordType().equals("SNAM")){}
			else if (sr.getSubrecordType().equals("CITC")){}
			else if (sr.getSubrecordType().equals("DNAM")){}
			else if (sr.getSubrecordType().equals("XNAM")){}
			else if (sr.getSubrecordType().equals("ENAM")){}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
