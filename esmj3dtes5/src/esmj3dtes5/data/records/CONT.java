package esmj3dtes5.data.records;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.CNTO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class CONT extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public MODL MODL;;

	public CNTO[] CNTOs = null;

	public int SNAM;

	public int QNAM;

	public byte[] MNAM = null;

	public CONT(Record recordData)
	{

		super(recordData);

		ArrayList<CNTO> CNTOsl = new ArrayList<CNTO>();

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
			else if (sr.getSubrecordType().equals("DATA"))
			{

			}

			else if (sr.getSubrecordType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getSubrecordType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}
			else if (sr.getSubrecordType().equals("MODS"))
			{
				MODL.addMODSSub(bs);
			}
			else if (sr.getSubrecordType().equals("MNAM"))
			{
				MNAM = bs;
			}
			else if (sr.getSubrecordType().equals("SNAM"))
			{
				SNAM = ESMByteConvert.extractInt(bs, 0);
			}
			else if (sr.getSubrecordType().equals("QNAM"))
			{
				QNAM = ESMByteConvert.extractInt(bs, 0);
			}
			else if (sr.getSubrecordType().equals("COCT"))
			{

			}
			else if (sr.getSubrecordType().equals("CNTO"))
			{
				CNTOsl.add(new CNTO(bs));
			}
			else if (sr.getSubrecordType().equals("VMAD"))
			{

			}
			else if (sr.getSubrecordType().equals("COED"))
			{

			}
			else
			{
				System.out.println("unhandled : " + sr.getSubrecordType() + " in " + recordData);
			}

			CNTOs = new CNTO[CNTOsl.size()];
			CNTOsl.toArray(CNTOs);
		}
	}

	public String showDetails()
	{
		return "CONT : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str + " : " + MODL.model.str;
	}

}
