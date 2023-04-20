import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class BallPicker2 extends GraphicsProgram{
	GOval ball;
	int size = 100;
	public void run() {	
		ball = new GOval(size, size);
		ball.setFilled(true);
		add(ball, 0, (getHeight()-size)/2);
		int dx = 3;
		addMouseListeners();
		while(true) {
			ball.move(dx, 0);
			pause(15);
			if(ball.getX()+size >= getWidth()) {
				remove(ball);break;
			}
		}
		GLabel label = new GLabel("FIN");
		add(label, getWidth()/2, getHeight()/2);
	}
	public void mouseClicked(MouseEvent m) {
		GObject clicked = getElementAt(m.getX(),m.getY());
		if(clicked == ball) {
			ball.setLocation(0, (getHeight()-size)/2);
		}
	}
	public void mousePressed(MouseEvent m) {
		GObject clicked = getElementAt(m.getX(),m.getY());
		if(clicked == ball) {
			ball.setLocation(0, (getHeight()-size)/2);
		}
	}
}