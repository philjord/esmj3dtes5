package esmj3dtes5.data.records;

import java.util.ArrayList;
import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;


public class OTFT extends RECO
{
	

	public ArrayList<FormID> INAMs = new ArrayList<FormID>();

	public OTFT(Record recordData)
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
			else if (sr.getSubrecordType().equals("INAM"))
			{
				for (int fid = 0; fid < bs.length; fid += 4)
				{
					byte[] inbs = new byte[4];
					System.arraycopy(bs, fid, inbs, 0, 4);
					INAMs.add(new FormID(inbs));
				}
			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
