import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class Wilhelm extends GraphicsProgram{
	//Acilan pencerenin boyutlarini belirleyen satirlar
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 400;
	public void run(){
		adamiVeElmayiYarat();
		while(true){
			if(okAt()){
				GLabel bravoText;
				if(yuzuVurmaSayisi == 0)
					bravoText = new GLabel("Hey, bu cok iyiydi!", 50,50);
				else
					bravoText = new GLabel("Sonunda!!", 50,50);
				
				add(bravoText);
				bravoText.setFont(fontStyle);
				break;
			}
				
			waitForClick();
		}
	}
	private boolean okAt(){
		double startY = rgen.nextInt(160,230);
		GLine ok = new GLine(startX,startY,startX+OK_BOYUTU,startY);
		add(ok);
		double dx = 2;
		while(true){//ok animasyonu
			GPoint endPoint = ok.getEndPoint();
			if(endPoint.getX() > DUVAR_X)
				break;
			ok.setLocation(startX + dx, startY);
			dx += 2;
			pause(2);
		}

		if(startY > 200 && startY < 250){
			GLabel hurtText;
			if(yuzuVurmaSayisi == 0){
				hurtText = new GLabel("Ahhh !! :(", 50,50);
				yuzuVurmaSayisi++;
			}else{
				yuzuVurmaSayisi++;
				hurtText = new GLabel("Hey, bu " + yuzuVurmaSayisi + ". vurusun, dikkat et", 50, 50);
			}
			add(hurtText);
			hurtText.setFont(fontStyle);
			pause(1000);
			remove(hurtText);
		}
			
		return (startY < 200 && startY > 180);
	}

	private void adamiVeElmayiYarat(){
		GLine duvar = new GLine(DUVAR_X, DUVAR_Y1, DUVAR_X, DUVAR_Y2);
		add(duvar);

		GOval yuz = new GOval(900, 200, 40, 50);
		yuz.setFilled(true);
		yuz.setFillColor(Color.ORANGE);
		add(yuz);
		
		GOval kulak1 = new GOval(892, 210, 8, 20);
		kulak1.setFilled(true);
		kulak1.setFillColor(Color.ORANGE);
		add(kulak1);

		GOval kulak2 = new GOval(938, 210, 8, 20);
		kulak2.setFilled(true);
		kulak2.setFillColor(Color.ORANGE);
		add(kulak2);

		GOval elma = new GOval(910, 180, 20, 20);
		elma.setFilled(true);
		elma.setFillColor(Color.MAGENTA);
		add(elma);
		
		GLabel ilkAnons = new GLabel("Emin misin???....", 50, 50);
		ilkAnons.setFont(fontStyle);
		add(ilkAnons);
		
		GLabel bilgiMetni = new GLabel("Ok atmak icin fareye tiklayin", 600, 50);
		bilgiMetni.setFont("ARIAL-20");
		bilgiMetni.setColor(Color.RED);
		add(bilgiMetni);
		
		pause(1500);
		remove(ilkAnons);
	}
	
	private final int OK_BOYUTU = 50;
	private final int DUVAR_X = 935;
	private final int DUVAR_Y1 = 50;
	private final int DUVAR_Y2 = 400;
	private int yuzuVurmaSayisi = 0;
	private final double startX = 20.0;
	private String fontStyle = "arial-BOLD-30";
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
}
