package esmj3dtes5.j3d.cell;

import java.util.Iterator;
import java.util.List;

import javax.media.j3d.Group;

import utils.source.MeshSource;
import utils.source.SoundSource;
import utils.source.TextureSource;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.data.shared.records.CommonWRLD;
import esmj3d.j3d.cell.GridSpaces;
import esmj3d.j3d.cell.J3dICELLPersistent;
import esmj3dtes5.data.records.ACHR;
import esmj3dtes5.data.records.REFR;
import esmj3dtes5.data.records.WRLD;

public class J3dCELLPersistent extends J3dCELL implements J3dICELLPersistent
{
	private GridSpaces gridSpaces = new GridSpaces(this);

	private WRLD wrld;

	/**
	 * CELL presistent is differnt from temp and distant as it's dynamic refs and achar can move away
	 * but they are sitll managed by the cell persistent itself, so we have this crazy grid space sub system to quickly 
	 * clip wandering things away
	 * 
	 * So it is a bit different to a J3dCELL in constrcution, but same sort of content
	 * cell actory uses  esmj3dtes4.j3d.j3drecords.J3dCELL; as the other sort for temp and distant
	 * I need to bring this is as a common child of J3dCELL or something
	 * 
	 * TODO: I noticce skyrim has fixed grid of
	 * maxX 60 maxY 38
	 * minX -57 minY -41  so 118 * 80 = 9,440 array holds it all, I wonder about obliv and fallout??
	 * @param wrld 
	 * @param master
	 * @param cellRecord
	 * @param children
	 * @param makePhys
	 * @param recordToRECO
	 */

	public J3dCELLPersistent(WRLD wrld, IRecordStore master, Record cellRecord, List<Record> children, boolean makePhys,
			MeshSource meshSource, TextureSource textureSource, SoundSource soundSource)
	{
		super(master, cellRecord, children, makePhys, meshSource, textureSource, soundSource);
		this.wrld = wrld;
		this.setCapability(Group.ALLOW_CHILDREN_EXTEND);
		this.setCapability(Group.ALLOW_CHILDREN_WRITE);

		indexRecords();
	}

	private void indexRecords()
	{
		//int maxX, maxY, minX, minY = 0;

		//NOTE they can be 10's of 1000's of these records do not load up front!
		for (Iterator<Record> i = children.iterator(); i.hasNext();)
		{
			Record record = i.next();

			if (record.getRecordType().equals("REFR"))
			{
				REFR refr = new REFR(record);
				gridSpaces.sortOutBucket(refr, record);
			}
			else if (record.getRecordType().equals("ACHR"))
			{
				ACHR achr = new ACHR(record);
				gridSpaces.sortOutBucket(achr, record);
			}
			else if (record.getRecordType().equals("PHZD"))
			{

			}
			else
			{
				System.out.println("CELL_PERSISTENT Record type not converted to j3d " + record.getRecordType());
			}

		}

		//System.out.println("maxX " + maxX + " maxY " + maxY);
		//System.out.println("minX " + minX + " minY " + minY);

	}

	@Override
	public GridSpaces getGridSpaces()
	{
		return gridSpaces;
	}

	@Override
	public CommonWRLD getWRLD()
	{
		return wrld;
	}

}
