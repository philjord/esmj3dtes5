package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODB;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class RACE extends RECO
{
	public ZString EDID = null;

	public FormID FULL = null;

	public MODL[] MODLs = null;

	public MODB[] MODBs = null;

	public ZString[] ICONs = null;

	public RACE(Record recordData)
	{
		super(recordData);

		ArrayList<MODL> MODLsl = new ArrayList<MODL>();

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
			else if (sr.getSubrecordType().equals("DESC"))
			{
			}
			else if (sr.getSubrecordType().equals("MODL"))
			{
				MODLsl.add(new MODL(bs));
			}
			else if (sr.getSubrecordType().equals("MODT"))
			{
			}
			else if (sr.getSubrecordType().equals("WNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("BODT"))
			{
			}
			else if (sr.getSubrecordType().equals("KSIZ"))
			{
			}
			else if (sr.getSubrecordType().equals("KWDA"))
			{
			}
			else if (sr.getSubrecordType().equals("DATA"))
			{
			}
			else if (sr.getSubrecordType().equals("MNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("ANAM"))
			{
			}

			else if (sr.getSubrecordType().equals("FNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("MTNM"))
			{
			}
			else if (sr.getSubrecordType().equals("VTCK"))
			{
			}
			else if (sr.getSubrecordType().equals("PNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("UNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("ATKD"))
			{
			}
			else if (sr.getSubrecordType().equals("ATKE"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM1"))
			{
			}
			else if (sr.getSubrecordType().equals("INDX"))
			{
			}

			else if (sr.getSubrecordType().equals("GNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM3"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM4"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM5"))
			{
			}
			else if (sr.getSubrecordType().equals("ONAM"))
			{
			}
			else if (sr.getSubrecordType().equals("LNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("NAME"))
			{
			}
			else if (sr.getSubrecordType().equals("VNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("QNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("UNES"))
			{
			}
			else if (sr.getSubrecordType().equals("HCLF"))
			{
			}
			else if (sr.getSubrecordType().equals("TINL"))
			{
			}
			else if (sr.getSubrecordType().equals("PHWT"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM0"))
			{
			}
			else if (sr.getSubrecordType().equals("HEAD"))
			{
			}
			else if (sr.getSubrecordType().equals("MPAI"))
			{
			}
			else if (sr.getSubrecordType().equals("MPAV"))
			{
			}
			else if (sr.getSubrecordType().equals("AHCM"))
			{
			}
			else if (sr.getSubrecordType().equals("TINI"))
			{
			}
			else if (sr.getSubrecordType().equals("TINT"))
			{
			}
			else if (sr.getSubrecordType().equals("TINP"))
			{
			}
			else if (sr.getSubrecordType().equals("TIND"))
			{
			}
			else if (sr.getSubrecordType().equals("TINC"))
			{
			}
			else if (sr.getSubrecordType().equals("TINV"))
			{
			}
			else if (sr.getSubrecordType().equals("TIRS"))
			{
			}
			else if (sr.getSubrecordType().equals("AHCF"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM8"))
			{
			}
			else if (sr.getSubrecordType().equals("SPCT"))
			{
			}
			else if (sr.getSubrecordType().equals("SPLO"))
			{
			}
			else if (sr.getSubrecordType().equals("DNAM"))
			{
			}
			else if (sr.getSubrecordType().equals("NAM7"))
			{
			}
			else if (sr.getSubrecordType().equals("RPRM"))
			{
			}
			else if (sr.getSubrecordType().equals("RPRF"))
			{
			}
			else if (sr.getSubrecordType().equals("FTSF"))
			{
			}
			else if (sr.getSubrecordType().equals("DFTF"))
			{
			}
			else if (sr.getSubrecordType().equals("PHTN"))
			{
			}
			else if (sr.getSubrecordType().equals("WKMV"))
			{
			}
			else if (sr.getSubrecordType().equals("RNMV"))
			{
			}
			else if (sr.getSubrecordType().equals("SWMV"))
			{
			}
			else if (sr.getSubrecordType().equals("FLMV"))
			{
			}
			else if (sr.getSubrecordType().equals("SNMV"))
			{
			}
			else if (sr.getSubrecordType().equals("MTYP"))
			{
			}
			else if (sr.getSubrecordType().equals("SPED"))
			{
			}
			else if (sr.getSubrecordType().equals("FTSM"))
			{
			}
			else if (sr.getSubrecordType().equals("DFTM"))
			{
			}
			else if (sr.getSubrecordType().equals("RNAM"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}

		}
		// transfer to arrays

		MODLs = new MODL[MODLsl.size()];
		MODLsl.toArray(MODLs);

	}

}
