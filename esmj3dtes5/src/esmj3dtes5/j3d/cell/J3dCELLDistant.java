package esmj3dtes5.j3d.cell;

import java.util.Iterator;
import java.util.List;

import utils.source.MediaSources;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.j3d.j3drecords.inst.J3dRECOInst;

public class J3dCELLDistant extends J3dCELL
{
	/*
	 * Distant for Skyrim and FO3 are just statics that have lods, along with trees
	 */
	public J3dCELLDistant(IRecordStore master, Record cellRecord, List<Record> children, boolean makePhys, MediaSources mediaSources)
	{
		super(master, cellRecord, children, makePhys, mediaSources);
		indexRecords();
	}

	private void indexRecords()
	{
		for (Iterator<Record> i = children.iterator(); i.hasNext();)
		{
			Record record = i.next();

			// a lot of  stats are part of distant (if they have the lod flag on)
			if (isVisibleDistant(record))
			{
				J3dRECOInst jri = makeJ3dRECOFar(record);
				addJ3dRECOInst(jri);
			}
		}
	}
}
