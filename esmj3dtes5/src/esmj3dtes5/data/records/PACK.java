package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class PACK extends RECO
{

	public ZString EDID = null;

	public PACK(Record recordData)
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
			else if (sr.getType().equals("PKDT"))
			{
			}
			else if (sr.getType().equals("PSDT"))
			{
			}
			else if (sr.getType().equals("CTDA"))
			{
			}
			else if (sr.getType().equals("PKCU"))
			{
			}
			else if (sr.getType().equals("ANAM"))
			{
			}
			else if (sr.getType().equals("CNAM"))
			{
			}
			else if (sr.getType().equals("PLDT"))
			{
			}
			else if (sr.getType().equals("UNAM"))
			{
			}
			else if (sr.getType().equals("XNAM"))
			{
			}
			else if (sr.getType().equals("POBA"))
			{
			}
			else if (sr.getType().equals("INAM"))
			{
			}
			else if (sr.getType().equals("PDTO"))
			{
			}
			else if (sr.getType().equals("POEA"))
			{
			}
			else if (sr.getType().equals("POCA"))
			{
			}
			else if (sr.getType().equals("QNAM"))
			{
			}
			else if (sr.getType().equals("CIS2"))
			{
			}
			else if (sr.getType().equals("PTDA"))
			{
			}
			else if (sr.getType().equals("CITC"))
			{
			}
			else if (sr.getType().equals("PRCB"))
			{
			}
			else if (sr.getType().equals("PNAM"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else if (sr.getType().equals("PKC2"))
			{
			}
			else if (sr.getType().equals("BNAM"))
			{
			}
			else if (sr.getType().equals("VMAD"))
			{
			}
			else if (sr.getType().equals("IDLF"))
			{
			}
			else if (sr.getType().equals("IDLC"))
			{
			}
			else if (sr.getType().equals("IDLT"))
			{
			}
			else if (sr.getType().equals("IDLA"))
			{
			}
			else if (sr.getType().equals("CIS1"))
			{
			}
			else if (sr.getType().equals("PFO2"))
			{
			}
			else if (sr.getType().equals("SCHR"))
			{
			}
			else if (sr.getType().equals("SCTX"))
			{
			}
			else if (sr.getType().equals("PFOR"))
			{
			}
			else if (sr.getType().equals("SCDA"))
			{
			}
			else if (sr.getType().equals("TPIC"))
			{
			}
			else if (sr.getType().equals("TNAM"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
