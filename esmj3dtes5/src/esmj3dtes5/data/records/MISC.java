package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.OBND;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.shared.subrecords.KeyWords;

public class MISC extends RECO
{
	public ZString EDID;

	public OBND OBND;

	public FormID FULL;

	public MODL MODL;

	public DATA DATA;

	public ZString ICON;

	public ZString MICO;

	public FormID YNAM;

	public FormID ZNAM;

	public KeyWords keyWords = new KeyWords();

	public MISC(Record recordData)
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
			else if (sr.getType().equals("VMAD"))
			{

			}
			else if (sr.getType().equals("OBND"))
			{
				OBND = new OBND(bs);
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
			else if (sr.getType().equals("ICON"))
			{
				ICON = new ZString(bs);
			}
			else if (sr.getType().equals("MICO"))
			{
				MICO = new ZString(bs);
			}
			else if (sr.getType().equals("DEST"))
			{

			}
			else if (sr.getType().equals("DSTD"))
			{

			}
			else if (sr.getType().equals("DMDL"))
			{

			}
			else if (sr.getType().equals("DMDT"))
			{

			}
			else if (sr.getType().equals("DMDS"))
			{

			}
			else if (sr.getType().equals("DSTF"))
			{

			}
			else if (sr.getType().equals("YNAM"))
			{
				YNAM = new FormID(bs);
			}
			else if (sr.getType().equals("ZNAM"))
			{
				ZNAM = new FormID(bs);
			}
			else if (sr.getType().equals("KSIZ"))
			{
				keyWords.setKSIZ(bs);
			}
			else if (sr.getType().equals("KWDA"))
			{
				keyWords.setKWDA(bs);
			}
			else if (sr.getType().equals("DATA"))
			{
				DATA = new DATA(bs);
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}

	public String showDetails()
	{
		return "MISC : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str + " : " + MODL.model.str;
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
