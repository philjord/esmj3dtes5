package esmj3dtes5.data.records;

import java.util.List;

import esfilemanager.common.data.record.Record;
import esfilemanager.common.data.record.Subrecord;
import esmj3d.data.shared.records.CommonWRLD;
import esmj3d.data.shared.subrecords.ZString;
import tools.io.ESMByteConvert;

public class WRLD extends CommonWRLD
{


	public ZString ICON = null;
	
	public int PNAM = 0;

	public WRLD(Record recordData)
	{
		super(recordData);
		List<Subrecord> subrecords = recordData.getSubrecords();
		for (int i = 0; i < subrecords.size(); i++)
		{
			Subrecord sr = subrecords.get(i);
			byte[] bs = sr.getSubrecordData();

			if (sr.getSubrecordType().equals("SNAM"))
			{
				/*SNAM 	long 	Sound if not Default

    			1=Public
    			2=Dungeon */
			}
			else if (sr.getSubrecordType().equals("ICON"))
			{
				//ICON 	zstring 	Map filename
				ICON = new ZString(bs);
			}
			else if (sr.getSubrecordType().equals("NAM0"))
			{
				//NAM0 	unknown 	int32[2] 	Coordinates for the bottom left corner of the worldspace (assumed from Oblivion)
			}
			else if (sr.getSubrecordType().equals("NAM9"))
			{
				//NAM9 	unknown 	int32[2] 	Coordinates for the top right corner of the worldspace (assumed from Oblivion)
			}
			else if (sr.getSubrecordType().equals("OFST"))
			{
				//ignore
				// 	OFST 	unknown 	unknown 	unknown large struct (tamriel = 45600) offset? apparently, contains absolute file offsets to cells, for debugging purposes.
			}
			else if (sr.getSubrecordType().equals("MNAM"))
			{
				/*MNAM 	Map size 	struct 	16 or 28 byte structure
				width 	uint32 	The usable width of the map
				height 	uint32 	The usable height of the map
				NW cell X 	int16 	
				NW cell Y 	int16 	
				SE cell X 	int16 	
				SE cell Y 	int16 	
				Min Height 	float 	Camera Data (default 50000), new as of Skyrim 1.8, purpose is not yet known.
				Max Height 	float 	Camera Data (default 80000)
				Initial Pitch 	float 	Camera Data (default 50)*/
			}
			else if (sr.getSubrecordType().equals("XEZN"))
			{
				// 	XEZN 	unknown 	formID 	Encounter Zone ECZN
			}
			else if (sr.getSubrecordType().equals("PNAM"))
			{
				PNAM = ESMByteConvert.extractShort(bs, 0);
				/*PNAM 	unknown 	uint16 	Use flags - Set if parts are inherited from parent worldspace WNAM
				    0x01 - Use Land Data (DNAM)
				    0x02 - Use LOD Data (NAM3, NAM4)
				    0x04 - Use Map Data (MNAM, MODL)
				    0x08 - Use Water Data (NAM2)
				    0x10 - unknown
				    0x20 - Use Climate Data (CNAM)
				    0x40 - Use Sky Cell 
				    */
			}
			else if (sr.getSubrecordType().equals("NAM3"))
			{
				//NAM3 	LOD Water Type 	formID 	LOD water-type, always a WATR form ID
			}
			else if (sr.getSubrecordType().equals("NAM4"))
			{
				// 	NAM4 	LOD Water Height 	float 	LOD oceanwater-level (-14000.0 for Tamriel)
			}
			else if (sr.getSubrecordType().equals("ONAM"))
			{
				/*
				 * ONAM 	unknown 	float[4] 	This field specifies where map markers will appear in relation to the parent
			
			    World Map Scale - -1=Hide Map Markers
			    Cell X Offset * 4096
			    Cell Y Offset * 4096
			    Cell Z Offset * 4096 
				 */
			}
			else if (sr.getSubrecordType().equals("INAM"))
			{
				//
			}
			else if (sr.getSubrecordType().equals("ZNAM"))
			{
				//
			}
			else if (sr.getSubrecordType().equals("NNAM"))
			{
				//
			}
			else if (sr.getSubrecordType().equals("XNAM"))
			{
				//
			}
			else
			{
				//	System.out.println("unhandled : " + sr.getSubrecordType() + " in record " + recordData + " in " + this);
			}
		}
	}


	 

}
