import java.util.ArrayList;
import java.util.*;

public class TestWorld { 
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Wrap world? [Y/n]:");		
		Scanner choose = new Scanner(System.in);
		
		Grid g = null;
		
		if (choose.next().equals("Y")) {
			//create wrapping world
			g = new GridWrap(15, 25);
		}
		
		else {
			//create bordered world
			g = new GridBordered(15, 25);
		}
				
		//initialise species
		Sp1 test = new Sp1(10,17, g);
		Sp2 test2 = new Sp2(0,5, g);
		
		// initialise grid
		g.setCreature(test.getPos(), test.getDisp());
		g.setCreature(test2.getPos(), test2.getDisp());
		
		
		// loop to print every 0.5 seconds
		while(true) {			
			g.printGrid();			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
