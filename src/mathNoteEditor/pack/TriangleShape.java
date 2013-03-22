package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Rectangle;

import org.jhotdraw.figures.RectangleFigure;

public class TriangleShape extends RectangleFigure {
	
	
	@Override
	public void drawBackground(Graphics g) {
		Rectangle r = displayBox();
		int [] xpoints = new int[]{r.width/2+r.x, r.x, r.x+r.width};
		int [] ypoints = new int[]{r.y, r.y+r.height, r.y+r.height};
		System.out.println(xpoints[0] + " " + xpoints[1] + " " + xpoints[2]);
		System.out.println(ypoints[0] + " " + ypoints[1] + " " + ypoints[2]);
		g.fillPolygon(xpoints, ypoints, 3);
	}
	
	@Override
	public void drawFrame(Graphics g) {
		Rectangle r = displayBox();
		int [] xpoints = new int[]{r.width/2+r.x, r.x, r.x+r.width};
		int [] ypoints = new int[]{r.y, r.y+r.height, r.y+r.height};
		g.drawPolygon(xpoints, ypoints, 3);
	}

}
