
public abstract class Species extends Thread {
	
	protected String disp;	// character to display in printed grid
	protected int life; // final lifespan value between 0 - max life
	protected double fitness;
	protected int[] pos;
	protected int[][] neighbours;
	protected Grid grid;

	
	/**
	 * Constructor for abstract species class
	 * @param row row position of this instance of a creature of either species
	 * @param col columns position of this instance of a creature of either species
	 * @param g grid world in which this creature lives
	 */
	Species(int row, int col, Grid g) {
		this.pos = new int[2]; 
		this.pos[0] = row;
		this.pos[1] = col;
		this.grid = g;
		this.neighbours = g.validateNeighbours(g.getNeighbours(this.pos)); 
	}
	
	public String getDisp(){
		return disp;
	}
	
	public int getLife(){
		return life;
	}
	
	public int[] getPos(){
		return pos;
	}
	
	public int[][] getSpNeighb() {
		return neighbours;
	}
	
	public double getFitness() {
		return fitness;
	}
	
	/**
	 * Method for running thread.
	 * First sleep, then attempt to reproduce.
	 * 
	 * Afterwards, set own position to null and kill thread.
	 * If interrupted (i.e. killed), set itself to null
	 */
	
	public void run() {

		try {
		//	System.out.println("sleep: " + (this.getLife()*1000));
			Thread.sleep(this.getLife()*1000);
			reproduce();
		}
		
		catch (InterruptedException e) {
			grid.setCreature(pos, null);
		}
		finally {
			grid.setCreature(pos, null);
			Thread.interrupted();
		}
	}
	
	/**
	 * Method for spreading species to neighbouring cells
	 * 
	 * Only spread to valid neighbouring positions - these are validated
	 * in constructor.
	 * 
	 * The method then checks what "lives" in each of the neighbouring position.
	 * Its fitness is then checked against a random number between 0-1
	 * (and the fitness of a competing creature, if applicable), 
	 * to emulate the probability of reproducing.
	 * 
	 * If it successfully reproduces on a position with an existing creature, 
	 * it will interrupt its thread.
	 * 
	 */
	
	public synchronized void reproduce() {
		
		for (int i = 0; i < neighbours.length; i++) {
			
			Species currSp = grid.getSpecies(neighbours[i]);
			
			if (currSp == null || currSp.isAlive() || currSp == this) {
				if ((this.getFitness() - Math.random()) > 0) {
			//		System.out.println("fit:" + (this.getFitness() - Math.random()) );
					grid.setCreature(neighbours[i], this.disp);
				}
			}
			
			else {
				if ((this.getFitness() - currSp.getFitness() - Math.random()) > 0) {
					currSp.interrupt();
					
					grid.setCreature(neighbours[i], this.disp);
				}
			}
		}
		
	}
}
