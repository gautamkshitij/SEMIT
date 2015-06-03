package uic.semit.Project.SourceCode;

public class CodeFile
{
	String fileName;
	String fileType;

	public CodeFile(String fileName, String fileType) throws Exception
	{

		this.fileName = fileName;
		this.fileType = fileType;

	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodeFile other = (CodeFile) obj;
		if (fileName == null)
		{
			if (other.fileName != null)
				return false;
		}
		else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null)
		{
			if (other.fileType != null)
				return false;
		}
		else if (!fileType.equals(other.fileType))
			return false;

		return true;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileType()
	{
		return fileType;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

}
