import java.awt.*;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class BallPicker extends GraphicsProgram{
	public void run() {
		addMouseListeners();
		boolean bitti = false;
		while(!bitti) {
			GOval top = new GOval(CAP, CAP);
			top.setFilled(true);
			top.setFillColor(Color.black);
			add(top, 0,getHeight()/2-CAP/2);
			animasyon();
			
			
		}
		bitti =true;
	}
	private void animasyon() {
		double delta_x = 1;
		while(true) {
			if(top.getX() < getWidth()) {
				top.move(delta_x,0);
				pause(30);
			}else {
				println("Final!!");
				break;
			}
		}
	}
	public void mouseClicked(MouseEvent fare) {
		GObject obje = getElementAt(fare.getX(),fare.getY());
		if(obje != null) {
			top.setLocation( 0,getHeight()/2-CAP/2);
		}
	}


	private final int CAP = 50;
	private GImage top = null;
}