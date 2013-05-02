package mathNoteEditor.pack;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import org.jhotdraw.figures.ImageFigure;
import org.jhotdraw.util.Iconkit;

public class SymbolFigure extends ImageFigure {
	
	private transient Image fImage;
	private String   fFileName;
	private Rectangle fDisplayBox;
	
	public SymbolFigure(Image image, String fileName, Point origin) {
		fFileName = fileName;
		fImage = image;
		// fix for bug-id: 593080 (ImageFigure calculates the image rectangle wrongly)
		basicDisplayBox(origin, new Point(origin.x + fImage.getWidth(this), origin.y + fImage.getHeight(this)));
	}
	
	@Override
	public void draw(Graphics g) {
		if (fImage == null) {
			fImage = Iconkit.instance().getImage(fFileName);
		}
		if (fImage != null) {
			g.drawImage(fImage, fDisplayBox.x, fDisplayBox.y, 91, 56, this);
		}
	}

}
