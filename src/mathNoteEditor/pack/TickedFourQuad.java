package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TickedFourQuad extends FourQuadGraph {

	private final double TICK_DIST=20;
	private int min;
	private int max;


	public TickedFourQuad() {

	}

	@Override
	protected void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		Graphics2D g2d = (Graphics2D) g.create();
		double dx = x2 - x1, dy = y2 - y1;
		double len = Math.sqrt(dx*dx + dy*dy);
		AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
		at.concatenate(AffineTransform.getRotateInstance(Math.atan2(dy, dx)));
		g2d.transform(at);

		// Draw horizontal ruler starting in (0, 0)
		g2d.drawLine(0, 0, (int) len, 0);
		for (double i = 0; i < len; i += TICK_DIST) {
			g2d.drawLine((int) i, -3, (int) i, 3);
		}
	}
}
