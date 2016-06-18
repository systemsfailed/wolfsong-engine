package resourceLoader;

public class ResourceObject 
{
	final public static String SPRITE = "sprite";
	final public static String SOUNDEFFECT = "sound effect";
	final public static String MUSIC = "music";
	
	String name;
	String file;
	String directory;
	String type;
	
	public ResourceObject(String name, String file, String directory, String type)
	{
		this.name = name;
		this.file = file;
		this.directory = directory;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getFile() {
		return file;
	}

	public String getDirectory() {
		return directory;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String toString()
	{
		return(name + " " + directory + " " + file + " " + type);
	}
}
