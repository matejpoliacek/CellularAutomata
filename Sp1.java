import java.util.Random;

public class Sp1 extends Species {

	final int MAXLIFE = 10;
	final double FIT = 0.8;
	final static String DISP = "1";
	
	/**
	 * Constructor for species 1
	 * @param row row position of this instance of a creature of species 1
	 * @param col columns position of this instance of a creature of species 1
	 * @param g grid world in which this creature lives
	 */
	Sp1(int row, int col, Grid g) {
		super(row, col, g);
		super.disp = this.DISP;
		Random rand = new Random();
		super.life = rand.nextInt(MAXLIFE+1);	
		super.fitness = this.FIT;
	}
	
}
