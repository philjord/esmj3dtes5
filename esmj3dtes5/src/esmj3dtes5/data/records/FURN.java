package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;

public class FURN extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public MODL MODL;;

	public byte[] MNAM = null;

	public FURN(Record recordData)
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
			else if (sr.getType().equals("MODS"))
			{
				MODL.addMODSSub(bs);
			}

			else if (sr.getType().equals("PNAM"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else if (sr.getType().equals("KNAM"))
			{
			}
			else if (sr.getType().equals("MNAM"))
			{
			}
			else if (sr.getType().equals("WBDT"))
			{
			}
			else if (sr.getType().equals("ENAM"))
			{
			}
			else if (sr.getType().equals("NAM0"))
			{
			}
			else if (sr.getType().equals("FNPR"))
			{
			}
			else if (sr.getType().equals("KSIZ"))
			{
			}
			else if (sr.getType().equals("KWDA"))
			{
			}
			else if (sr.getType().equals("VMAD"))
			{
			}
			else if (sr.getType().equals("XMRK"))
			{
			}

			else if (sr.getType().equals("FNMK"))
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

	public String showDetails()
	{
		return "FURN : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str + " : " + MODL.model.str;
	}

}
