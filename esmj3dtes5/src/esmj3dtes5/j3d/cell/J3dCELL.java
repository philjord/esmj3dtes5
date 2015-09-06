package esmj3dtes5.j3d.cell;

import java.util.ArrayList;
import java.util.List;

import javax.media.j3d.Node;

import utils.source.MediaSources;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.data.shared.records.LAND;
import esmj3d.data.shared.records.RECO;
import esmj3d.j3d.BethRenderSettings;
import esmj3d.j3d.BethRenderSettings.UpdateListener;
import esmj3d.j3d.cell.J3dCELLGeneral;
import esmj3d.j3d.j3drecords.inst.J3dLAND;
import esmj3d.j3d.j3drecords.inst.J3dRECOInst;
import esmj3dtes5.data.records.ACHR;
import esmj3dtes5.data.records.CELL;
import esmj3dtes5.data.records.REFR;
import esmj3dtes5.j3d.j3drecords.inst.J3dACHR;
import esmj3dtes5.j3d.j3drecords.inst.J3dREFRFactory;

public class J3dCELL extends J3dCELLGeneral implements UpdateListener
{
	protected CELL cell;

	private ArrayList<J3dRECOInst> j3dRECOInsts = new ArrayList<J3dRECOInst>();

	public J3dCELL(IRecordStore master, Record cellRecord, List<Record> children, boolean makePhys, MediaSources mediaSources)
	{
		super(master, children, makePhys, mediaSources);
		cell = new CELL(cellRecord);
		setCell(cell);
	 
		
		BethRenderSettings.addUpdateListener(this);
	}

	@Override
	public void renderSettingsUpdated()
	{
		if (!makePhys)
		{
			for (J3dRECOInst j3dRECOInst : j3dRECOInsts)
			{
				j3dRECOInst.renderSettingsUpdated();
			}
		}
	}

	protected void addJ3dRECOInst(J3dRECOInst j3dRECOInst)
	{
		if (j3dRECOInst != null)
		{
			addChild((Node) j3dRECOInst);
			j3dRECOInsts.add(j3dRECOInst);
		}
	}

	public Node makeJ3dRECOFar(Record record)
	{
		Node ret = null;
		try
		{
			if (record.getRecordType().equals("REFR"))
			{
				ret = J3dREFRFactory.makeJ3DReferFar(new REFR(record), master, mediaSources);
			}
			else
			{
				System.err.println("Far record not REFR " + record.getRecordType());
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("J3dCELL " + cell.formId + " - null pointer making record " + record + " " + record.getRecordType() + " in "
					+ e.getStackTrace()[0]);
			if (record.getRecordType().equals("REFR"))
			{
				REFR refr = new REFR(record);
				Record baseRecord = master.getRecord(refr.NAME.formId);
				System.out.println("And it's a REFR with base of " + baseRecord.getRecordType());
			}
		}

		return ret;
	}

	public J3dRECOInst makeJ3dRECO(Record record)
	{
		J3dRECOInst ret = null;
		try
		{
			if (record.getRecordType().equals("REFR"))
			{
				ret = J3dREFRFactory.makeJ3DRefer(new REFR(record), makePhys, master, mediaSources);
			}
			else if (record.getRecordType().equals("ACHR"))
			{
				if (!makePhys)
				{
					ret = new J3dACHR(new ACHR(record), master, mediaSources);
				}
			}
			else if (record.getRecordType().equals("LAND"))
			{
				J3dLAND j3dLAND;
				if (makePhys)
				{
					j3dLAND = new J3dLAND(new LAND(record));
				}
				else
				{
					j3dLAND = new J3dLAND(new LAND(record), master, mediaSources.getTextureSource());
				}

				j3dLAND.setLocation(cellLocation);
				ret = j3dLAND;
			}
			else if (record.getRecordType().equals("NAVM"))
			{

			}
			else if (record.getRecordType().equals("PHZD"))
			{

			}
			else
			{
				System.out.println("makeJ3dRECO in J3dCELL Record type not converted to j3d " + record.getRecordType());
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("J3dCELL " + cell.formId + " - null pointer making record " + record + " " + record.getRecordType() + " in "
					+ e.getStackTrace()[0]);
			if (record.getRecordType().equals("REFR"))
			{
				REFR refr = new REFR(record);
				Record baseRecord = master.getRecord(refr.NAME.formId);
				System.out.println("And it's a REFR with base of " + baseRecord.getRecordType());
			}

		}

		if (ret != null)
		{
			j3dRECOs.put(ret.getRecordId(), ret);
		}
		return ret;
	}

	protected boolean isVisibleDistant(Record record)
	{
		// ALL stats are not part of distant for now, do they have LODs in them?
		if (record.getRecordType().equals("REFR") && !makePhys)
		{
			REFR refr = new REFR(record);

			Record baseRecord = master.getRecord(refr.NAME.formId);
			if (baseRecord != null)
			{
				if (baseRecord.getRecordType().equals("TREE"))
				{
					return true;
				}
				else if ((baseRecord.getRecordFlags1() & RECO.VisibleWhenDistant_Flag) != 0)
				{
					//anythig with LOD, STAT, SCOL, ACTI
					return true;
				}
			}
		}
		return false;

	}
}
