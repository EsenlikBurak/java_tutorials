import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class SekenTop extends GraphicsProgram {

	public void run() {

		GOval top = new GOval(10, 10, CAP, CAP);
		top.setFilled(true);
		top.setFillColor(Color.red);
		add(top);
		//buraya kadar sadece topu olusturma
		double dx = 10;
		double dy = 20;
		//hareket kabiliyeti nasil olmali onu gorduk sira dongude
		while(true) {
			if(top.getY() + CAP >= getHeight() || top.getY() <= 0) {
				dy= -dy;
			}
			if (top.getX() + CAP >= getWidth() || top.getX() <= 0) {
				dx= -dx;
			}
			top.move(dx, dy);
			pause(BEKLEME_SURESI);
		}
	}


	/* Private constants */
	private static final int BEKLEME_SURESI = 50;
	private static final double CAP = 50;

}
