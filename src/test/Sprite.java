package test;

import entities.SceneEntity;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import resourceLoader.ResourceManager;
import resourceLoader.exceptions.ResourceNotFoundException;

public class Sprite extends SceneEntity 
{
	int rows, cols, frameSpeed, row, col, counter;
	
	@Override
	public void update() 
	{

	}

	@Override
	public Rectangle2D getHitbox() 
	{
		return new Rectangle2D(xPos, yPos, width, height);
	}

	@Override
	public boolean intersects(Rectangle2D collider) 
	{
		
		return collider.intersects(getHitbox());
	}
	
	public Sprite(String name, int rows, int cols, int frameSpeed, int xPos, int yPos) throws ResourceNotFoundException
	{
		sprite = ResourceManager.manager.getSprite(name);
		this.rows = rows;
		this.cols = cols;
		this.frameSpeed = frameSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
		
		width = sprite.getImage().getWidth() / cols;
		height = sprite.getImage().getHeight() / rows;
		
		xVel = yVel = 0;
		row = col = counter;
		
		sprite.setViewport(new Rectangle2D(col * width, row * height, width, height));
		sprite.setVisible(true);
		
	}
	
	public void setFrame(int row, int col)
	{
		if(row >= 0 && row <= rows)
			this.row = row; 
		if(col >= 0 && col <= cols)
		this.col = col;
	}

}
