package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class XRNK
{
	public int rank;

	public XRNK(byte[] bytes)
	{
		rank = ESMByteConvert.extractInt(bytes, 0);
	}
}
