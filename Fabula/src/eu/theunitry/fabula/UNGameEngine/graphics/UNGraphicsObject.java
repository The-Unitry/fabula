package eu.theunitry.fabula.UNGameEngine.graphics;

import eu.theunitry.fabula.UNGameEngine.objects.UNObject;

import javax.swing.*;
import java.awt.*;

/**
 * The UNGraphicsObject class is used for objects that are displayed inside an UNGraphicsView.
 * By default, the objects has a hitbox that can be used for collision detection.
 * Also, it can display an image. Later we will add support for spritesheets.
 */
public class UNGraphicsObject extends UNObject
{
    private JFrame frame;
    private int x;
    private int y;
    private Image image;
    private boolean clickable;
    private Rectangle hitbox;
    private boolean mouseClick, mouseHold;
    private int width, height;
    private int xOffset, yOffset, mouseXOffset, mouseYOffset, angle;

    /**
     * GraphicsObject
     * @param frame
     * @param x
     * @param y
     * @param image
     * @param clickable
     * @param width
     * @param height
     */
    public UNGraphicsObject(JFrame frame, int x, int y, Image image, boolean clickable, int width, int height)
    {
        this.frame = frame;
        this.x = x;
        this.y = y;
        this.image = image;
        this.clickable = clickable;
        this.mouseHold = false;
        this.width = width;
        this.height = height;
        this.angle = 0;
        this.xOffset = image.getWidth(null) / 2;
        this.yOffset = image.getHeight(null) / 2;
        this.hitbox = new Rectangle(x, y, width, height);
    }

    /**
     * Graphics Object (without height & width)
     * @param frame
     * @param x
     * @param y
     * @param image
     * @param clickable
     */
    public UNGraphicsObject(JFrame frame, int x, int y, Image image, boolean clickable)
    {
        this.frame = frame;
        this.x = x;
        this.y = y;
        this.image = image;
        this.clickable = clickable;
        this.mouseHold = false;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.angle = 0;
        this.xOffset = this.width / 2;
        this.yOffset = this.height / 2;
        this.hitbox = new Rectangle(x, y, width, height);
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int x)
    {
        if (isClickable())
        {
            x = Math.max(0, Math.min(frame.getContentPane().getWidth() - this.getWidth(), x));
            if (y > frame.getContentPane().getHeight() - 152 - this.getHeight())
            {
                x = Math.min(575 - this.getWidth(), x);
            }
        }
        this.x = x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int y)
    {
        if (isClickable())
        {
            y = Math.max(64, Math.min(frame.getContentPane().getHeight() - 46 - this.getHeight(), y));
            if (x > 575 - this.getWidth())
            {
                y = Math.min(frame.getContentPane().getHeight() - 152 - this.getHeight(), y);
            }
        }
        this.y = y;
    }

    public Image getImage()
    {
        return this.image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public boolean isClickable()
    {
        return this.clickable;
    }

    public void setClickable(boolean clickable)
    {
        this.clickable = clickable;
    }

    /**
     * Set hitbox
     * @param xOffset
     * @param yOffset
     * @param width
     * @param height
     */
    public void setHitbox(int xOffset, int yOffset, int width, int height)
    {
        hitbox = new Rectangle(getX() + xOffset, getY() + yOffset, width, height);
    }

    public Rectangle getHitbox(boolean solid)
    {
        if (solid) {
            return hitbox;
        } else {
            return new Rectangle(getX(), getY(), getWidth(), getHeight());
        }
    }

    public Rectangle getHitbox()
    {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setMouseClick(boolean mouseClick)
    {
        this.mouseClick = mouseClick;
    }

    public boolean isMouseClick()
    {
        return this.mouseClick;
    }

    public void setMouseHold(boolean mouseHold)
    {
        this.mouseHold = mouseHold;
    }

    public boolean getMouseHold()
    {
        return this.mouseHold;
    }

    public void setXOffset(int xOffset)
    {
        this.xOffset = xOffset;
    }

    public int getXOffset()
    {
        return this.xOffset;
    }

    public void setYOffset(int yOffset)
    {
        this.yOffset = yOffset;
    }

    public int getYOffset()
    {
        return this.yOffset;
    }
    public void setMouseXOffset(int mouseXOffset)
    {
        this.mouseXOffset = mouseXOffset;
    }

    public int getMouseXOffset()
    {
        return this.mouseXOffset;
    }

    public void setMouseYOffset(int mouseYOffset)
    {
        this.mouseYOffset = mouseYOffset;
    }

    public int getMouseYOffset()
    {
        return this.mouseYOffset;
    }

    public void setAngle(int angle)
    {
        this.angle = angle;
        this.angle -= 360 * (Math.floor(this.angle / 360));
        this.angle += 360 * (Math.ceil(Math.abs(this.angle / 360)));
    }

    public int getAngle()
    {
        return this.angle;
    }
}
