package entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public abstract class SceneEntity 
{	
	protected double xPos, yPos, xVel, yVel, width, height;
	protected ImageView sprite;
	
	
	public double getXpos()
	{
		return xPos;
	}
	
	public double getYPos()
	{
		return yPos;
	}
	
	public double getXVel()
	{
		return xVel;
	}
	
	public double getYVel()
	{
		return yVel;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWidth()
	{
		return width;
	}

	public void setX(double x)
	{
		xPos = x;
	}
	
	public void setY(double y)
	{
		yPos = y;
	}
	
	public void setPos(double xPos, double yPos)
	{
		xPos = xPos;
		yPos = yPos;
	}
	
	public void setXVel(double x)
	{
		xVel = x;
	}
	
	public void setYVel(double y)
	{
		yVel = y;
	}	
	
	public ImageView getSprite()
	{
		return sprite;
	}
	
	public abstract void update();
	public abstract Rectangle2D getHitbox();
	public abstract boolean intersects(Rectangle2D collider);
	
	
}
