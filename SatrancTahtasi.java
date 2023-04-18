import acm.graphics.*;
import acm.program.GraphicsProgram;

public class SatrancTahtasi extends GraphicsProgram{
	public void run() {
		double kareBoyutu = (double) getHeight() / SATIR_SAYISI;
		for (int i = 0; i < SATIR_SAYISI; i++) {
			for (int j = 0; j < SUTUN_SAYISI; j++) {
				double x = j * kareBoyutu;
				double y = i * kareBoyutu;
				GRect sq = new GRect(x, y, kareBoyutu, kareBoyutu);
				sq.setFilled((i + j) % 2 != 0);
				add(sq);
			}
		}
	}
	private static final int SATIR_SAYISI = 8;
	private static final int SUTUN_SAYISI = 8;
}
