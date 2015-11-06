package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class ALCH extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public MODL MODL;

	public ALCH(Record recordData)
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
			else if (sr.getType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}
			else if (sr.getType().equals("MODS"))
			{
				MODL.addMODSSub(bs);
			}
			else if (sr.getType().equals("DATA"))
			{

			}
			else if (sr.getType().equals("ENIT"))
			{

			}
			else if (sr.getType().equals("EFID"))
			{

			}
			else if (sr.getType().equals("EFIT"))
			{

			}
			else if (sr.getType().equals("KSIZ"))
			{

			}
			else if (sr.getType().equals("KWDA"))
			{
				//keywords
			}
			else if (sr.getType().equals("YNAM"))
			{

			}
			else if (sr.getType().equals("ZNAM"))
			{

			}
			else if (sr.getType().equals("CTDA"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

	public String showDetails()
	{
		return "ALCH : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str;
	}

	public class DATA
	{
		public byte[] data;

		private DATA(byte[] bytes)
		{
			data = bytes;
		}
	}
}
