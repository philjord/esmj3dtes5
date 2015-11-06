package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.BODT;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class ARMA extends RECO
{
	public ZString EDID;

	public FormID RNAM;

	public BODT BODT;

	public MODL MOD2;

	public MODL MOD3;

	public MODL MOD4;

	public MODL MOD5;

	public FormID MODL;

	public FormID NAM0;

	public FormID NAM1;

	public FormID NAM2;

	public FormID NAM3;

	public FormID SNDD;

	public FormID ONAM;

	public ARMA(Record recordData)
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
			else if (sr.getType().equals("BODT"))
			{
				BODT = new BODT(bs);
			}
			else if (sr.getType().equals("BOD2"))
			{

			}
			else if (sr.getType().equals("RNAM"))
			{
				RNAM = new FormID(bs);
			}
			else if (sr.getType().equals("DNAM"))
			{

			}

			else if (sr.getType().equals("MOD2"))
			{
				MOD2 = new MODL(bs);
			}
			else if (sr.getType().equals("MO2T"))
			{
				MOD2.addMODTSub(bs);
			}
			else if (sr.getType().equals("MO2S"))
			{
				MOD2.addMODSSub(bs);
			}
			else if (sr.getType().equals("MOD3"))
			{
				MOD3 = new MODL(bs);
			}
			else if (sr.getType().equals("MO3T"))
			{
				MOD3.addMODTSub(bs);
			}
			else if (sr.getType().equals("MO3S"))
			{
				MOD3.addMODSSub(bs);
			}
			else if (sr.getType().equals("MOD4"))
			{
				MOD4 = new MODL(bs);
			}
			else if (sr.getType().equals("MO4T"))
			{
				MOD4.addMODTSub(bs);
			}
			else if (sr.getType().equals("MO4S"))
			{
				MOD4.addMODSSub(bs);
			}
			else if (sr.getType().equals("MOD5"))
			{
				MOD5 = new MODL(bs);
			}
			else if (sr.getType().equals("MO5T"))
			{
				MOD5.addMODTSub(bs);
			}
			else if (sr.getType().equals("MO5S"))
			{
				MOD5.addMODSSub(bs);
			}
			else if (sr.getType().equals("NAM0"))
			{
				NAM0 = new FormID(bs);
			}
			else if (sr.getType().equals("NAM1"))
			{
				NAM1 = new FormID(bs);
			}
			else if (sr.getType().equals("NAM2"))
			{
				NAM2 = new FormID(bs);
			}
			else if (sr.getType().equals("NAM3"))
			{
				NAM3 = new FormID(bs);
			}
			else if (sr.getType().equals("MODL"))
			{
				MODL = new FormID(bs);
			}
			else if (sr.getType().equals("SNDD"))
			{
				SNDD = new FormID(bs);
			}
			else if (sr.getType().equals("ONAM"))
			{
				ONAM = new FormID(bs);
			}

			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}
}
