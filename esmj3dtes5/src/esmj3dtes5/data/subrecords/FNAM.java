package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class FNAM
{
	public byte mapFlags;

	public FNAM(byte[] bytes)
	{
		mapFlags = ESMByteConvert.extractByte(bytes, 0);
	}
}
