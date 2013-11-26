package esmj3dtes5.j3d.j3drecords.inst;

import utils.source.MeshSource;
import utils.source.SoundSource;
import utils.source.TextureSource;
import esmLoader.common.data.record.IRecordStore;
import esmLoader.common.data.record.Record;
import esmj3d.data.shared.records.RECO;
import esmj3d.data.shared.subrecords.ZString;
import esmj3d.j3d.BethRenderSettings;
import esmj3d.j3d.j3drecords.inst.J3dRECODynInst;
import esmj3d.j3d.j3drecords.inst.J3dRECOInst;
import esmj3d.j3d.j3drecords.inst.J3dRECOStatInst;
import esmj3d.j3d.j3drecords.type.J3dCONT;
import esmj3d.j3d.j3drecords.type.J3dDOOR;
import esmj3d.j3d.j3drecords.type.J3dRECOType;
import esmj3d.j3d.j3drecords.type.J3dRECOTypeGeneral;
import esmj3dtes5.data.records.ACTI;
import esmj3dtes5.data.records.ADDN;
import esmj3dtes5.data.records.ALCH;
import esmj3dtes5.data.records.AMMO;
import esmj3dtes5.data.records.ARMO;
import esmj3dtes5.data.records.BOOK;
import esmj3dtes5.data.records.CONT;
import esmj3dtes5.data.records.DOOR;
import esmj3dtes5.data.records.FLOR;
import esmj3dtes5.data.records.FURN;
import esmj3dtes5.data.records.GRAS;
import esmj3dtes5.data.records.INGR;
import esmj3dtes5.data.records.KEYM;
import esmj3dtes5.data.records.LIGH;
import esmj3dtes5.data.records.LVLI;
import esmj3dtes5.data.records.LVLN;
import esmj3dtes5.data.records.MISC;
import esmj3dtes5.data.records.MSTT;
import esmj3dtes5.data.records.NPC_;
import esmj3dtes5.data.records.REFR;
import esmj3dtes5.data.records.SOUN;
import esmj3dtes5.data.records.STAT;
import esmj3dtes5.data.records.TACT;
import esmj3dtes5.data.records.TREE;
import esmj3dtes5.data.records.WEAP;
import esmj3dtes5.data.subrecords.LVLO;
import esmj3dtes5.j3d.j3drecords.type.J3dLIGH;
import esmj3dtes5.j3d.j3drecords.type.J3dNPC_;
import esmj3dtes5.j3d.j3drecords.type.J3dSOUN;
import esmj3dtes5.j3d.j3drecords.type.J3dSTAT;

public class J3dREFRFactory
{
	//Note fader = true
	private static J3dRECODynInst makeJ3dRECODynInst(REFR refr, RECO reco, ZString nifFileName, boolean makePhys, MeshSource meshSource,
			TextureSource textureSource)
	{
		J3dRECODynInst j3dinst = new J3dRECODynInst(refr, true, makePhys);
		j3dinst.setJ3dRECOType(new J3dRECOTypeGeneral(reco, nifFileName.str, makePhys, meshSource, textureSource));

		return j3dinst;
	}

	//Note fader = true
	private static J3dRECOStatInst makeJ3dRECOStatInst(REFR refr, RECO reco, ZString nifFileName, boolean makePhys, MeshSource meshSource,
			TextureSource textureSource)
	{
		J3dRECOStatInst j3dinst = new J3dRECOStatInst(refr, true, makePhys);
		j3dinst.setJ3dRECOType(new J3dRECOTypeGeneral(reco, nifFileName.str, makePhys, meshSource, textureSource));

		return j3dinst;
	}

