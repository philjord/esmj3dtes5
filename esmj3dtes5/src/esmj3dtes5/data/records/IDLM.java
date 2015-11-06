package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.DNAM;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class IDLM extends RECO
{
	public ZString EDID = null;

	public DNAM DNAM = null;

	//data data

	public IDLM(Record recordData)
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

			}
			else if (sr.getType().equals("IDLA"))
			{

			}
			else if (sr.getType().equals("IDLF"))
			{

			}
			else if (sr.getType().equals("IDLC"))
			{

			}
			else if (sr.getType().equals("IDLT"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
