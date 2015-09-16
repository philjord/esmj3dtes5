package esmj3dtes5.j3d.cell;

import java.io.IOException;
import java.util.zip.DataFormatException;

import javax.media.j3d.BranchGroup;

import utils.ESMUtils;
import utils.source.MediaSources;
import esmLoader.common.PluginException;
import esmLoader.common.data.plugin.IMaster;
import esmLoader.common.data.plugin.PluginGroup;
import esmLoader.common.data.plugin.PluginRecord;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmLoader.loader.WRLDChildren;
import esmj3d.j3d.cell.J3dICellFactory;
import esmj3dtes5.data.records.WRLD;

public class J3dCellFactory implements J3dICellFactory
{
	private IMaster esmManager;

	private IRecordStore recordStore;

	private MediaSources mediaSources;

	public J3dCellFactory()
	{
		
	}
	
	public void setSources(IMaster esmManager2, IRecordStore esmManager22, MediaSources mediaSources)
	{
		this.esmManager = esmManager2;
		this.recordStore = esmManager22;
		this.mediaSources = mediaSources;
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
			WRLD wrld = new WRLD(new Record(record, -1));
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
					return new J3dCELLPersistent(wrld, recordStore, new Record(cell, -1), ESMUtils.getChildren(cellChildren,
							PluginGroup.CELL_PERSISTENT), makePhys, mediaSources);
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
		int cellId = esmManager.getWRLDExtBlockCELLId(wrldFormId, x, y);
		return makeBGWRLDTemporary(cellId, makePhys);
	}

	@Override
	public J3dCELLTemporary makeBGWRLDTemporary(int cellId, boolean makePhys)
	{
		if (cellId == -1)
			return null;

		try
		{

			PluginRecord record = esmManager.getWRLDExtBlockCELL(cellId);

			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getWRLDExtBlockCELLChildren(record.getFormID());

				if (cellChildren != null)
				{
					return new J3dCELLTemporary(recordStore, new Record(record, -1), ESMUtils.getChildren(cellChildren,
							PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
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
		int cellId = esmManager.getWRLDExtBlockCELLId(wrldFormId, x, y);
		return makeBGWRLDDistant(cellId, makePhys);
	}

	@Override
	public J3dCELLDistant makeBGWRLDDistant(int cellId, boolean makePhys)
	{
		if (cellId == -1)
			return null;

		try
		{

			PluginRecord record = esmManager.getWRLDExtBlockCELL(cellId);
			if (record != null)
			{
				PluginGroup cellChildren = esmManager.getWRLDExtBlockCELLChildren(record.getFormID());
				if (cellChildren != null)
				{
					return new J3dCELLDistant(recordStore, new Record(record, -1), ESMUtils.getChildren(cellChildren,
							PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
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

				return new J3dCELLPersistent(null, recordStore, new Record(record, -1), ESMUtils.getChildren(cellChildren,
						PluginGroup.CELL_PERSISTENT), makePhys, mediaSources);
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

				return new J3dCELLTemporary(recordStore, new Record(record, -1), ESMUtils.getChildren(cellChildren,
						PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
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

				return new J3dCELLDistant(recordStore, new Record(record, -1), ESMUtils.getChildren(cellChildren,
						PluginGroup.CELL_TEMPORARY), makePhys, mediaSources);
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

}
