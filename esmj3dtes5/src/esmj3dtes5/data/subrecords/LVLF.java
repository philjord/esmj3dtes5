package esmj3dtes5.data.subrecords;

import tools.io.ESMByteConvert;

public class LVLF
{
	public byte flags;

	public LVLF(byte[] bytes)
	{
		flags = ESMByteConvert.extractByte(bytes, 0);
	}
}
