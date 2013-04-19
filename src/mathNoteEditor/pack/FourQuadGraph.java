package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Point;

import org.jhotdraw.figures.LineFigure;
import org.jhotdraw.figures.PolyLineFigure;

public class FourQuadGraph extends PolyLineFigure {


	public FourQuadGraph() {
		addPoint(0, 0);
		addPoint(0, 0);
		addPoint(0, 0);
		addPoint(0, 0);
		addPoint(0, 0);
	}
	
	/**
	 * Sets the start and end point.
	 */
	public void setPoints(Point mid, Point top, Point bot, Point left, Point right) {
		setPointAt(mid, 0);
		setPointAt(top, 1);
		setPointAt(bot, 2);
		setPointAt(left, 3);
		setPointAt(right, 4);
	}

	public void basicDisplayBox(Point origin, Point corner) {
		setPoints(new Point((origin.x + corner.x)/2, (origin.y + corner.y)/2), 
				new Point((origin.x + corner.x)/2, origin.y),
				new Point((origin.x + corner.x)/2, corner.y),
				new Point(origin.x, (origin.y + corner.y)/2),
				new Point(corner.x, (origin.y + corner.y)/2));
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getFrameColor());
		Point p1, p2;
		for (int i = 1; i < fPoints.size(); i++) {
			p1 = pointAt(0);
			p2 = pointAt(i);
			drawLine(g, p1.x, p1.y, p2.x, p2.y);
		}
	}
}
