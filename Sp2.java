import java.util.Random;

public class Sp2 extends Species {
	
	final int MAXLIFE = 5;
	final double FIT = 0.4;
	final static String DISP = "2";
	
	/**
	 * Constructor for species 2
	 * @param row row position of this instance of a creature of species 2
	 * @param col columns position of this instance of a creature of species 2
	 * @param g grid world in which this creature lives
	 */
	Sp2(int row, int col, Grid g) {
		super(row, col, g);
		super.disp = this.DISP;
		Random rand = new Random();
		super.life = rand.nextInt(MAXLIFE+1);
		super.fitness = this.FIT;
	}
}
