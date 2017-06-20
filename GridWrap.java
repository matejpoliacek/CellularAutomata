import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GridWrap extends Grid {
	
	GridWrap(int worldRows, int worldCols) {
		super(worldRows, worldCols);
	}
	
	/**
	 * A method to validate neighbouring positions for wrapping grid world.
	 * This method ensures any out-of-bounds positions are replaced with 
	 * positions on the corresponding opposite side of the grid.
	 *
	 * @param neighbours all possible neighbours of the given position
	 */
	public int[][] validateNeighbours(int[][] neighbours) {
		
		int[][] validN = new int[this.NEIGHBOURS2D][this.COORDS2D];
		int [] pair = new int[super.COORDS2D];
		
		for (int i = 0; i < neighbours.length; i++) {
				
				//if any neighbour is out of bounds in terms of rows
				//wrap the position around
				if (neighbours[i][0] < 0) {
					pair[0] = super.worldRows-1;
				}
				
				else if (neighbours[i][0] > super.worldRows-1) {
					pair[0] = 0;
				} 
				
				else {
					pair[0] = neighbours[i][0];
				}
				
				//now treat the columns the same way
				if (neighbours[i][1] < 0) {
					pair[1] = super.worldCols-1;
				}
				
				else if (neighbours[i][1] > super.worldCols-1) {
					pair[1] = 0;
				} 
				
				else {
					pair[1] = neighbours[i][1];
				}
				// save modified values
				validN[i][0] = pair[0];
				validN[i][1] = pair[1];
			}
			
		return validN;
	}
}
