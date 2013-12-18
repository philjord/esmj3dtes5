package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;

public class QUST extends RECO
{

	public ZString EDID = null;

	public QUST(Record recordData)
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
			else if (sr.getType().equals("FULL"))
			{
			}
			else if (sr.getType().equals("DNAM"))
			{
			}
			else if (sr.getType().equals("CTDA"))
			{
			}
			else if (sr.getType().equals("NEXT"))
			{
			}
			else if (sr.getType().equals("ANAM"))
			{
			}
			else if (sr.getType().equals("VMAD"))
			{
			}
			else if (sr.getType().equals("ENAM"))
			{
			}
			else if (sr.getType().equals("FLTR"))
			{
			}
			else if (sr.getType().equals("INDX"))
			{
			}
			else if (sr.getType().equals("QSDT"))
			{
			}
			else if (sr.getType().equals("ALST"))
			{
			}
			else if (sr.getType().equals("ALID"))
			{
			}
			else if (sr.getType().equals("FNAM"))
			{
			}
			else if (sr.getType().equals("ALFE"))
			{
			}
			else if (sr.getType().equals("ALFD"))
			{
			}
			else if (sr.getType().equals("VTCK"))
			{
			}
			else if (sr.getType().equals("ALED"))
			{
			}
			else if (sr.getType().equals("ALLS"))
			{
			}
			else if (sr.getType().equals("ALUA"))
			{
			}
			else if (sr.getType().equals("ALFR"))
			{
			}
			else if (sr.getType().equals("ALPC"))
			{
			}
			else if (sr.getType().equals("ALCO"))
			{
			}
			else if (sr.getType().equals("ALCA"))
			{
			}
			else if (sr.getType().equals("ALCL"))
			{
			}
			else if (sr.getType().equals("QOBJ"))
			{
			}
			else if (sr.getType().equals("NNAM"))
			{
			}
			else if (sr.getType().equals("QSTA"))
			{
			}
			else if (sr.getType().equals("ALFA"))
			{
			}
			else if (sr.getType().equals("ALRT"))
			{
			}
			else if (sr.getType().equals("ALFI"))
			{
			}
			else if (sr.getType().equals("ALFC"))
			{
			}
			else if (sr.getType().equals("ALNA"))
			{
			}
			else if (sr.getType().equals("ALNT"))
			{
			}
			else if (sr.getType().equals("CIS2"))
			{
			}
			else if (sr.getType().equals("QTGL"))
			{
			}
			else if (sr.getType().equals("ECOR"))
			{
			}
			else if (sr.getType().equals("ALEQ"))
			{
			}
			else if (sr.getType().equals("ALEA"))
			{
			}
			else if (sr.getType().equals("ALDN"))
			{
			}
			else if (sr.getType().equals("KNAM"))
			{
			}
			else if (sr.getType().equals("CNAM"))
			{
			}
			else if (sr.getType().equals("ALSP"))
			{
			}
			else if (sr.getType().equals("ALFL"))
			{
			}
			else if (sr.getType().equals("COCT"))
			{
			}
			else if (sr.getType().equals("CNTO"))
			{
			}
			else if (sr.getType().equals("KSIZ"))
			{
			}
			else if (sr.getType().equals("KWDA"))
			{
			}
			else if (sr.getType().equals("NAM0"))
			{
			}
			else if (sr.getType().equals("SCHR"))
			{
			}
			else if (sr.getType().equals("QNAM"))
			{
			}
			else if (sr.getType().equals("SPOR"))
			{
			}
			else if (sr.getType().equals("SCTX"))
			{
			}
			else
			{
				System.out.println("unhandled : " + sr.getType() + " in record " + recordData + " in " + this);
			}

		}
	}
}
