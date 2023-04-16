import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class MyFirstProgram extends GraphicsProgram {
	public void run() {
	double ekranGenislik = getWidth();
	double ekranYukseklik = getHeight();
	GRect kutum = new GRect(ekranGenislik, ekranYukseklik);
	add(kutum, 0,0);
	kutum.setFilled(true);
	kutum.setFillColor(Color.yellow);
	while(true) {
		kutum.setSize(getWidth(), getHeight());
	}
	}
}
