/* BubbleDisplay
Draws some bubbles
Date: 9/15/16
Author: Nada Al-Thawr
Modified: 9/15/16 
 */
 
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class BubbleDisplay extends JComponent
{
	//Global constants

	//got this from the Color API found in our CS website
	//creating random colors every time the circles are drawn
	/*New random color is created for all our bubbles every time
	we run our program
	*/
	Random rand = new Random();
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();

	//removed static because it's no longer static
	 Color COLOR_BUBBLE = new Color(r, g, b);
	/*setting the bubble color as always being bright colors
	to clearly contrast the outline
	*/
	 Color COLOR_BUBBLE_LIGHT = COLOR_BUBBLE.brighter();
	 Color COLOR_OUTLINE = COLOR_BUBBLE.darker();
	public static Color COLOR_HIGHLIGHT = Color.WHITE;
	public static int DIAM_BUBBLE = 50;
	
	/**
	 * Constructor to draw bubbles
	 **/
	public BubbleDisplay()
	{
		// Call the superclass' constructor
		super();
	}
	
	/**
	 * Override the paint method to draw bubbles
	 **/
	public void paint( Graphics g )
	{
		//Start with the x and y values of the upper left corner of the bubble
		int x = 0;
		int y = 0;
		//Draw sixteen bubbles in a row
		for (int i = 0; i < 16; i++) {

				drawBubble(g, x, y);
			
			//Draw sixteen bubbles in a column
			for (int j = 0; j < 10; j++) {

				drawBubble(g, x, y);
				//update y so it doesn't draw on top of it
				y = y + 50;
			}

			//update x and y
				y = 0;
				x = x + 50;
				
		

			//System.out.println("Work?");
		}
	}
	
	
	/**
	 * Draw a single bubble
	 **/
	public void drawBubble(Graphics g, int x, int y)
	{
		// Set the color of the inside of the bubble
		g.setColor(COLOR_BUBBLE_LIGHT);
		
		// Draw the inside of the bubble (upper left x, upper left y, width, height)
		g.fillOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);
		
		//Set the color of the outside of the bubble
		g.setColor(COLOR_OUTLINE);
		
		//Draw the outline of the bubble 
		g.drawOval(x, y, DIAM_BUBBLE, DIAM_BUBBLE);
		
		//Set the color of a highlight
		g.setColor(COLOR_HIGHLIGHT);
		
		//Draw the highlight as a rounded rectangle (upper left x, upper left y, width, hight, arc width, arc height)
		g.fillRoundRect(x+(DIAM_BUBBLE*3/5), y+(DIAM_BUBBLE/5), 10, 10, 5, 5);
	}
	
}