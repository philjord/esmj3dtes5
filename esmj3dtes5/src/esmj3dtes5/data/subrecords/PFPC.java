package esmj3dtes5.data.subrecords;

import utils.ESMByteConvert;

public class PFPC
{
	public byte spring;

	public byte summer;

	public byte fall;

	public byte winter;

	public PFPC(byte[] bytes)
	{
		spring = ESMByteConvert.extractByte(bytes, 0);
		summer = ESMByteConvert.extractByte(bytes, 0);
		fall = ESMByteConvert.extractByte(bytes, 0);
		winter = ESMByteConvert.extractByte(bytes, 0);
	}
}
