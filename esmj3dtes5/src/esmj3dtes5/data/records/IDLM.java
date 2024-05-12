package esmj3dtes5.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;

import esmj3dtes5.data.subrecords.DNAM;

public class IDLM extends RECO
{
	

	public DNAM DNAM = null;

	//data data

	public IDLM(Record recordData)
	{
		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				setEDID(bs);
			}
			else if (sr.getSubrecordType().equals("OBND"))
			{

			}
			else if (sr.getSubrecordType().equals("IDLA"))
			{

			}
			else if (sr.getSubrecordType().equals("IDLF"))
			{

			}
			else if (sr.getSubrecordType().equals("IDLC"))
			{

			}
			else if (sr.getSubrecordType().equals("IDLT"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
