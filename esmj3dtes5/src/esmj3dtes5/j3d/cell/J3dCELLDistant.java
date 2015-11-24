package esmj3dtes5.j3d.cell;

import java.util.Iterator;
import java.util.List;

import javax.media.j3d.Node;

import utils.source.MediaSources;
import esmmanager.common.data.record.IRecordStore;
import esmmanager.common.data.record.Record;

public class J3dCELLDistant extends J3dCELL
{
	/*
	 * Distant for Skyrim and FO3 are just statics that have lods, along with trees
	 */
	public J3dCELLDistant(IRecordStore master, Record cellRecord, int worldId, List<Record> children, boolean makePhys, MediaSources mediaSources)
	{
		super(master, cellRecord, worldId, children, makePhys, mediaSources);
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
				Node n = makeJ3dRECOFar(record);
				addChild(n);
			}
		}
	}
}
