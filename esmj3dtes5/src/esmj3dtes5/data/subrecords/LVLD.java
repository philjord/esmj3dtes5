package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class LVLD
{
	public byte chanceNone;

	public LVLD(byte[] bytes)
	{
		chanceNone = ESMByteConvert.extractByte(bytes, 0);
	}
}
