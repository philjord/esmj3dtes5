package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.GenericCONT;
import esmj3d.data.shared.subrecords.FormID;

public class CONT extends GenericCONT
{
	public FormID FULL2;

	public byte[] MNAM = null;

	public CONT(Record recordData)
	{

		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getData();

			if (sr.getType().equals("OBND"))
			{

			}
			else if (sr.getType().equals("FULL"))
			{
				FULL2 = new FormID(bs);
			}
			else if (sr.getType().equals("DATA"))
			{

			}
			else if (sr.getType().equals("MNAM"))
			{
				MNAM = bs;
			}
			else if (sr.getType().equals("COCT"))
			{

			}
			else if (sr.getType().equals("VMAD"))
			{

			}
			else if (sr.getType().equals("COED"))
			{

			}
			else
			{
				//System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}

}
