package esmj3dtes5.j3d.cell;

import java.io.IOException;
import java.util.zip.DataFormatException;

import javax.media.j3d.BranchGroup;

import esmj3d.j3d.cell.J3dICellFactory;
import esmj3dtes5.data.records.WRLD;
import esmmanager.common.PluginException;
import esmmanager.common.data.plugin.PluginGroup;
import esmmanager.common.data.plugin.PluginRecord;
import esmmanager.common.data.record.Record;
import esmmanager.loader.WRLDChildren;
import utils.ESMUtils;

public class J3dCellFactory extends J3dICellFactory
{
	public J3dCellFactory()
	{

	}

	

	@Override
	public String getLODWorldName(int worldFormId)
	{
		String lodWorldName = "";
		WRLD wrld = getWRLD(worldFormId);
		// use parent first
		if (wrld.WNAM != null && wrld.WNAM.formId != -1)
		{
			WRLD parentWrld = getWRLD(wrld.WNAM.formId);
			lodWorldName = parentWrld.EDID.str;
		}
		else
		{
			lodWorldName = wrld.EDID.str;
		}
		return lodWorldName;
	}

	@Override
	public BranchGroup makeLODLandscape(int lodX, int lodY, int scale, String lodWorldName)
	{
		return new Tes5LODLandscape(lodX, lodY, scale, lodWorldName, mediaSources.getMeshSource(), mediaSources.getTextureSource());
	}

	private WRLD getWRLD(int formId)
	{
		try
		{
			PluginRecord record = esmManager.getWRLD(formId);
			WRLD wrld = new WRLD(new Record(record));
			return wrld;
		}
		catch (DataFormatException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (PluginException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isWRLD(int formId)
	{
		return getWRLD(formId) != null;
	}

	@Override
	public J3dCELLPersistent makeBGWRLDPersistent(int formId, boolean makePhys)
	{

		WRLD wrld = getWRLD(formId);
		if (wrld != null)
		{

			WRLDChildren children = esmManager.getWRLDChildren(formId);

			PluginRecord cell = children.getCell();
			if (cell != null)
			{
				PluginGroup cellChildren = children.getCellChildren();
				if (cellChildren != null)
				{
					return new J3dCELLPersistent(wrld, this, new Record(cell), formId,
							ESMUtils.getChildren(cellChildren, PluginGroup.CELL_PERSISTENT), makePhys, mediaSources);
				}
			}
		}
		else
		{
			System.out.println("makeBGWRLDPersistent bad formId not wrld " + formId);
		}

		return null;
	}

	@Override
	public J3dCELLTemporary makeBGWRLDTemporary(int wrldFormId, int x, int y, boolean makePhys)
	{
		try
		{

			PluginRecord record = esmManager.getWRLDExtBlockCELL(wrldFormId, x, y);

			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getWRLDExtBlockCELLChildren(wrldFormId, x, y);

				if (cellChildren != null)
				{
					return new J3dCELLTemporary(this, new Record(record), wrldFormId,
							ESMUtils.getChildren(cellChildren, PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
				}
			}

		}
		catch (PluginException e1)
		{
			e1.printStackTrace();
		}
		catch (DataFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return null;
	}

	@Override
	public J3dCELLDistant makeBGWRLDDistant(int wrldFormId, int x, int y, boolean makePhys)
	{
		try
		{

			PluginRecord record = esmManager.getWRLDExtBlockCELL(wrldFormId, x, y);
			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getWRLDExtBlockCELLChildren(wrldFormId, x, y);
				if (cellChildren != null)
				{
					return new J3dCELLDistant(this, new Record(record), wrldFormId,
							ESMUtils.getChildren(cellChildren, PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
				}
			}
		}
		catch (PluginException e1)
		{
			e1.printStackTrace();
		}
		catch (DataFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public J3dCELLPersistent makeBGInteriorCELLPersistent(int cellId, boolean makePhys)
	{
		try
		{
			PluginRecord record = esmManager.getInteriorCELL(cellId);

			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getInteriorCELLChildren(cellId);

				return new J3dCELLPersistent(null, this, new Record(record), -1,
						ESMUtils.getChildren(cellChildren, PluginGroup.CELL_PERSISTENT), makePhys, mediaSources);
			}
		}
		catch (PluginException e1)
		{
			e1.printStackTrace();
		}
		catch (DataFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public J3dCELLTemporary makeBGInteriorCELLTemporary(int cellId, boolean makePhys)
	{

		try
		{
			PluginRecord record = esmManager.getInteriorCELL(cellId);

			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getInteriorCELLChildren(cellId);

				return new J3dCELLTemporary(this, new Record(record), -1, ESMUtils.getChildren(cellChildren, PluginGroup.CELL_TEMPORARY),
						makePhys, mediaSources);
			}
		}
		catch (PluginException e1)
		{
			e1.printStackTrace();
		}
		catch (DataFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public J3dCELLDistant makeBGInteriorCELLDistant(int cellId, boolean makePhys)
	{

		try
		{
			PluginRecord record = esmManager.getInteriorCELL(cellId);

			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getInteriorCELLChildren(cellId);

				return new J3dCELLDistant(this, new Record(record), -1, ESMUtils.getChildren(cellChildren, PluginGroup.CELL_TEMPORARY),
						makePhys, mediaSources);
			}
		}
		catch (PluginException e1)
		{
			e1.printStackTrace();
		}
		catch (DataFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public String getMainESMFileName()
	{
		return esmManager.getName();
	}

	@Override
	public Record getParentWRLDLAND(int wrldFormId, int x, int y)
	{

		WRLD wrld = getWRLD(wrldFormId);
		// use parent first
		if (wrld.WNAM != null && wrld.WNAM.formId != -1)
		{
			int parentFormId = -1;
			parentFormId = wrld.WNAM.formId;

			try
			{
				PluginGroup cellChildren = esmManager.getWRLDExtBlockCELLChildren(parentFormId, x, y);

				if (cellChildren != null)
				{
					//note distants are also part of close up
					for (Record record : ESMUtils.getChildren(cellChildren, PluginGroup.CELL_TEMPORARY))
					{
						if (record.getRecordType().equals("LAND"))
							return record;
					}

					for (Record record : ESMUtils.getChildren(cellChildren, PluginGroup.CELL_DISTANT))
					{
						if (record.getRecordType().equals("LAND"))
							return record;
					}
				}

			}
			catch (PluginException e1)
			{
				e1.printStackTrace();
			}
			catch (DataFormatException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		return null;
	}

}
