package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.CNTO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.OBND;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.shared.subrecords.KeyWords;
import esmj3dtes5.data.subrecords.ACBS;
import esmj3dtes5.data.subrecords.AIDT;
import esmj3dtes5.data.subrecords.SNAM;

public class NPC_ extends RECO
{
	public ZString EDID = null;

	public OBND OBND;

	public FormID INAM = null;

	public FormID RNAM = null;

	public FormID VTCK;

	public FormID TPLT;

	public FormID FULL = null;

	public ACBS ACBS = null;

	public ArrayList<SNAM> SNAMs = new ArrayList<SNAM>();

	public ArrayList<FormID> SPLOs = new ArrayList<FormID>();

	public ArrayList<CNTO> CNTOs = new ArrayList<CNTO>();

	public AIDT AIDT = null;

	public ArrayList<FormID> PKIDs = new ArrayList<FormID>();

	public FormID CNAM = null;

	public DATA DATA = null;

	public FormID ATKR;

	public FormID SPOR;

	public FormID OCOR;

	public FormID GWOR;

	public FormID ECOR;

	public KeyWords keyWords = new KeyWords();

	public FormID SHRT;

	public FormID PNAM;

	public FormID HCLF;

	public FormID ZNAM;

	public FormID GNAM;

	public FormID CSCR;

	public FormID DOFT;

	public FormID SOFT;

	public FormID DLPT;

	public FormID CRIF;

	public FormID FTST;

	public FormID WNAM;

	public NPC_(Record recordData)
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
			else if (sr.getType().equals("ACBS"))
			{
				ACBS = new ACBS(bs);
			}
			else if (sr.getType().equals("SNAM"))
			{
				SNAMs.add(new SNAM(bs));
			}
			else if (sr.getType().equals("INAM"))
			{
				INAM = new FormID(bs);
			}
			else if (sr.getType().equals("VTCK"))
			{
				VTCK = new FormID(bs);
			}
			else if (sr.getType().equals("TPLT"))
			{
				TPLT = new FormID(bs);
			}
			else if (sr.getType().equals("RNAM"))
			{
				RNAM = new FormID(bs);
			}
			else if (sr.getType().equals("WNAM"))
			{
				WNAM = new FormID(bs);
			}
			else if (sr.getType().equals("ANAM"))
			{

			}
			else if (sr.getType().equals("ATKR"))
			{
				ATKR = new FormID(bs);
			}
			else if (sr.getType().equals("ATKD"))
			{

			}
			else if (sr.getType().equals("ATKE"))
			{

			}
			else if (sr.getType().equals("SPOR"))
			{
				SPOR = new FormID(bs);
			}
			else if (sr.getType().equals("OCOR"))
			{
				OCOR = new FormID(bs);
			}
			else if (sr.getType().equals("GWOR"))
			{
				GWOR = new FormID(bs);
			}
			else if (sr.getType().equals("ECOR"))
			{
				ECOR = new FormID(bs);
			}
			else if (sr.getType().equals("COCT"))
			{

			}
			else if (sr.getType().equals("CNTO"))
			{
				CNTOs.add(new CNTO(bs));

			}
			else if (sr.getType().equals("COED"))
			{

			}
			else if (sr.getType().equals("AIDT"))
			{

			}
			else if (sr.getType().equals("PKID"))
			{
				PKIDs.add(new FormID(bs));
			}
			else if (sr.getType().equals("KSIZ"))
			{
				keyWords.setKSIZ(bs);
			}
			else if (sr.getType().equals("KWDA"))
			{
				keyWords.setKWDA(bs);
			}
			else if (sr.getType().equals("CNAM"))
			{
				CNAM = new FormID(bs);
			}

			else if (sr.getType().equals("SPCT"))
			{

			}
			else if (sr.getType().equals("SPLO"))
			{
				SPLOs.add(new FormID(bs));
			}
			else if (sr.getType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getType().equals("SHRT"))
			{
				SHRT = new FormID(bs);
			}
			else if (sr.getType().equals("DATA"))
			{
				DATA = new DATA(bs);
			}
			else if (sr.getType().equals("DNAM"))
			{

			}
			else if (sr.getType().equals("PNAM"))
			{
				PNAM = new FormID(bs);
			}
			else if (sr.getType().equals("HCLF"))
			{
				HCLF = new FormID(bs);
			}
			else if (sr.getType().equals("ZNAM"))
			{
				ZNAM = new FormID(bs);
			}
			else if (sr.getType().equals("GNAM"))
			{
				GNAM = new FormID(bs);
			}
			else if (sr.getType().equals("NAM5"))
			{

			}
			else if (sr.getType().equals("NAM6"))
			{

			}
			else if (sr.getType().equals("NAM7"))
			{

			}
			else if (sr.getType().equals("NAM8"))
			{

			}
			else if (sr.getType().equals("CSDT"))
			{

			}
			else if (sr.getType().equals("CSDI"))
			{

			}
			else if (sr.getType().equals("CSDC"))
			{

			}
			else if (sr.getType().equals("CSCR"))
			{
				CSCR = new FormID(bs);
			}
			else if (sr.getType().equals("DOFT"))
			{
				DOFT = new FormID(bs);
			}
			else if (sr.getType().equals("SOFT"))
			{
				SOFT = new FormID(bs);
			}
			else if (sr.getType().equals("DLPT"))
			{
				DLPT = new FormID(bs);
			}
			else if (sr.getType().equals("CRIF"))
			{
				CRIF = new FormID(bs);
			}
			else if (sr.getType().equals("FTST"))
			{
				FTST = new FormID(bs);
			}
			else if (sr.getType().equals("QNAM"))
			{

			}
			else if (sr.getType().equals("NAM9"))
			{

			}
			else if (sr.getType().equals("NAMA"))
			{

			}
			else if (sr.getType().equals("TINI"))
			{

			}
			else if (sr.getType().equals("TINC"))
			{

			}
			else if (sr.getType().equals("TINV"))
			{

			}
			else if (sr.getType().equals("TIAS"))
			{

			}

			else if (sr.getType().equals("DPLT"))
			{

			}
			else if (sr.getType().equals("PRKR"))
			{

			}
			else if (sr.getType().equals("PRKZ"))
			{

			}
			else if (sr.getType().equals("DEST"))
			{

			}
			else if (sr.getType().equals("DSTD"))
			{

			}
			else if (sr.getType().equals("DSTF"))
			{

			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
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
