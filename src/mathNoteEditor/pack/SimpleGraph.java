package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import org.jhotdraw.figures.PolyLineFigure;
import org.jhotdraw.framework.HandleEnumeration;
import org.jhotdraw.standard.BoxHandleKit;
import org.jhotdraw.standard.HandleEnumerator;
import org.jhotdraw.util.CollectionsFactory;

public class SimpleGraph extends PolyLineFigure{

	public SimpleGraph() {
		addPoint(0, 0);
		addPoint(0, 0);
		addPoint(0, 0);
	}
	

	public Point startPoint() {
		return pointAt(0);
	}
	
	public Point midPoint() {
		return pointAt(1);
	}

	public Point endPoint() {
		return pointAt(2);
	}

	/**
	 * Sets the start point.
	 */
	public void startPoint(int x, int y) {
		setPointAt(new Point(x,y), 0);
	}
	
	/*
	 * Sets the mid point.
	 */
	public void midPoint(int x, int y) {
		setPointAt(new Point(x,y), 1);
	}

	/**
	 * Sets the end point.
	 */
	public void  endPoint(int x, int y) {
		setPointAt(new Point(x,y), 2);
	}

	/**
	 * Sets the start and end point.
	 */
	public void setPoints(Point start, Point mid, Point end) {
		setPointAt(start, 0);
		setPointAt(mid, 1);
		setPointAt(end, 2);
	}

	public void basicDisplayBox(Point origin, Point corner) {
		setPoints(origin, new Point(origin.x, corner.y), corner);
	}
	
	

}
