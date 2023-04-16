import acm.graphics.*;
import acm.program.GraphicsProgram;

public class MySecondProgram extends GraphicsProgram{
	public void run() {
		//seken top ile ayni mantik sadece top yerine foto koyduk
		double ekranGenislik = getWidth();
		double ekranYukseklik = getHeight();

		GImage resim = new GImage("burak.jpg");
		resim.scale(0.35);
		add(resim, 0, 0);
		double delta_x = 1;
		double delta_y = 1;
		double resimGenislik = resim.getWidth();
		double resimYukseklik = resim.getHeight();

		while(true) {
			resim.move(delta_x,delta_y);
			pause(10);
			
			if(resim.getY()+ resimYukseklik >= ekranYukseklik || resim.getY() <= 0) {
				delta_y = -delta_y ;
			}
			if(resim.getX()+ resimGenislik >= ekranGenislik || resim.getX() <=0) {
				delta_x =-delta_x;
			}
		}
	}
}