package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class CNAM_b
{
	public byte unknown;

	public CNAM_b(byte[] bytes)
	{
		unknown = ESMByteConvert.extractByte(bytes, 0);
	}
}
