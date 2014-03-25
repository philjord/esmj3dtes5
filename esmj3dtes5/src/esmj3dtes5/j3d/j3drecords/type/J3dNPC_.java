package esmj3dtes5.j3d.j3drecords.type;

import java.util.ArrayList;
import java.util.List;

import nif.character.NifCharacter;
import utils.ESConfig;
import utils.source.MediaSources;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.data.shared.subrecords.CNTO;
import esmj3d.j3d.j3drecords.type.J3dRECOType;
import esmj3dtes5.data.records.ARMA;
import esmj3dtes5.data.records.ARMO;
import esmj3dtes5.data.records.BPTD;
import esmj3dtes5.data.records.LVLI;
import esmj3dtes5.data.records.NPC_;
import esmj3dtes5.data.records.RACE;
import esmj3dtes5.data.records.WEAP;
import esmj3dtes5.data.subrecords.LVLO;

public class J3dNPC_ extends J3dRECOType
{
	private String helmetStr = null;

	private String headStr = null;

	private String eyesStr = null;

	private String bodyStr = null;

	private String handsStr = null;

	private String feetStr = null;

	private String weapStr = null;

	private boolean female = false;

	private NifCharacter nifCharacter;

	public J3dNPC_(NPC_ npc_, IRecordStore master, MediaSources mediaSources)
	{
		super(npc_, null);

		female = npc_.ACBS.isFemale();

		//TODO: DOFT and SOFT are outfits

		RACE race = new RACE(master.getRecord(npc_.RNAM.formId));

		// are we a char or in fact a bit of a crea?
		if (race.maleSkeleton.str.toLowerCase().indexOf("actors\\character\\") != -1)
		{
			BPTD bptd = new BPTD(master.getRecord(race.GNAM.formId));
			if (female)
			{
				headStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalehead.nif";
				//All beast races are just humans with a different texture
				bodyStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalebody_0.nif";
				handsStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalehands_0.nif";
				feetStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\femalefeet_0.nif";
				eyesStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\eyesfemale.nif";
				helmetStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\hair\\female\\hair01.nif";
			}
			else
			{
				headStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malehead.nif";
				//All beast races are just humans with a different texture
				bodyStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malebody_0.nif";
				handsStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malehands_0.nif";
				feetStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\malefeet_0.nif";
				eyesStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\eyesmale.nif";
				helmetStr = ESConfig.TES_MESH_PATH + "actors\\character\\character assets\\hair\\male\\hair01.nif";
			}

			List<CNTO> cntos = npc_.CNTOs;
			for (int i = 0; i < cntos.size(); i++)
			{
				//	int count = cntos[i].count;
				Record rec = master.getRecord(cntos.get(i).itemFormId);
				if (rec.getRecordType().equals("WEAP"))
				{
					WEAP weap = new WEAP(rec);
					addWEAP(weap);
				}
				else if (rec.getRecordType().equals("ARMO"))
				{
					ARMO armo = new ARMO(rec);
					addARMO(armo, master);
				}
				else if (rec.getRecordType().equals("AMMO"))
				{
					//AMMO ammo = new AMMO(rec);
				}
				else if (rec.getRecordType().equals("MISC"))
				{
					//MISC misc = new MISC(rec);
				}
				else if (rec.getRecordType().equals("KEYM"))
				{
					//KEYM keym = new KEYM(rec);
				}
				else if (rec.getRecordType().equals("INGR"))
				{
					//INGR keym = new INGR(rec);
				}
				else if (rec.getRecordType().equals("LIGH"))
				{
					//LIGH ligh = new LIGH(rec);
				}
				else if (rec.getRecordType().equals("ALCH"))
				{
					//ALCH alch = new ALCH(rec);
				}
				else if (rec.getRecordType().equals("BOOK"))
				{
					//BOOK book = new BOOK(rec);
				}
				else if (rec.getRecordType().equals("NOTE"))
				{
					//NOTE book = new NOTE(rec);
				}
				else if (rec.getRecordType().equals("LVLI"))
				{
					LVLI lvli = new LVLI(rec);
					LVLO[] LVLOs = lvli.LVLOs;

					int idx = (int) (Math.random() * LVLOs.length);
					idx = idx == LVLOs.length ? 0 : idx;

					Record baseRecord = master.getRecord(LVLOs[idx].itemFormId);
					if (baseRecord.getRecordType().equals("ARMO"))
					{
						ARMO armo = new ARMO(baseRecord);
						addARMO(armo, master);
					}
					else if (baseRecord.getRecordType().equals("WEAP"))
					{
						WEAP weap = new WEAP(baseRecord);
						addWEAP(weap);
					}
					else if (baseRecord.getRecordType().equals("LVLI"))
					{
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
					else if (baseRecord.getRecordType().equals("BOOK"))
					{
					}

					else
					{
						System.out.println("LVLI record type not converted to j3d " + baseRecord.getRecordType());
					}
				}
				else
				{
					System.out.println("NPC_ has unknown contained item " + rec.getRecordType());
				}

			}

			// ok cool, humans have a special bunch of cock aroundy stuff
			// monsters have a skeleton dir, in side that is some body nifs
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
			idleAnimations.add(ESConfig.TES_MESH_PATH + "actors\\character\\animations\\mt_idle_a_base.kf");

			nifCharacter = new NifCharacter(skeletonNifFile, fileNames, mediaSources, idleAnimations);
			addChild(nifCharacter);
		}
		else
		{
			j3dCREA(npc_, master, mediaSources);

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
	}

	private void addWEAP(WEAP weap)
	{
		weapStr = weap.MODL.model.str;
	}

	/**
	 * fall back for simplish creatures
	 * @param npc_
	 * @param master
	 * @param meshSource
	 * @param textureSource
	 * @param soundSource
	 */
	private void j3dCREA(NPC_ npc_, IRecordStore master, MediaSources mediaSources)
	{
		RACE race = new RACE(master.getRecord(npc_.RNAM.formId));

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
		if (mediaSources.getMeshSource().nifFileExists(assetPath + "\\animations\\mt_idle.kf"))
			idleAnimations.add(assetPath + "\\animations\\mt_idle.kf");
		if (mediaSources.getMeshSource().nifFileExists(assetPath + "\\animations\\mtidle.kf"))
			idleAnimations.add(assetPath + "\\animations\\mtidle.kf");
		if (mediaSources.getMeshSource().nifFileExists(assetPath + "\\animations\\idle.kf"))
			idleAnimations.add(assetPath + "\\animations\\idle.kf");

		nifCharacter = new NifCharacter(skeletonNifFile, fileNames, mediaSources, idleAnimations);
		addChild(nifCharacter);

	}
}
