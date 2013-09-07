package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonREFR;
import esmj3dtes5.data.subrecords.XACT;
import esmj3dtes5.data.subrecords.XCNT;
import esmj3dtes5.data.subrecords.XESP;
import esmj3dtes5.data.subrecords.XLCM;
import esmj3dtes5.data.subrecords.XPCI;
import esmj3dtes5.data.subrecords.XSED;

public class REFR extends CommonREFR
{

	public XSED XSED;

	public XPCI XPCI;

	public XESP XESP;

	public XLCM XLCM;

	public XACT XACT;

	public XCNT XCNT;

	public REFR(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("XSED"))
			{
				XSED = new XSED(bs);
			}
			else if (sr.getSubrecordType().equals("XPCI"))
			{
				XPCI = new XPCI(bs);
			}
			else if (sr.getSubrecordType().equals("XESP"))
			{
				XESP = new XESP(bs);
			}
			else if (sr.getSubrecordType().equals("XLCM"))
			{
				XLCM = new XLCM(bs);
			}
			else if (sr.getSubrecordType().equals("XACT"))
			{
				XACT = new XACT(bs);
			}
			else if (sr.getSubrecordType().equals("XCNT"))
			{
				XCNT = new XCNT(bs);
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
				//CommonREFR makes this no use now
				//	System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}
		}

	}
}
