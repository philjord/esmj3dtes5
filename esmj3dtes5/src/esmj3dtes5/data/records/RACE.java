package esmj3dtes5.data.records;

import java.util.List;

import esmio.common.data.record.Record;
import esmio.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.BODT;
import tools.io.ESMByteConvert;

public class RACE extends RECO
{
	public ZString EDID = null;

	public FormID FULL = null;

	public FormID WNAM = null;

	public BODT BODT = null;

	public ZString maleSkeleton = null;

	public ZString femaleSkeleton = null;

	public FormID GNAM = null;

	public RACE(Record recordData)
	{
		super(recordData);

		List<Subrecord> subrecords = recordData.getSubrecords();

		Subrecord sr = next(subrecords);
		EDID = new ZString(sr.getSubrecordData());
		sr = next(subrecords);

		if (sr.getSubrecordType().equals("FULL"))
		{
			FULL = new FormID(sr.getSubrecordData());
			sr = next(subrecords);
		}

		//DESC = new LString(sr.getData());
		sr = next(subrecords);

		if (sr.getSubrecordType().equals("SPCT"))
		{
			int sploCount = ESMByteConvert.extractInt(sr.getSubrecordData(), 0);
			sr = next(subrecords);
			for (int i = 0; i < sploCount; i++)
			{
				//SPLO
				sr = next(subrecords);
			}
		}

		if (sr.getSubrecordType().equals("WNAM"))
		{
			WNAM = new FormID(sr.getSubrecordData());
			sr = next(subrecords);
		}

		BODT = new BODT(sr.getSubrecordData());
		sr = next(subrecords);

		if (sr.getSubrecordType().equals("KSIZ"))
		{
			int kwdaCount = ESMByteConvert.extractInt(sr.getSubrecordData(), 0);
			sr = next(subrecords);
			//KWDA FormID * kwdaCount
			sr = next(subrecords);

		}

		//DATA
		sr = next(subrecords);

		//MNAM
		sr = next(subrecords);

		maleSkeleton = new ZString(sr.getSubrecordData());
		sr = next(subrecords);

		//MODT
		sr = next(subrecords);

		//FNAM
		sr = next(subrecords);

		femaleSkeleton = new ZString(sr.getSubrecordData());
		sr = next(subrecords);

		//MODT
		sr = next(subrecords);

		//NAM2
		sr = next(subrecords);

		while (sr.getSubrecordType().equals("MTNM"))
		{
			//MTNM
			sr = next(subrecords);
		}

		//VTCK
		sr = next(subrecords);

		if (sr.getSubrecordType().equals("DNAM"))
		{
			//DNAM 
			sr = next(subrecords);
		}

		if (sr.getSubrecordType().equals("HCLF"))
		{
			//HCLF 
			sr = next(subrecords);
		}

		if (sr.getSubrecordType().equals("TINL"))
		{
			//TINL 
			sr = next(subrecords);
		}

		//PNAM
		sr = next(subrecords);

		//UNAM
		sr = next(subrecords);

		while (sr.getSubrecordType().equals("ATKD"))
		{
			//ATKD
			sr = next(subrecords);

			//ATKE
			sr = next(subrecords);
		}

		//NAM1
		sr = next(subrecords);
		//MNAM
		sr = next(subrecords);
		//INDX
		sr = next(subrecords);
		//MODL
		sr = next(subrecords);
		//MODT
		sr = next(subrecords);
		//FNAM
		sr = next(subrecords);
		//INDX
		sr = next(subrecords);
		//MODL
		sr = next(subrecords);
		//MODT
		sr = next(subrecords);

		GNAM = new FormID(sr.getSubrecordData());
		sr = next(subrecords);

		//NAM2
		sr = next(subrecords);
		//NAM3
		sr = next(subrecords);
		//MNAM
		sr = next(subrecords);
		//MODL
		sr = next(subrecords);
		//MODT
		sr = next(subrecords);
		//FNAM
		sr = next(subrecords);
		//MODL
		sr = next(subrecords);
		//MODT
		sr = next(subrecords);

		//TODO: finish this off from here
		//http://www.uesp.net/wiki/Tes5Mod:Mod_File_Format/RACE

	}
}
