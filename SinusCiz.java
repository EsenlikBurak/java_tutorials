
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
public class SinusCiz extends GraphicsProgram{

	public void run(){
		//50 piksel genliginde, ornekleme frekansi 10000Hz
		// ve and frekansi 100Hz bir sinus dalga sekli cizelim
		plotSine(50,100);

	}
	private void plotSine(double genlik, double frequency){
		//Cizimin basladigi noktanin koordinatlari
		int xStart = 1, yStart = 100;
		
		double dxPrev = 0, dyPrev = 0;//previous(prev)->�nceki
		for (int dx = 0; dx < APPLICATION_WIDTH; dx++){
			//zaman degiskeninin olusturulmasi
			double t = (double)dx / ORNEKLEME_FRK;
			
			double dy = genlik * Math.sin(2 * Math.PI * frequency * t);
			GLine cizgi=new GLine(xStart + dxPrev, yStart + dyPrev, xStart + dx, yStart + dy);
			add(cizgi);
			
			dxPrev = dx; dyPrev = dy;
		}
	}
	
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 200;
	public static final int ORNEKLEME_FRK = 10000;
}
