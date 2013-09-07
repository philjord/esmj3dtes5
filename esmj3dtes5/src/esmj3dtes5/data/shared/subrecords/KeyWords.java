package esmj3dtes5.data.shared.subrecords;

import java.util.ArrayList;

import tools.io.ESMByteConvert;
import esmj3d.data.shared.subrecords.FormID;

public class KeyWords
{
	public ArrayList<FormID> keywords = new ArrayList<FormID>();

	public int size = 0;

	public KeyWords()
	{

	}

	public void setKSIZ(byte[] bytes)
	{
		size = ESMByteConvert.extractInt(bytes, 0);
	}

	public void setKWDA(byte[] bytes)
	{
		keywords.add(new FormID(bytes));
	}
}
