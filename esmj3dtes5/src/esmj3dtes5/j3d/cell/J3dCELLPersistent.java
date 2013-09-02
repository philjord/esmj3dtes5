package esmj3dtes5.j3d.cell;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.media.j3d.Group;

import utils.ESConfig;
import utils.source.MeshSource;
import utils.source.SoundSource;
import utils.source.TextureSource;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmLoader.common.data.record.Subrecord;
import esmj3d.j3d.cell.GridSpace;
import esmj3d.j3d.cell.J3dICELLPersistent;
import esmj3d.j3d.j3drecords.inst.J3dRECOInst;
import esmj3dtes5.data.records.ACHR;
import esmj3dtes5.data.records.REFR;

public class J3dCELLPersistent extends J3dCELL implements J3dICELLPersistent
{
	public static int BUCKET_RANGE = 82;

	private HashMap<Point, GridSpace> allGridSpaces = new HashMap<Point, GridSpace>();

	private HashMap<Point, GridSpace> attachedGridSpaces = new HashMap<Point, GridSpace>();

	private HashMap<Integer, Record> recordsById = new HashMap<Integer, Record>();

	private HashMap<Integer, GridSpace> gridSpaceByRecordId = new HashMap<Integer, GridSpace>();

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
	 * @param master
	 * @param cellRecord
	 * @param children
	 * @param makePhys
	 * @param recordToRECO
	 */

	public J3dCELLPersistent(IRecordStore master, Record cellRecord, List<Record> children, boolean makePhys, MeshSource meshSource,
			TextureSource textureSource, SoundSource soundSource)
	{
		super(master, cellRecord, children, makePhys, meshSource, textureSource, soundSource);

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
			// refr id = 89721
			// 228606 DOOR
			/*	if (!makePhys)
			{
				if (record.getRecordType().equals("REFR"))
				{
					REFR refr = new REFR(record);
					Record baseRecord = master.getRecord(refr.NAME.formId);

					if (baseRecord.getRecordType().equals("DOOR"))
					{
						//System.out.println("" + this.cell.formId + "pers is looking at " + record.getFormID() + " type "
						//		+ record.getRecordType());

						//System.out.println("base = " + baseRecord.getRecordType());
						float recordX = 0;
						float recordY = 0;
						recordX = refr.x * ESConfig.ES_TO_METERS_SCALE;
						recordY = refr.y * ESConfig.ES_TO_METERS_SCALE;
						//System.out.println("recordX " + recordX + " recordY " + recordY);
						int xGridIdx = (int) Math.floor(recordX / BUCKET_RANGE);
						int yGridIdx = (int) Math.floor(recordY / BUCKET_RANGE);
						Point key = new Point(xGridIdx, yGridIdx);
						//System.out.println("grid bucket  = " + key);
					}
				}
			}*/

			float recordX = 0;
			float recordY = 0;
			if (record.getRecordType().equals("REFR"))
			{
				REFR refr = new REFR(record);
				recordX = refr.x * ESConfig.ES_TO_METERS_SCALE;
				recordY = refr.y * ESConfig.ES_TO_METERS_SCALE;
			}
			else if (record.getRecordType().equals("ACHR"))
			{
				ACHR achr = new ACHR(record);
				recordX = achr.x * ESConfig.ES_TO_METERS_SCALE;
				recordY = achr.y * ESConfig.ES_TO_METERS_SCALE;
			}
			else if (record.getRecordType().equals("PHZD"))
			{

			}
			else
			{
				System.out.println("CELL_PERSISTENT Record type not converted to j3d " + record.getRecordType());
			}

			int xGridIdx = (int) Math.floor(recordX / BUCKET_RANGE);
			int yGridIdx = (int) Math.floor(recordY / BUCKET_RANGE);

			//maxX = xGridIdx > maxX ? xGridIdx : maxX;
			//maxY = yGridIdx > maxY ? yGridIdx : maxY;
			//minX = xGridIdx < minX ? xGridIdx : minX;
			//minY = yGridIdx < minY ? yGridIdx : minY;

			Point key = new Point(xGridIdx, yGridIdx);

			GridSpace gs = allGridSpaces.get(key);
			if (gs == null)
			{
				gs = new GridSpace(this, key);
				allGridSpaces.put(key, gs);
			}
			gs.addRecord(record);
			recordsById.put(new Integer(record.getFormID()), record);
			gridSpaceByRecordId.put(new Integer(record.getFormID()), gs);
		}

