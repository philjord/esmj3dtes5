package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class XESP
{
	//XESP 	enable parent 	struct 	8-byte struct

	//formid - Parent reference (Object to take enable state from)
	// uint32 - Flags (records with no flags set have random values in high bits)

	//   0x0001 = Set Enable State Opposite Parent
	//   0x0002 = Pop In

	public int parentId;

	public int flags;

	public XESP(byte[] bytes)
	{
		parentId = ESMByteConvert.extractInt(bytes, 0);
		flags = ESMByteConvert.extractInt(bytes, 4);
	}
}
