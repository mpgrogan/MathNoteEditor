package mathNoteEditor.pack;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JToolBar;
import org.jhotdraw.application.DrawApplication;
import org.jhotdraw.contrib.TriangleFigure;
import org.jhotdraw.contrib.zoom.ZoomDrawingView;
import org.jhotdraw.figures.AbstractLineDecoration;
import org.jhotdraw.figures.ArrowTip;
import org.jhotdraw.figures.ConnectedTextTool;
import org.jhotdraw.figures.EllipseFigure;
import org.jhotdraw.figures.LineFigure;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.framework.Drawing;
import org.jhotdraw.framework.DrawingView;
import org.jhotdraw.framework.Tool;
import org.jhotdraw.samples.javadraw.JavaDrawApp;
import org.jhotdraw.standard.CreationTool;

public class MathNoteEditorGUI extends DrawApplication {

	/**
	 * @param args
	 */
	
	public MathNoteEditorGUI() {
		super("Tool test");
	}
	
	
	@Override
	protected void createTools(JToolBar palette) {
		super.createTools(palette);
		Tool triangleTool = new CreationTool(this, new TriangleFigure());
		Tool ellipseTool = new CreationTool(this, new EllipseFigure());
		Tool lineTool = new CreationTool(this, new LineFigure());
		AbstractLineDecoration arrowTip = new ArrowTip();
		
		palette.add(createToolButton(IMAGES + "TRIANGLE", "Triangle Tool", triangleTool));
		palette.add(createToolButton(IMAGES + "ELLIPSE", "Ellipse Tool", ellipseTool));
		palette.add(createToolButton(IMAGES + "LINE", "Line Tool", lineTool));
		//arrowTip.draw(lineTool, x1, y1, x2, y2)
	}
	
	@Override
	public void toolDone() {
		
	}
	
	public static void main(String[] args) {
		DrawApplication window = new MathNoteEditorGUI();
		window.open();
	}
}
