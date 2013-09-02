package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class SNAM
{
	public int factionFormId;

	public byte rank;

	public SNAM(byte[] bytes)
	{
		factionFormId = ESMByteConvert.extractInt(bytes, 0);
		rank = ESMByteConvert.extractByte(bytes, 4);
		//3 more bytes possibly flag possibly 4 byte align padding 
	}
}
