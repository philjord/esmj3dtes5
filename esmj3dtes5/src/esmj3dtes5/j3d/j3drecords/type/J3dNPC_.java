package esmj3dtes5.j3d.j3drecords.type;

import java.util.ArrayList;

import javax.vecmath.Color3f;

import esmj3d.data.shared.subrecords.CNTO;
import esmj3d.data.shared.subrecords.FormID;
import esmj3d.j3d.BethRenderSettings;
import esmj3d.j3d.j3drecords.type.J3dRECOTypeCha;
import esmj3dtes5.data.records.ARMA;
import esmj3dtes5.data.records.ARMO;
import esmj3dtes5.data.records.LVLI;
import esmj3dtes5.data.records.LVLN;
import esmj3dtes5.data.records.NPC_;
import esmj3dtes5.data.records.OTFT;
import esmj3dtes5.data.records.RACE;
import esmj3dtes5.data.records.WEAP;
import esmj3dtes5.data.subrecords.LVLO;
import esmmanager.common.data.record.IRecordStore;
import esmmanager.common.data.record.Record;
import nif.character.NifCharacter;
import tools3d.utils.scenegraph.Fadable;
import utils.ESConfig;
import utils.source.MediaSources;

public class J3dNPC_ extends J3dRECOTypeCha
{
	private String helmetStr = null;

	private String headStr = null;

	private String eyesStr = null;

	private String bodyStr = null;

	private String handsStr = null;

	private String feetStr = null;

	private String weapStr = null;

	private boolean female = false;

	private RACE race;

	public J3dNPC_(NPC_ npc_, IRecordStore master, MediaSources mediaSources)
	{
		super(npc_, false);

		female = npc_.ACBS.isFemale();

		organiseNPC_(npc_, master);

		// are we a char or in fact a bit of a crea?
		if (race.maleSkeleton.str.toLowerCase().indexOf("actors\\character\\") != -1)
		{
			// this is the start of an idea to pull body data out
			//BPTD bptd = new BPTD(master.getRecord(race.GNAM.formId));
			if (female)
			{
				headStr = headStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalehead.nif" : headStr;
				//All beast races are just humans with a different texture
				bodyStr = bodyStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalebody_0.nif" : bodyStr;
				handsStr = handsStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalehands_0.nif" : handsStr;
				feetStr = feetStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalefeet_0.nif" : feetStr;
				eyesStr = eyesStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\eyesfemale.nif" : eyesStr;
				helmetStr = helmetStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\hair\\female\\hair01.nif"
						: helmetStr;
			}
			else
			{
				headStr = headStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malehead.nif" : headStr;
				//All beast races are just humans with a different texture
				bodyStr = bodyStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malebody_0.nif" : bodyStr;
				handsStr = handsStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malehands_0.nif" : handsStr;
				feetStr = feetStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malefeet_0.nif" : feetStr;
				eyesStr = eyesStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\eyesmale.nif" : eyesStr;
				helmetStr = helmetStr == null ? ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\hair\\male\\hair01.nif"
						: helmetStr;
			}

			// ok cool, humans have a special bunch of cock aroundy stuff
			// monsters have a skeleton dir, inside that is some body nifs
			// down one and up animations is mt_idle.kf

			//String skeletonNifFile =  ESConfig.TES_MESH_PATH + "actors\\character\\character assets female\\skeleton_female.nif";

			String skeletonNifFile = ESConfig.TES_MESH_PATH + (female ? race.femaleSkeleton.str : race.maleSkeleton.str);//"actors\\character\\character assets female\\skeleton_female.nif";

			ArrayList<String> fileNames = new ArrayList<String>();

			fileNames.add(headStr);
			//fileNames.add(eyesStr);//freaky foot level eyes
			fileNames.add(helmetStr);
			fileNames.add(bodyStr);
			fileNames.add(handsStr);
			fileNames.add(feetStr);
			fileNames.add(weapStr);

			ArrayList<String> idleAnimations = new ArrayList<String>();
			//idleAnimations.add(ESConfig.TES_MESH_PATH + "actors\\character\\animations\\mt_idle_a_base.kf");

 
			addIdleAnimations( idleAnimations, mediaSources.getMeshSource().getFilesInFolder(ESConfig.TES_MESH_PATH + "actors\\character\\animations"));

			nifCharacter = new NifCharacter(skeletonNifFile, fileNames, mediaSources, idleAnimations);
			addChild(nifCharacter);
			
			setOutline(new Color3f(1.0f, 1.0f, 0f));
			if (!BethRenderSettings.isOutlineChars())
				((Fadable) nifCharacter).setOutline(null);
		}
		else
		{
			j3dCREA(master, mediaSources);

		}

	}

	private void organiseNPC_(NPC_ npc, IRecordStore master)
	{
		if (npc != null)
		{
			race = new RACE(master.getRecord(npc.RNAM.formId));
			//System.out.println("organiseNPC_ " + npc.EDID.str);
			organiseTemplate(npc.TPLT, master);
			organiseCNTOs(npc.CNTOs, master);

			if (npc.DOFT != null)
			{
				Record doftRec = master.getRecord(npc.DOFT.formId);
				OTFT otft = new OTFT(doftRec);
				for (int i = 0; i < otft.INAMs.size(); i++)
				{
					Record baseRecord = master.getRecord(otft.INAMs.get(i).formId);
					organiseItem(baseRecord, master);
				}

			}
		}

	}