	public static J3dRECOInst makeJ3DRefer(REFR refr, boolean makePhys, IRecordStore master, MeshSource meshSource,
			TextureSource textureSource, SoundSource soundSource)
	{

		Record baseRecord = master.getRecord(refr.NAME.formId);

		if (baseRecord.getRecordType().equals("STAT"))
		{
			STAT stat = new STAT(baseRecord);
			if (stat.MODL != null && (!stat.isFlagSet(0x00800000) || BethRenderSettings.isShowEditorMarkers()))
			{
				// TODO: this stuff appears to refer to war like stuff enabled scenes
				// but I still see capapults!
				if (refr.XESP != null)
				{
					//System.out.println("parent spotting " + refr.XESP.parentId);
					//System.out.println("parent spotting " + refr.XESP.flags);
					//System.out.println("parent spotting " + stat.MODL.model.str);
				}
				else
				{
					// fader handled by STAT
					J3dRECOStatInst j3dinst = new J3dRECOStatInst(refr, false, makePhys);
					J3dSTAT j3dSTAT = new J3dSTAT(stat, makePhys, meshSource, textureSource);
					j3dinst.setJ3dRECOType(j3dSTAT);
					return j3dinst;
				}
			}

			return null;

		}
		else if (baseRecord.getRecordType().equals("ACTI"))
		{
			ACTI acti = new ACTI(baseRecord);
			if (acti.MODL != null)
			{
				return makeJ3dRECOStatInst(refr, acti, acti.MODL.model, makePhys, meshSource, textureSource);
			}
			else
			{
				//indicates a pure script
				return null;
			}
		}
		else if (baseRecord.getRecordType().equals("ADDN"))
		{
			ADDN addn = new ADDN(baseRecord);
			return makeJ3dRECODynInst(refr, addn, addn.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("ALCH"))
		{
			ALCH alch = new ALCH(baseRecord);
			return makeJ3dRECODynInst(refr, alch, alch.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("AMMO"))
		{
			AMMO ammo = new AMMO(baseRecord);
			return makeJ3dRECODynInst(refr, ammo, ammo.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("APPA"))
		{
			//TODO: why?
			//APPA appa = new APPA(baseRecord);
			//return makeJ3dRECOInstFader(refr, appa, appa.MODL.model, makePhys, meshSource, textureSource);
			return null;
		}
		else if (baseRecord.getRecordType().equals("ARMO"))
		{
			ARMO armo = new ARMO(baseRecord);
			return makeJ3dRECODynInst(refr, armo, armo.MOD2.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("BOOK"))
		{
			BOOK book = new BOOK(baseRecord);
			return makeJ3dRECODynInst(refr, book, book.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("CONT"))
		{
			J3dRECOStatInst j3dinst = new J3dRECOStatInst(refr, new J3dCONT(new CONT(baseRecord), makePhys, meshSource, textureSource),
					true, makePhys);
			return j3dinst;
		}
		else if (baseRecord.getRecordType().equals("FURN"))
		{
			FURN furn = new FURN(baseRecord);
			return makeJ3dRECOStatInst(refr, furn, furn.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("GRAS"))
		{
			GRAS gras = new GRAS(baseRecord);
			return makeJ3dRECOStatInst(refr, gras, gras.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("KEYM"))
		{
			KEYM keym = new KEYM(baseRecord);
			return makeJ3dRECODynInst(refr, keym, keym.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("MISC"))
		{
			MISC misc = new MISC(baseRecord);
			return makeJ3dRECODynInst(refr, misc, misc.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("MSTT"))
		{
			MSTT mstt = new MSTT(baseRecord);
			return makeJ3dRECODynInst(refr, mstt, mstt.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("TACT"))
		{
			TACT tact = new TACT(baseRecord);
			return makeJ3dRECOStatInst(refr, tact, tact.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("WEAP"))
		{
			WEAP weap = new WEAP(baseRecord);
			return makeJ3dRECODynInst(refr, weap, weap.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("INGR"))
		{
			INGR ingr = new INGR(baseRecord);
			return makeJ3dRECODynInst(refr, ingr, ingr.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("FLOR"))
		{
			FLOR flor = new FLOR(baseRecord);
			return makeJ3dRECOStatInst(refr, flor, flor.MODL.model, makePhys, meshSource, textureSource);
		}
		else if (baseRecord.getRecordType().equals("SLGM"))
		{
			//SLGM slgm = new SLGM(baseRecord);
		}
		else if (baseRecord.getRecordType().equals("ASPC"))
		{
			//ASPC aspc = new ASPC(baseRecord);			
		}
		else if (baseRecord.getRecordType().equals("IDLM"))
		{
			//IDLM idlm = new IDLM(baseRecord);			
		}
		else if (baseRecord.getRecordType().equals("TXST"))
		{

		}
		else if (baseRecord.getRecordType().equals("DOOR"))
		{
			return new J3dRECOStatInst(refr, new J3dDOOR(new DOOR(baseRecord), makePhys, meshSource, textureSource), true, makePhys);
		}
		else if (baseRecord.getRecordType().equals("LIGH"))
		{
			return new J3dRECOStatInst(refr, new J3dLIGH(new LIGH(baseRecord), makePhys, meshSource, textureSource), true, makePhys);
		}
		else if (baseRecord.getRecordType().equals("TREE"))
		{
			TREE tree = new TREE(baseRecord);
			//TODO: tree models themselves have cool animated and nanimated version inside,
			//must work out how to switch
			J3dRECOStatInst j3dinst = new J3dRECOStatInst(refr, true, makePhys);

			String treeNif = tree.MODL.model.str;
			//Has Tree LOD = 0x00000040		
			if (refr.isFlagSet(0x00000040))//meshSource.nifFileExists(treeLodFlat))
			{
				String treeLodFlat = treeNif.substring(0, treeNif.indexOf(".nif")) + "_lod_flat.nif";
				j3dinst.setJ3dRECOType(//
						new J3dRECOTypeGeneral(refr, treeNif, makePhys, meshSource, textureSource),//
						new J3dRECOTypeGeneral(refr, treeLodFlat, makePhys, meshSource, textureSource));
			}
			else
			{
				j3dinst.setJ3dRECOType(new J3dRECOTypeGeneral(refr, treeNif, makePhys, meshSource, textureSource));
			}
			return j3dinst;
		}
		else if (baseRecord.getRecordType().equals("SOUN"))
		{
			if (!makePhys)
			{
				return new J3dRECOStatInst(refr, new J3dSOUN(new SOUN(baseRecord), master, soundSource), false, makePhys);
			}
		}
		else if (baseRecord.getRecordType().equals("LVLN"))
		{
			if (!makePhys)
			{
				LVLN lvln = new LVLN(baseRecord);
				J3dRECODynInst j3dinst = new J3dRECODynInst(refr, false, makePhys);
				j3dinst.setJ3dRECOType(makeLVLN(lvln, master, meshSource, textureSource, soundSource));
				return j3dinst;
			}
		}
		else if (baseRecord.getRecordType().equals("LVLI"))
		{
			if (!makePhys)
			{
				LVLI lvli = new LVLI(baseRecord);
				J3dRECODynInst j3dinst = new J3dRECODynInst(refr, false, makePhys);
				j3dinst.setJ3dRECOType(makeLVLI(lvli, master, meshSource, textureSource, soundSource));
				return j3dinst;
			}
		}

		else
		{
			System.out.println("REFR record type not converted to j3d " + baseRecord.getRecordType());
		}

		return null;

	}

	/** TODO: Note does not bother with teh ACRE or ACHR system
	 * 
	 * @param lvlc
	 * @param master
	 * @param meshSource
	 * @param textureSource
	 * @param soundSource
	 * @return
	 */
	protected static J3dRECOType makeLVLN(LVLN lvln, IRecordStore master, MeshSource meshSource, TextureSource textureSource,
			SoundSource soundSource)
	{
		// TODO: randomly picked for now
		LVLO[] LVLOs = lvln.LVLOs;

		int idx = (int) (Math.random() * LVLOs.length);
		idx = idx == LVLOs.length ? 0 : idx;

		Record baseRecord = master.getRecord(LVLOs[idx].itemFormId);

		if (baseRecord.getRecordType().equals("LVLC"))
		{
			// it is in fact a pointer across to another leveled creature (LVLC)
			LVLN lvln2 = new LVLN(baseRecord);
			return makeLVLN(lvln2, master, meshSource, textureSource, soundSource);
		}
		else if (baseRecord.getRecordType().equals("NPC_"))
		{
			// it is in fact a pointer across to another leveled creature (LVLC)
			NPC_ npc_ = new NPC_(baseRecord);
			return new J3dNPC_(npc_, master, meshSource, textureSource, soundSource);
		}
		else
		{
			System.out.println("LVLN record type not converted to j3d " + baseRecord.getRecordType());
		}

		return null;
	}

	protected static J3dRECOType makeLVLI(LVLI lvli, IRecordStore master, MeshSource meshSource, TextureSource textureSource,
			SoundSource soundSource)
	{
		// TODO: randomly picked for now
		LVLO[] LVLOs = lvli.LVLOs;

		int idx = (int) (Math.random() * LVLOs.length);
		idx = idx == LVLOs.length ? 0 : idx;

		Record baseRecord = master.getRecord(LVLOs[idx].itemFormId);

		if (baseRecord.getRecordType().equals("LVLI"))
		{
			// it is in fact a pointer across to another leveled creature (LVLC)
			LVLI lvli2 = new LVLI(baseRecord);
			return makeLVLI(lvli2, master, meshSource, textureSource, soundSource);
		}
		else if (baseRecord.getRecordType().equals("NPC_"))
		{
			// it is in fact a pointer across to another leveled creature (LVLC)
			NPC_ npc_ = new NPC_(baseRecord);
			return new J3dNPC_(npc_, master, meshSource, textureSource, soundSource);
		}
		else
		{
			System.out.println("LVLI record type not converted to j3d " + baseRecord.getRecordType());
		}

		return null;
	}

}