		//System.out.println("maxX " + maxX + " maxY " + maxY);
		//System.out.println("minX " + minX + " minY " + minY);

	}

	public void update(float charX, float charY, float loadDist)
	{
		List<GridSpace> gridsToRemove = getGridSpacesToRemove(charX, charY, loadDist);
		for (GridSpace gridSpace : gridsToRemove)
		{
			removeChild(gridSpace);
			gridSpace.unloadChildren();
			attachedGridSpaces.remove(gridSpace.getKey());
		}

		List<GridSpace> gridsToAdd = getGridSpacesToAdd(charX, charY, loadDist);
		for (GridSpace gridSpace : gridsToAdd)
		{

			attachedGridSpaces.put(gridSpace.getKey(), gridSpace);
			gridSpace.loadChildren();
			addChild(gridSpace);

		}
	}

	public List<GridSpace> getGridSpacesToAdd(float charX, float charY, float loadDist)
	{
		int newLowX = (int) Math.floor((charX - loadDist) / BUCKET_RANGE);
		int newLowY = (int) Math.floor((charY - loadDist) / BUCKET_RANGE);
		int newHighX = (int) Math.ceil((charX + loadDist) / BUCKET_RANGE);
		int newHighY = (int) Math.ceil((charY + loadDist) / BUCKET_RANGE);

		ArrayList<GridSpace> gridsToAdd = new ArrayList<GridSpace>();
		for (int x = newLowX; x <= newHighX; x++)
		{
			for (int y = newLowY; y <= newHighY; y++)
			{
				Point key = new Point(x, y);

				GridSpace gs = allGridSpaces.get(key);
				if (gs != null)
				{
					if (!attachedGridSpaces.containsValue(gs))
					{
						gridsToAdd.add(gs);
					}
				}
			}
		}

		return gridsToAdd;
	}

	public List<GridSpace> getGridSpacesToRemove(float charX, float charY, float loadDist)
	{
		int newLowX = (int) Math.floor((charX - loadDist) / BUCKET_RANGE);
		int newLowY = (int) Math.floor((charY - loadDist) / BUCKET_RANGE);
		int newHighX = (int) Math.ceil((charX + loadDist) / BUCKET_RANGE);
		int newHighY = (int) Math.ceil((charY + loadDist) / BUCKET_RANGE);

		Iterator<Point> keys = attachedGridSpaces.keySet().iterator();
		ArrayList<GridSpace> gridsToRemove = new ArrayList<GridSpace>();
		while (keys.hasNext())
		{
			Point key = keys.next();
			if (key.x < newLowX || key.x > newHighX || key.y < newLowY || key.y > newHighY)
			{
				gridsToRemove.add(attachedGridSpaces.get(key));
			}
		}

		return gridsToRemove;
	}

	public void handleRecordCreate(Record record)
	{
		//TODO:find or create gridspace etc?
	}

	public void handleRecordDelete(Record record)
	{
		//TODO:find or create gridspace etc?
	}

	public void handleRecordUpdate(Record record, Subrecord updatedSubrecord)
	{
		GridSpace gridSpaceForEvent = gridSpaceByRecordId.get(new Integer(record.getFormID()));
		gridSpaceForEvent.handleRecordUpdate(record, updatedSubrecord);

		//TODO: now check for movement of the record such that it needs to be in a different gridspace

	}

	public J3dRECOInst getJ3dInstRECO(int recoId)
	{
		GridSpace gs = gridSpaceByRecordId.get(recoId);
		if (gs != null)
		{
			return gs.getJ3dRECOsById().get(recoId);
		}
		else
		{
			return null;
		}
	}

}
