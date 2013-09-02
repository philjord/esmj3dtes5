package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmj3dtes5.data.subrecords.PFPC;

public class FLOR extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public MODL MODL;;

	public FormID produceFormId = null;// Formid of INGR/ALCH

	public FormID soundId = null;// Formid of SNDR when activated

	public PFPC PFPC;

	public FLOR(Record recordData)
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
			else if (sr.getSubrecordType().equals("OBND"))
			{

			}
			else if (sr.getSubrecordType().equals("FULL"))
			{
				FULL = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getSubrecordType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}
			else if (sr.getSubrecordType().equals("PFIG"))
			{
				produceFormId = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("SNAM"))
			{
				soundId = new FormID(bs);
			}
			else if (sr.getSubrecordType().equals("PFPC"))
			{
				PFPC = new PFPC(bs);
			}
			else if (sr.getSubrecordType().equals("PNAM"))
			{

			}
			else if (sr.getSubrecordType().equals("RNAM"))
			{

			}
			else if (sr.getSubrecordType().equals("FNAM"))
			{

			}
			else if (sr.getSubrecordType().equals("VMAD"))
			{

			}
			else if (sr.getSubrecordType().equals("MODS"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}
		}
	}
}