	private void organiseTemplate(FormID tplt, IRecordStore master)
	{
		if (tplt != null)
		{
			NPC_ npcTemplate = null;
			Record trec = master.getRecord(tplt.formId);
			if (trec.getRecordType().equals("LVLN"))
			{
				LVLN lvln = new LVLN(trec);
				npcTemplate = organiseLVLN(lvln, master);
			}
			else if (trec.getRecordType().equals("NPC_"))
			{
				npcTemplate = new NPC_(trec);
			}
			//System.out.println("template");
			organiseNPC_(npcTemplate, master);
		}

	}

	private NPC_ organiseLVLN(LVLN lvln, IRecordStore master)
	{
		// TODO: randomly picked for now
		LVLO[] LVLOs = lvln.LVLOs;

		int idx = (int) (Math.random() * LVLOs.length);
		idx = idx == LVLOs.length ? 0 : idx;

		Record baseRecord = master.getRecord(LVLOs[idx].itemFormId);

		if (baseRecord.getRecordType().equals("NPC_"))
		{
			return new NPC_(baseRecord);
		}
		else if (baseRecord.getRecordType().equals("LVLN"))
		{
			LVLN lvln2 = new LVLN(baseRecord);
			return organiseLVLN(lvln2, master);
		}
		else
		{
			System.out.println("LVLN record type not converted to j3d " + baseRecord.getRecordType());
			return null;
		}
	}

	private void organiseCNTOs(ArrayList<CNTO> cntos, IRecordStore master)
	{
		for (int i = 0; i < cntos.size(); i++)
		{
			//	int count = cntos[i].count;
			Record baseRecord = master.getRecord(cntos.get(i).itemFormId);
			organiseItem(baseRecord, master);
		}
	}

	private void organiseLVLI(LVLI lvli, IRecordStore master)
	{
		LVLO[] LVLOs = lvli.LVLOs;

		if (LVLOs.length > 0)
		{
			int idx = (int) (Math.random() * LVLOs.length);
			idx = idx == LVLOs.length ? 0 : idx;

			Record baseRecord = master.getRecord(LVLOs[idx].itemFormId);
			organiseItem(baseRecord, master);
		}

	}

	private void organiseItem(Record baseRecord, IRecordStore master)
	{
		if (baseRecord.getRecordType().equals("WEAP"))
		{
			WEAP weap = new WEAP(baseRecord);
			addWEAP(weap);
		}
		else if (baseRecord.getRecordType().equals("ARMO"))
		{
			ARMO armo = new ARMO(baseRecord);
			addARMO(armo, master);
		}
		else if (baseRecord.getRecordType().equals("MISC"))
		{
		}
		else if (baseRecord.getRecordType().equals("AMMO"))
		{
		}
		else if (baseRecord.getRecordType().equals("INGR"))
		{
		}
		else if (baseRecord.getRecordType().equals("ALCH"))
		{
		}
		else if (baseRecord.getRecordType().equals("SLGM"))
		{
		}
		else if (baseRecord.getRecordType().equals("CMNY"))
		{
		}
		else if (baseRecord.getRecordType().equals("KEYM"))
		{
		}
		else if (baseRecord.getRecordType().equals("BOOK"))
		{
		}
		else if (baseRecord.getRecordType().equals("LIGH"))
		{
		}
		else if (baseRecord.getRecordType().equals("LVLI"))
		{
			LVLI lvli2 = new LVLI(baseRecord);
			organiseLVLI(lvli2, master);
		}
		else
		{
			System.out.println("LVLI record type not converted to j3d " + baseRecord.getRecordType());
		}
	}

	private void addARMO(ARMO armo, IRecordStore master)
	{
		ARMA arma = new ARMA(master.getRecord(armo.MODL.formId));
		String nifStr = arma.MOD2.model.str;
		if (female && arma.MOD3 != null)
		{
			nifStr = arma.MOD3.model.str;
		}

		helmetStr = arma.BODT.isHair() ? nifStr : helmetStr;
		bodyStr = arma.BODT.isBody() ? nifStr : bodyStr;
		handsStr = arma.BODT.isHand() ? nifStr : handsStr;
		feetStr = arma.BODT.isHand() ? nifStr : feetStr;

		//System.out.println("ARMO " + nifStr);
	}

	private void addWEAP(WEAP weap)
	{
		weapStr = weap.MODL.model.str;
		//System.out.println("WEAP " + weapStr);
	}

	/**
	 * fall back for simplish creatures
	 * @param npc_
	 * @param master
	 * @param meshSource
	 * @param textureSource
	 * @param soundSource
	 */
	private void j3dCREA(IRecordStore master, MediaSources mediaSources)
	{
		String skeletonNifFile = ESConfig.TES_MESH_PATH + race.maleSkeleton.str;

		ARMO skin = new ARMO(master.getRecord(race.WNAM.formId));
		ARMA arma = new ARMA(master.getRecord(skin.MODL.formId));
		String nifStr = arma.MOD2.model.str;

		ArrayList<String> fileNames = new ArrayList<String>();
		fileNames.add(nifStr);

		// get animation from asset path badly
		String assetPath = race.maleSkeleton.str.substring(0, race.maleSkeleton.str.lastIndexOf("\\"));
		assetPath = assetPath.substring(0, assetPath.lastIndexOf("\\"));
		assetPath = ESConfig.TES_MESH_PATH + assetPath;

		ArrayList<String> idleAnimations = new ArrayList<String>();
		idleAnimations.addAll(mediaSources.getMeshSource().getFilesInFolder(assetPath + "\\animations"));

		nifCharacter = new NifCharacter(skeletonNifFile, fileNames, mediaSources, idleAnimations);
		addChild(nifCharacter);
		
		setOutline(new Color3f(1.0f, 1.0f, 0f));
		if (!BethRenderSettings.isOutlineChars())
			((Fadable) nifCharacter).setOutline(null);

	}

}
