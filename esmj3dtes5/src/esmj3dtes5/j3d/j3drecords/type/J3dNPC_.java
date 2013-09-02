package esmj3dtes5.j3d.j3drecords.type;

import java.util.List;

import nif.character.NifCharacter;
import utils.source.MeshSource;
import utils.source.SoundSource;
import utils.source.TextureSource;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.data.shared.subrecords.CNTO;
import esmj3d.j3d.j3drecords.type.J3dRECOType;
import esmj3dtes5.data.records.ARMO;
import esmj3dtes5.data.records.LVLI;
import esmj3dtes5.data.records.NPC_;
import esmj3dtes5.data.records.RACE;
import esmj3dtes5.data.records.WEAP;
import esmj3dtes5.data.subrecords.LVLO;

public class J3dNPC_ extends J3dRECOType
{
	//private boolean upper = false;

	//private boolean lower = false;

	//private boolean hand = false;

	//private boolean foot = false;

	//private boolean shield = false;

	//private boolean female = false;

	public J3dNPC_(NPC_ npc_, IRecordStore master, MeshSource meshSource, TextureSource textureSource, SoundSource soundSource)
	{
		super(npc_, null);
		//String path = npc_.MODL.getPath();

		//female = npc_.ACBS.isFemale();

		Record rrec = master.getRecord(npc_.RNAM.formId);
		RACE race = new RACE(rrec);

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
				//ARMO armo = new ARMO(rec);
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
					armo.getClass();
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
				else if (baseRecord.getRecordType().equals("WEAP"))
				{
					WEAP weap = new WEAP(baseRecord);
					addWEAP(weap);
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

		String skeletonNifFile = "actors\\character\\character assets female\\skeleton_female.nif";

		String[] fileNames = new String[5];
		fileNames[0] = "actors\\character\\character assets\\femalebody_0.nif";
		fileNames[1] = "actors\\character\\character assets\\femalehead.nif";
		fileNames[2] = "actors\\character\\character assets\\femalehands_0.nif";
		fileNames[3] = "actors\\character\\character assets\\femalefeet_0.nif";
		fileNames[4] = "actors\\character\\character assets\\eyesfemale.nif";

		NifCharacter nifCharacter = new NifCharacter(skeletonNifFile, fileNames, meshSource, textureSource, "");
		addChild(nifCharacter);

	}

	private void addWEAP(WEAP weap)
	{
		weap.getClass();
	}

}
