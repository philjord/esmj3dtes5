package esmj3dtes5.data.records;

import java.util.ArrayList;
import java.util.List;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.InstRECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.ZString;

public class CELL extends InstRECO
{
	public ZString EDID;

	public FormID FULL;

	public DATA DATA;

	public FormID XOWN = null;

	public int XGLB = -1;

	public FormID XCCM = null;

	public FormID XCWT = null;

	public byte[] XCLL = null; //Lighting for interior cell

	public List<FormID> XCLRs = new ArrayList<FormID>(); // array of region ids

	public float XCLW = 0; //water height if not 0

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
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("EDID"))
			{
				EDID = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{
				DATA = new DATA(bs);
			}
			else if (sr.getSubrecordType().equals("XCLC"))
			{
				x = ESMByteConvert.extractInt(bs, 0);
				y = ESMByteConvert.extractInt(bs, 4);
			}
			else if (sr.getSubrecordType().equals("XCLL"))
			{
				XCLL = bs;
			}
			else if (sr.getSubrecordType().equals("TVDT"))
			{
			}
			else if (sr.getSubrecordType().equals("XCLR"))
			{
				XCLRs.add(new FormID(bs));
			}
			else if (sr.getSubrecordType().equals("XCLW"))
			{
				XCLW = ESMByteConvert.extractFloat(bs, 0);
			}

			else if (sr.getSubrecordType().equals("MHDT"))
			{
			}
			else if (sr.getSubrecordType().equals("LTMP"))
			{
				LTMP = new FormID(bs);
			}

			else if (sr.getSubrecordType().equals("XCWT"))
			{
				XCWT = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XCMO"))
			{
				XCMO = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XCIM"))
			{
				XCIM = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XCAS"))
			{
				XCAS = new FormID(bs);
			}

			else if (sr.getSubrecordType().equals("XWEM"))
			{
			}
			else if (sr.getSubrecordType().equals("XILL"))
			{
				XILL = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XOWN"))
			{
				XOWN = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XCCM"))
			{
				XCCM = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("LNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("XNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("XWCS"))
			{
			}
			else if (sr.getSubrecordType().equals("XWCU"))
			{
			}
			else if (sr.getSubrecordType().equals("XWCN"))
			{
			}
			else if (sr.getSubrecordType().equals("XLCN"))
			{

			}
			else if (sr.getSubrecordType().equals("XEZN"))
			{
				XEZN = new FormID(bs);
			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
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
