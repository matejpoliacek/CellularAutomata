
import java.util.ArrayList;
import java.util.Arrays;
	/**
	 * Create grid of the world
	 * @author 1103577p
	 *
	 */
public abstract class Grid {
	
	protected final int NEIGHBOURS2D = 9, COORDS2D = 2;
	protected int worldRows, worldCols;
	protected Species[][] creatureGrid; 
	
	/**
	 * Constructor for Grid
	 * @param rows number of rows of the grid
	 * @param cols number of columns of the grid
	 */
	Grid(int rows, int cols) {
		this.worldRows = rows;
		this.worldCols = cols;
		creatureGrid = new Species[rows][cols];		
	}
	
	public int getRows() {
		return worldRows;
	}
	
	public int getCols() {
		return worldCols;
	}
	
	public Species[][] getCGrid() {
		return creatureGrid;
	}
	
	/**
	 * Get Species at a specific position
	 * 
	 * @param pos position of the species to retrieve
	 * @return
	 */
	
	public Species getSpecies(int[] pos) {
		//return null if position is empty
		if (creatureGrid[pos[0]][pos[1]] == null) {
			return null;
		} 
		
		else {		
		Species resident = creatureGrid[pos[0]][pos[1]];		
		return resident;
		}
	}
	
	/**
	 * Setup string to print in the console
	 */
	public void printGrid() {
		String prepGrid = "";
		String showLabel = "";
		
		for (int i = 0; i < worldRows; i++) {
			for (int j = 0; j < worldCols; j++){
				
				if (creatureGrid[i][j] == null || creatureGrid[i][j].isAlive() == false) {
					showLabel = "-";
				} 
				
				else {
					showLabel = creatureGrid[i][j].getDisp();
				}
				
				prepGrid = prepGrid + showLabel;
				
				if (j != (worldCols-1)) {
					prepGrid = prepGrid + " ";
				}
				
				else {
					prepGrid = prepGrid + "\n";
				}
			}
		}
		
		System.out.println(prepGrid);
		
	}
	
	
	/**
	 * Set a particular position of the world to a given creature
	 * @param pos which position to place the creature
	 * @param spDisp label indicating which species to place
	 */
	public void setCreature(int pos[], String spDisp) {
				
		if (spDisp == Sp1.DISP) {
	
			creatureGrid[pos[0]][pos[1]] = new Sp1(pos[0], pos[1], this);
			creatureGrid[pos[0]][pos[1]].start();
		}
		
		else if (spDisp == Sp2.DISP){
			
			creatureGrid[pos[0]][pos[1]] = new Sp2(pos[0], pos[1], this);
			creatureGrid[pos[0]][pos[1]].start();
		}	
	}
	
	/**
	 *  Retrieve all possible positions surrounding a given position (including itself)
	 *  Out of bounds positions will also be returned.
	 * @param pos position for which to return its neighbours
	 * @return
	 */
	public int[][] getNeighbours(int[] pos) {
		
		int[][] neighbours = new int[NEIGHBOURS2D][COORDS2D];
		
		//get all surrounding rows and columns
		int[] rows = {pos[0]-1, pos[0], pos[0]+1};
		int[] cols = {pos[1]-1, pos[1], pos[1]+1};
		
		//combined iterator
		int k = 0; 		
		
		// create all combinations
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
								
				neighbours[k][0] = rows[i];
				neighbours[k][1] = cols[j];
				k++;
				
			}
		}
				
		return neighbours;
	}
	
	/**
	 * Abstract method to allow subclasses sanitize neighbouring positions based on their nature
	 * @param neighbours array of all possible surrounding cells, unvalidated
	 * @return
	 */
	public abstract int[][] validateNeighbours(int[][] neighbours);
	
}
