package mathNoteEditor.pack;

import java.awt.Color;
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
	static Color DEFAULT_SHAPE_COLOR = new Color(255, 255, 255, 0);
	
	public MathNoteEditorGUI() {
		super("MNE");
	}
	
	public Color getDefaultShapeColor() {
		return DEFAULT_SHAPE_COLOR;
	}
	
	@Override
	protected void createTools(JToolBar palette) {
		super.createTools(palette);
		Tool triangleTool = new CreationTool(this, new Triangle(this));
		Tool ellipseTool = new CreationTool(this, new Ellipse(this));
		Tool lineTool = new CreationTool(this, new LineFigure());
		
		palette.add(createToolButton(IMAGES + "TRIANGLE", "Triangle Tool", triangleTool));
		palette.add(createToolButton(IMAGES + "ELLIPSE", "Ellipse Tool", ellipseTool));
		palette.add(createToolButton(IMAGES + "LINE", "Line Tool", lineTool));
			
	}
	/*Stop that annoying tool done message*/
	@Override
	public void toolDone() {
		
	}
	
	public static void main(String[] args) {
		DrawApplication window = new MathNoteEditorGUI();
		window.setBackground(Color.black);
		window.open();
		window.resize(1200, 800);
		System.out.println(window.getBackground());
	}
}
