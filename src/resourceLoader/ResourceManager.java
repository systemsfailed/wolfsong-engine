package resourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;

import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import resourceLoader.exceptions.ResourceNotFoundException;

public class ResourceManager 
{
	public static ResourceManager manager;
	
	public enum resourceTypes
	{
		SPRITE,SOUNDEFFECT,MUSIC	
	}
	
	private HashMap<String, ResourceObject> resources;
	private HashMap<String, ImageView> sprites;
	private HashMap<String, AudioClip> soundEffects;
	private HashMap<String, Media> music;
	private String path;
	
	public void load(String name) throws ResourceNotFoundException
	{
		if(resources.containsKey(name))
		{
			ResourceObject obj = resources.get(name);
			if(obj.getType().equals(ResourceObject.SPRITE))
			{
				sprites.put(name, new ImageView
						(path + "" + obj.getDirectory() + "/" + obj.getFile()));
				System.out.println("DEBUG: Added ImageView " + name);
			}
			else if(obj.getType().equals(ResourceObject.SOUNDEFFECT))
			{
				soundEffects.put(name, new AudioClip
						(path + "" + obj.getDirectory() + "/" + obj.getFile()));
				System.out.println("DEBUG: Added Audio Clip " + name);
			}
			else if(obj.getType().equals(ResourceObject.MUSIC))
			{
				music.put(name, new Media
						(path + "" + obj.getDirectory() + "/" + obj.getFile()));
				System.out.println("DEBUG: Added Media " + name);
			}
		}
		else
			throw new ResourceNotFoundException(name + "Not found!");	
	}
	
	public void unload(String name)
	{
		if(resources.containsKey(name))
		{
			ResourceObject obj = resources.get(name);
			if(obj.getType().equals(ResourceObject.SPRITE))
				sprites.remove(name);
			if(obj.getType().equals(ResourceObject.SOUNDEFFECT))
				soundEffects.remove(name);
			if(obj.getType().equals(ResourceObject.MUSIC))
				music.remove(name);
		}
	}
	
	public ImageView getSprite(String key) throws ResourceNotFoundException
	{
		if(sprites.containsKey(key))
				return sprites.get(key);
		else
		{
			if(resources.containsKey(key))
			{
				load(key);
				return sprites.get(key);
			}
			else
				throw new ResourceNotFoundException(key + "Not found");
		}		
	}
	
	public AudioClip getSoundEffect(String key) throws ResourceNotFoundException
	{
		if(soundEffects.containsKey(key))
				return soundEffects.get(key);
		else
			if(resources.containsKey(key))
			{
				load(key);
				return soundEffects.get(key);
			}
			else
				throw new ResourceNotFoundException(key + "Not found");			
	}
	
	public Media getSong(String key) throws ResourceNotFoundException
	{
		if(soundEffects.containsKey(key))
				return music.get(key);
		else
			if(resources.containsKey(key))
			{
				load(key);
				return music.get(key);
			}
			else
				throw new ResourceNotFoundException(key + "Not found");			
	}

	public void put(ResourceObject o)
	{
		resources.put(o.getName(), o);
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public String getFileName(String key)
	{
		return resources.get(key).getFile();
	}
	
	public String getFileDirectory(String key)
	{
		return resources.get(key).getDirectory();
	}
	
	public HashMap<String, ResourceObject> getResourceMap()
	{
		return resources;
	}
	
	public String getPath()
	{
		return path;
	}

	public ResourceManager()
	{
		resources = new HashMap<String, ResourceObject>();
		sprites = new HashMap<String, ImageView>();
		soundEffects = new HashMap<String, AudioClip>();
		music = new HashMap<String, Media>();
	}
	
	public static void initalize(String fileName) throws FileNotFoundException
	{
		manager = new ResourceManager();
		File ini = new File(fileName);
		
		FileReader reader = new FileReader(ini);
		Gson gson = new Gson();
		ResourceObject[] objs = gson.fromJson(reader, ResourceObject[].class);
		
		for(ResourceObject o : objs)
			manager.put(o);
			
		
		manager.setPath(ini.toURI().toString().split(fileName)[0]);
	}
	
	public void loadAll() throws ResourceNotFoundException
	{
		for(String name: resources.keySet())
			load(name);
	}

	
	public void unloadAll()
	{
		if(sprites.size() != 0)
			sprites = new HashMap<String, ImageView>();
		if(soundEffects.size() != 0)
			soundEffects = new HashMap<String, AudioClip>();
		if(music.size() != 0)
			music = new HashMap<String, Media>();
	}
	
}
