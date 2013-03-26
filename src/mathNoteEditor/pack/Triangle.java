package mathNoteEditor.pack;

import org.jhotdraw.contrib.TriangleFigure;
import org.jhotdraw.figures.AttributeFigure;
import org.jhotdraw.framework.FigureAttributeConstant;

public class Triangle extends TriangleFigure {
	
	public Triangle(MathNoteEditorGUI mneg) {
		
		setAttribute(FigureAttributeConstant.FILL_COLOR, mneg.getDefaultShapeColor());
	}
}
