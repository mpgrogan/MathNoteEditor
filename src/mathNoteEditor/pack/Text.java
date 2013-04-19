package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.RepaintManager;

import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.framework.FigureAttributeConstant;

public class Text extends TextFigure {
	@Override
	public int overlayColumns() {
		int length = getText().length();
		int columns = 100;
		if (length != 0) {
			columns = getText().length() + 3;
		}
		return columns;
	}	
}
