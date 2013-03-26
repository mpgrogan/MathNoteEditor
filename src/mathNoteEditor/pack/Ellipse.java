package mathNoteEditor.pack;

import org.jhotdraw.figures.EllipseFigure;
import org.jhotdraw.framework.FigureAttributeConstant;

public class Ellipse extends EllipseFigure{
	
	public Ellipse(MathNoteEditorGUI mneg) {
		this.setAttribute(FigureAttributeConstant.FILL_COLOR, mneg.getDefaultShapeColor());
	}

}
