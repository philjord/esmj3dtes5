package esmj3dtes5.data.records;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.GenericDOOR;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.LString;

public class DOOR extends GenericDOOR
{
	public FormID FULL2;

	public int TNAM = -1; //random teleport destination

	public DOOR(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{

			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getData();

			if (sr.getType().equals("FULL"))
			{		
				FULL = new LString(bs);
				FULL2 = new FormID(bs);
			}
			else if (sr.getType().equals("OBND"))
			{

			}
			else if (sr.getType().equals("TNAM"))
			{
				TNAM = ESMByteConvert.extractInt(bs, 0);
			}
			else if (sr.getType().equals("VMAD"))
			{

			}
			else
			{
				//	System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}
}
