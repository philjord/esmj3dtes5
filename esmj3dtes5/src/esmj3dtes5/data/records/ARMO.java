package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class ARMO extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public FormID MODL;

	public MODL MOD2; // male  

	public MODL MOD4; // female  

	public ARMO(Record recordData)
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
				MODL = new FormID(bs);
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

			else if (sr.getType().equals("BODT"))
			{
			}
			else if (sr.getType().equals("YNAM"))
			{
			}
			else if (sr.getType().equals("ZNAM"))
			{
			}
			else if (sr.getType().equals("RNAM"))
			{
			}
			else if (sr.getType().equals("KSIZ"))
			{
			}
			else if (sr.getType().equals("KWDA"))
			{
			}
			else if (sr.getType().equals("DESC"))
			{
			}

			else if (sr.getType().equals("DATA"))
			{
			}
			else if (sr.getType().equals("DNAM"))
			{
			}
			else if (sr.getType().equals("EITM"))
			{
			}
			else if (sr.getType().equals("ETYP"))
			{
			}
			else if (sr.getType().equals("BIDS"))
			{
			}
			else if (sr.getType().equals("BAMT"))
			{
			}
			else if (sr.getType().equals("TNAM"))
			{
			}

			else if (sr.getType().equals("VMAD"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}

}
