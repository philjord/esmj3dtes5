package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.LString;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class BPTD extends RECO
{
	public ZString EDID = null;

	public MODL MODL = null;

	public ArrayList<BodyPart> bodyParts = new ArrayList<BodyPart>();

	public class BodyPart
	{
		public LString BPTN;

		public ZString BPNI;

		public ZString BPNN;

		public ZString BPNT;
	}

	public BPTD(Record recordData)
	{
		super(recordData);
		ArrayList<Subrecord> subrecords = recordData.getSubrecords();

		Subrecord sr = next(subrecords);
		EDID = new ZString(sr.getData());
		sr = next(subrecords);

		if (sr.getType().equals("MODL"))
		{
			MODL = new MODL(sr.getData());
			sr = next(subrecords);
			if (sr.getType().equals("MODT"))
			{
				MODL.addMODTSub(sr.getData());
				sr = next(subrecords);
			}
		}

		while (sr != null && sr.getType().equals("BPTN"))
		{
			BodyPart bodyPart = new BodyPart();
			bodyParts.add(bodyPart);

			bodyPart.BPTN = new LString(sr.getData());
			sr = next(subrecords);
			bodyPart.BPNN = new ZString(sr.getData());
			sr = next(subrecords);
			bodyPart.BPNT = new ZString(sr.getData());
			sr = next(subrecords);
			bodyPart.BPNI = new ZString(sr.getData());
			sr = next(subrecords);

			//BPND
			sr = next(subrecords);
			//NAM1
			sr = next(subrecords);
			//NAM4
			sr = next(subrecords);
			//NAM5
			sr = next(subrecords);

		}

		if (sr != null && sr.getType().equals("RAGA"))
		{
			//RAGA
		}

	}
}
