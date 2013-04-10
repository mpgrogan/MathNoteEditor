package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TickedGraph extends SimpleGraph {
	
	private final double TICK_DIST=20;
	
	public TickedGraph() {
		
	}
	
	@Override
	protected void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g.create();
		double dx = x2 - x1, dy = y2 - y1;
        double len = Math.sqrt(dx*dx + dy*dy);
        g.drawLine(x1, y1, x2, y2);
        for (double i = 0; i < len; i += TICK_DIST) {
            g.drawLine((int) (x1-3), (int) (y2-i), (int) (x1+3), (int) (y2-i));
            g.drawLine((int) (x1+i), (int) (y2-3), (int) (x1+i), (int) (y2+3));          
        }
	}
}
