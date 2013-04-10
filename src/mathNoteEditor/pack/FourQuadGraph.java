package mathNoteEditor.pack;

import java.awt.Point;

import org.jhotdraw.figures.PolyLineFigure;

public class FourQuadGraph extends PolyLineFigure {

	public FourQuadGraph() {
		addPoint(0, 0);
		addPoint(0, 0);
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
		setPointAt(top, 0);
		setPointAt(mid, 1);
		setPointAt(bot, 2);
		setPointAt(mid, 3);
		setPointAt(left, 4);
		setPointAt(mid, 5);
		setPointAt(right, 6);
	}

	public void basicDisplayBox(Point origin, Point corner) {
		setPoints(new Point((origin.x + corner.x)/2, (origin.y + corner.y)/2), 
				new Point((origin.x + corner.x)/2, origin.y),
				new Point((origin.x + corner.x)/2, corner.y),
				new Point(origin.x, (origin.y + corner.y)/2),
				new Point(corner.x, (origin.y + corner.y)/2));
	}
}
