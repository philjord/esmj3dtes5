package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonCELL;
import esmj3d.data.shared.subrecords.FormID;

public class CELL extends CommonCELL
{

	public DATA DATA;

	public int XGLB = -1;

	public FormID LTMP = null;

	public FormID XCMO = null;

	public FormID XCAS = null;

	public FormID XEZN = null;

	public FormID XILL = null;

	public FormID XCIM;

	public CELL(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getData();

			if (sr.getType().equals("DATA"))
			{
				DATA = new DATA(bs);
			}
			else if (sr.getType().equals("TVDT"))
			{
			}
			else if (sr.getType().equals("MHDT"))
			{
			}
			else if (sr.getType().equals("FULL"))
			{
				// TES5 FULL is a formId of some sort, blank out the lstring from super
				FULL = null;
			}
			else if (sr.getType().equals("LTMP"))
			{
				LTMP = new FormID(bs);
			}
			else if (sr.getType().equals("XCMO"))
			{
				XCMO = new FormID(bs);
			}
			else if (sr.getType().equals("XCIM"))
			{
				XCIM = new FormID(bs);
			}
			else if (sr.getType().equals("XCAS"))
			{
				XCAS = new FormID(bs);
			}
			else if (sr.getType().equals("XWEM"))
			{
			}
			else if (sr.getType().equals("XILL"))
			{
				XILL = new FormID(bs);
			}
			else if (sr.getType().equals("LNAM"))
			{
			}
			else if (sr.getType().equals("XNAM"))
			{
			}
			else if (sr.getType().equals("XWCS"))
			{
			}
			else if (sr.getType().equals("XWCU"))
			{
			}
			else if (sr.getType().equals("XWCN"))
			{
			}
			else if (sr.getType().equals("XLCN"))
			{

			}
			else if (sr.getType().equals("XEZN"))
			{
				XEZN = new FormID(bs);
			}
			else
			{
				// no longer possible with CommonCELL
				//System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}

		}
	}

	public String showDetails()
	{
		return "CELL : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str;
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
