package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class INDX
{
	public int idx;

	public INDX(byte[] bytes)
	{
		idx = ESMByteConvert.extractInt(bytes, 0);
	}
}
