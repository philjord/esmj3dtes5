package esmj3dtes5.data.records;

import java.util.ArrayList;

import utils.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.InstRECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.XTEL;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.FNAM;
import esmj3dtes5.data.subrecords.TNAM_c;
import esmj3dtes5.data.subrecords.XACT;
import esmj3dtes5.data.subrecords.XCNT;
import esmj3dtes5.data.subrecords.XESP;
import esmj3dtes5.data.subrecords.XLCM;
import esmj3dtes5.data.subrecords.XLOC;
import esmj3dtes5.data.subrecords.XLOD;
import esmj3dtes5.data.subrecords.XPCI;
import esmj3dtes5.data.subrecords.XRNK;
import esmj3dtes5.data.subrecords.XSED;

public class REFR extends InstRECO
{

	public ZString EDID;

	public FormID NAME;

	public boolean XMRK = false;

	public FNAM FNAM;

	public FormID XOWN;

	public XRNK XRNK;

	public FormID XGLB;

	public XTEL XTEL;

	public FormID XTRG;

	public XSED XSED;

	public XLOD XLOD;

	public XLOC XLOC;

	public XPCI XPCI;

	public XESP XESP;

	public XLCM XLCM;

	public FormID XRTM;

	public XACT XACT;

	public XCNT XCNT;

	public FormID FULL;

	public TNAM_c TNAM;

	public boolean ONAM = false;

	public REFR(Record recordData)
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
			else if (sr.getSubrecordType().equals("NAME"))
			{
				NAME = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XMRK"))
			{
				XMRK = true;
			}
			else if (sr.getSubrecordType().equals("FNAM"))
			{
				FNAM = new FNAM(bs);
			}
			else if (sr.getSubrecordType().equals("XOWN"))
			{
				XOWN = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XRNK"))
			{
				XRNK = new XRNK(bs);
			}
			else if (sr.getSubrecordType().equals("XGLB"))
			{
				XGLB = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XSCL"))
			{
				scale = ESMByteConvert.extractFloat(bs, 0);
			}
			else if (sr.getSubrecordType().equals("XTEL"))
			{
				XTEL = new XTEL(bs);
			}
			else if (sr.getSubrecordType().equals("XTRG"))
			{
				XTRG = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XSED"))
			{
				XSED = new XSED(bs);
			}
			else if (sr.getSubrecordType().equals("XLOD"))
			{
				XLOD = new XLOD(bs);
			}
			else if (sr.getSubrecordType().equals("XPCI"))
			{
				XPCI = new XPCI(bs);
			}
			else if (sr.getSubrecordType().equals("XLOC"))
			{
				XLOC = new XLOC(bs);
			}
			else if (sr.getSubrecordType().equals("XESP"))
			{
				XESP = new XESP(bs);
			}
			else if (sr.getSubrecordType().equals("XLCM"))
			{
				XLCM = new XLCM(bs);
			}
			else if (sr.getSubrecordType().equals("XRTM"))
			{
				XRTM = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("XACT"))
			{
				XACT = new XACT(bs);
			}
			else if (sr.getSubrecordType().equals("XCNT"))
			{
				XCNT = new XCNT(bs);
			}
			else if (sr.getSubrecordType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("TNAM"))
			{
				TNAM = new TNAM_c(bs);
			}
			else if (sr.getSubrecordType().equals("ONAM"))
			{
				ONAM = true;
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{
				this.extractInstData(bs);
			}
			else if (sr.getSubrecordType().equals("VMAD"))
			{
			}
			else if (sr.getSubrecordType().equals("XPRM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLCM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLKR"))
			{
			}
			else if (sr.getSubrecordType().equals("XLCN"))
			{
			}
			else if (sr.getSubrecordType().equals("XNDP"))
			{
			}
			else if (sr.getSubrecordType().equals("XMBO"))
			{
			}
			else if (sr.getSubrecordType().equals("XRMR"))
			{
			}
			else if (sr.getSubrecordType().equals("XPRD"))
			{
			}
			else if (sr.getSubrecordType().equals("XPPA"))
			{
			}
			else if (sr.getSubrecordType().equals("PDTO"))
			{
			}
			else if (sr.getSubrecordType().equals("INAM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLRM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLCM"))
			{
			}
			else if (sr.getSubrecordType().equals("XLKR"))
			{
			}
			else if (sr.getSubrecordType().equals("XEMI"))
			{
			}
			else if (sr.getSubrecordType().equals("XLIB"))
			{
			}
			else if (sr.getSubrecordType().equals("XRDS"))
			{
			}
			else if (sr.getSubrecordType().equals("XLIG"))
			{
			}
			else if (sr.getSubrecordType().equals("XALP"))
			{
			}
			else if (sr.getSubrecordType().equals("XRGD"))
			{
			}
			else if (sr.getSubrecordType().equals("XPOD"))
			{
			}
			else if (sr.getSubrecordType().equals("XLRT"))
			{
			}
			else if (sr.getSubrecordType().equals("XMBR"))
			{

			}
			else if (sr.getSubrecordType().equals("XTRI"))
			{

			}
			else if (sr.getSubrecordType().equals("XAPD"))
			{
			}
			else if (sr.getSubrecordType().equals("XAPR"))
			{
			}
			else if (sr.getSubrecordType().equals("XTNM"))
			{

			}
			else if (sr.getSubrecordType().equals("XWCU"))
			{

			}
			else if (sr.getSubrecordType().equals("XWCN"))
			{

			}
			else if (sr.getSubrecordType().equals("XIS2"))
			{

			}
			else if (sr.getSubrecordType().equals("XPWR"))
			{

			}
			else if (sr.getSubrecordType().equals("XEZN"))
			{

			}
			else if (sr.getSubrecordType().equals("XOCP"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}
		}

	}

}
