package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TickedGraph extends SimpleGraph {
	
	private final double TICK_DIST=20;
	private Integer xmax;
	private Integer ymax;
	
	public TickedGraph() {
		
	}
	
	@Override
	protected void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		int dx = x2 - x1, dy = y2 - y1;
        g.drawLine(x1, y1, x2, y2);

        for (double i = 0; i < dy; i += TICK_DIST) {
            g.drawLine((int) (x1-3), (int) (y2-i), (int) (x1+3), (int) (y2-i));
        }
        for (double i = 0; i < dx; i += TICK_DIST) {
            g.drawLine((int) (x1+i), (int) (y2-3), (int) (x1+i), (int) (y2+3));
        }
	}
	
	public void setXMax(Integer m) {
		xmax = m;
//		System.out.println(xmax);
	}
	
	public void setYMax(Integer m) {
		ymax = m;
//		System.out.println(ymax);
	}
}
