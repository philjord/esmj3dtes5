package esmj3dtes5.data.records;

import java.util.ArrayList;

import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ANAM;
import esmj3d.data.shared.subrecords.DESC;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.data.shared.subrecords.MODL;
import esmj3d.data.shared.subrecords.ZString;
import esmmanager.common.data.record.Record;
import esmmanager.common.data.record.Subrecord;

public class BOOK extends RECO
{
	public ZString EDID;

	public FormID FULL;

	public MODL MODL;;

	public ANAM ANAM;

	public FormID ENAM;

	public DESC DESC;

	/*
	 * DATA Subrecord
	
	This subrecord is always 10 bytes long (confirmed) and holds the book data.
	Name 	Type/Size 	Info
	Flags 	1 (byte) 	Book flags
	
	    0x0001 = Scroll 
	    0x0002 = Can't be taken 
	
	Teaches 	1 (byte) 	Which skill the book teaches. See TES4Mod:Skill Indices for details. Set to 0xFF if no skill is taught.
	Value 	4 (word) 	Book value
	Weight 	4 (float) 	Book weight
	 */
	public BOOK(Record recordData)
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
			else if (sr.getType().equals("DESC"))
			{
				DESC = new DESC(bs);
			}
			else if (sr.getType().equals("DATA"))
			{

			}
			else if (sr.getType().equals("MODL"))
			{
				MODL = new MODL(bs);
			}
			else if (sr.getType().equals("MODT"))
			{
				MODL.addMODTSub(bs);
			}

			else if (sr.getType().equals("ANAM"))
			{
				ANAM = new ANAM(bs);
			}
			else if (sr.getType().equals("ENAM"))
			{
				ENAM = new FormID(bs);
			}

			else if (sr.getType().equals("KSIZ"))
			{
			}
			else if (sr.getType().equals("KWDA"))
			{

			}
			else if (sr.getType().equals("INAM"))
			{

			}
			else if (sr.getType().equals("CNAM"))
			{

			}
			else if (sr.getType().equals("YNAM"))
			{

			}
			else if (sr.getType().equals("VMAD"))
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
		return "BOOK : (" + formId + "|" + Integer.toHexString(formId) + ") " + EDID.str + " : " + MODL.model.str;
	}

}
