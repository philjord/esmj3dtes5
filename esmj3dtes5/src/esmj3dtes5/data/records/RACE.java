package esmj3dtes5.data.records;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.BODT;

public class RACE extends RECO
{
	public ZString EDID = null;

	public FormID FULL = null;

	public FormID WNAM = null;

	public BODT BODT = null;

	public ZString maleSkeleton = null;

	public ZString femaleSkeleton = null;

	public RACE(Record recordData)
	{
		super(recordData);

		ArrayList<Subrecord> subrecords = recordData.getSubrecords();

		Subrecord sr = next(subrecords);
		EDID = new ZString(sr.getData());
		sr = next(subrecords);

		if (sr.getType().equals("FULL"))
		{
			FULL = new FormID(sr.getData());
			sr = next(subrecords);
		}

		//DESC = new LString(sr.getData());
		sr = next(subrecords);

		if (sr.getType().equals("SPCT"))
		{
			int sploCount = ESMByteConvert.extractInt(sr.getData(), 0);
			sr = next(subrecords);
			for (int i = 0; i < sploCount; i++)
			{
				//SPLO
				sr = next(subrecords);
			}
		}

		if (sr.getType().equals("WNAM"))
		{
			WNAM = new FormID(sr.getData());
			sr = next(subrecords);
		}

		BODT = new BODT(sr.getData());
		sr = next(subrecords);

		if (sr.getType().equals("KSIZ"))
		{
			int kwdaCount = ESMByteConvert.extractInt(sr.getData(), 0);
			sr = next(subrecords);
			//KWDA FormID * kwdaCount
			sr = next(subrecords);

		}

		//DATA
		sr = next(subrecords);

		//MNAM
		sr = next(subrecords);

		maleSkeleton = new ZString(sr.getData());
		sr = next(subrecords);

		//MODT
		sr = next(subrecords);

		//FNAM
		sr = next(subrecords);

		femaleSkeleton = new ZString(sr.getData());
		sr = next(subrecords);

		//MODT
		sr = next(subrecords);

		//TODO: finish this off from here
		//http://www.uesp.net/wiki/Tes5Mod:Mod_File_Format/RACE

		if (sr.getType().equals("MODL"))
		{

		}
		else if (sr.getType().equals("MODT"))
		{
		}
		else if (sr.getType().equals("WNAM"))
		{
		}

		else if (sr.getType().equals("MTNM"))
		{
		}
		else if (sr.getType().equals("VTCK"))
		{
		}
		else if (sr.getType().equals("PNAM"))
		{
		}
		else if (sr.getType().equals("UNAM"))
		{
		}
		else if (sr.getType().equals("ATKD"))
		{
		}
		else if (sr.getType().equals("ATKE"))
		{
		}
		else if (sr.getType().equals("NAM1"))
		{
		}
		else if (sr.getType().equals("INDX"))
		{
		}

		else if (sr.getType().equals("GNAM"))
		{
		}
		else if (sr.getType().equals("NAM3"))
		{
		}
		else if (sr.getType().equals("NAM4"))
		{
		}
		else if (sr.getType().equals("NAM5"))
		{
		}
		else if (sr.getType().equals("ONAM"))
		{
		}
		else if (sr.getType().equals("LNAM"))
		{
		}
		else if (sr.getType().equals("NAME"))
		{
		}
		else if (sr.getType().equals("VNAM"))
		{
		}
		else if (sr.getType().equals("QNAM"))
		{
		}
		else if (sr.getType().equals("UNES"))
		{
		}
		else if (sr.getType().equals("HCLF"))
		{
		}
		else if (sr.getType().equals("TINL"))
		{
		}
		else if (sr.getType().equals("PHWT"))
		{
		}
		else if (sr.getType().equals("NAM0"))
		{
		}
		else if (sr.getType().equals("HEAD"))
		{
		}
		else if (sr.getType().equals("MPAI"))
		{
		}
		else if (sr.getType().equals("MPAV"))
		{
		}
		else if (sr.getType().equals("AHCM"))
		{
		}
		else if (sr.getType().equals("TINI"))
		{
		}
		else if (sr.getType().equals("TINT"))
		{
		}
		else if (sr.getType().equals("TINP"))
		{
		}
		else if (sr.getType().equals("TIND"))
		{
		}
		else if (sr.getType().equals("TINC"))
		{
		}
		else if (sr.getType().equals("TINV"))
		{
		}
		else if (sr.getType().equals("TIRS"))
		{
		}
		else if (sr.getType().equals("AHCF"))
		{
		}
		else if (sr.getType().equals("NAM8"))
		{
		}
		else if (sr.getType().equals("DNAM"))
		{
		}
		else if (sr.getType().equals("NAM7"))
		{
		}
		else if (sr.getType().equals("RPRM"))
		{
		}
		else if (sr.getType().equals("RPRF"))
		{
		}
		else if (sr.getType().equals("FTSF"))
		{
		}
		else if (sr.getType().equals("DFTF"))
		{
		}
		else if (sr.getType().equals("PHTN"))
		{
		}
		else if (sr.getType().equals("WKMV"))
		{
		}
		else if (sr.getType().equals("RNMV"))
		{
		}
		else if (sr.getType().equals("SWMV"))
		{
		}
		else if (sr.getType().equals("FLMV"))
		{
		}
		else if (sr.getType().equals("SNMV"))
		{
		}
		else if (sr.getType().equals("MTYP"))
		{
		}
		else if (sr.getType().equals("SPED"))
		{
		}
		else if (sr.getType().equals("FTSM"))
		{
		}
		else if (sr.getType().equals("DFTM"))
		{
		}
		else if (sr.getType().equals("RNAM"))
		{
		}

	}
}
