package mathNoteEditor.pack;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import org.jhotdraw.figures.PolyLineFigure;

public class DashedLine extends PolyLineFigure {
	
    private Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	
	public DashedLine() {
		addPoint(0, 0);
		addPoint(0, 0);
	}
	
	@Override
	protected void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(dashed);
		super.drawLine(g2d, x1, y1, x2, y2);
	}

}
