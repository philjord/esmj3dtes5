package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.ZString;

public class OTFT extends RECO
{
	public ZString EDID;

	public ArrayList<FormID> INAMs = new ArrayList<FormID>();

	public OTFT(Record recordData)
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
			else if (sr.getType().equals("INAM"))
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
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
