package inactive;

import entities.SceneEntity;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import resourceLoader.ResourceManager;
import resourceLoader.exceptions.ResourceNotFoundException;

public class Sprite extends SceneEntity 
{
	private SpriteRule rule;
	
	@Override
	public void update() 
	{
		if(xVel > 0)
			xPos += xVel;
		if(yVel > 0)
			yPos += yVel;

	}

	@Override
	public Rectangle2D getHitbox() 
	{
		return new Rectangle2D(xPos, yPos, width, height);
	}

	@Override
	public boolean intersects(Rectangle2D collider) 
	{
		return collider.intersects(new Rectangle2D(xPos, yPos, width, height));
	}
	
	public SpriteRule getSpriteRule()
	{
		return rule;
	}
	
	public Sprite(String name) throws ResourceNotFoundException
	{
		sprite = new ImageView(ResourceManager.manager.getSprite(name));
		if(rule != null)
		{
			width = rule.getWidth();
			height = rule.getHeight();
		}
		else
		{
			width = sprite.getImage().getWidth();
			height = sprite.getImage().getHeight();
		}
	}

}
