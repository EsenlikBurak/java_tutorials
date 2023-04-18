
import acm.program.*;
import acm.graphics.*;

import java.awt.*;

public class YerdenZiplayanTop extends GraphicsProgram {
	/* The size of the top. */
	private static final double TOP_BOYUTU = 50;
	
	/* The amount of time to pause between frames (in msec)*/
	private static final double BEKLEME_SURESI = 20;
	
	/* The initial horizontal velocity of the top. */
	private static final double YATAY_HIZ = 1.0;
	
	/* Gravitational acceleration. */
	private static final double YERCEKIMI = 0.125;
	
	/* ELASTISITE. */
	private static final double ELASTISITE = 0.8;	
	
	public void run() {
		GOval top = topYap();
		add(top);
		topSektir(top);
	}
	
	/**
	 * Creates a top that can be bounced, placing it in the upper-left corner
	 * of the screen.
	 * 
	 * @return A top that can be bounced.
	 */
	private GOval topYap() {
		GOval top = new GOval(0, 0, TOP_BOYUTU, TOP_BOYUTU);
		top.setFilled(true);
		top.setColor(Color.BLUE);
		return top;
	}
	
	/**
	 * Simulates a bouncing top.
	 * 
	 * @param top The top to bounce.
	 */
	private void topSektir(GOval top) {
		/* Track the downward velocity (dy is short for "delta-y.") */
		double dy = 0;
		
		/* This loops forever. Maybe you should change it to stop when the
		 * top rolls off the right side of the screen!
		 */
		while (true) {
			/* Move the top by the current velocity. */
			top.move(YATAY_HIZ, dy);
			
			/* YERCEKIMI pulls downward, increasing downward acceleration. */
			dy += YERCEKIMI;
			
			/* If the top drops below the floor, we turn it around. There's
			 * a tricky case to watch out for - if the top is already in
			 * the floor, we don't turn it around. Check the slides for
			 * details!
			 */
			if (topAltaGecti(top) && dy >= 0) {
				dy *= -ELASTISITE;
			}
			
			pause(BEKLEME_SURESI);
		}
	}
	
	/**
	 * Determines whether the top has dropped below floor level.
	 * 
	 * @param top The top to test.
	 * @return Whether it's fallen below the floor.
	 */
	private boolean topAltaGecti(GOval top) {
		return top.getY() + top.getHeight() >= getHeight();
	}
}