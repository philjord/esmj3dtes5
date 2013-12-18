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
				MODL = new MODL(bs);
			}
			else if (sr.getType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}
			else if (sr.getType().equals("PFIG"))
			{
				produceFormId = new FormID(bs);
			}
			else if (sr.getType().equals("SNAM"))
			{
				soundId = new FormID(bs);
			}
			else if (sr.getType().equals("PFPC"))
			{
				PFPC = new PFPC(bs);
			}
			else if (sr.getType().equals("PNAM"))
			{

			}
			else if (sr.getType().equals("RNAM"))
			{

			}
			else if (sr.getType().equals("FNAM"))
			{

			}
			else if (sr.getType().equals("VMAD"))
			{

			}
			else if (sr.getType().equals("MODS"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}
		}
	}
}
