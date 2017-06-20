import java.util.ArrayList;

public class GridBordered extends Grid {
	
	GridBordered(int worldRows, int worldCols) {
		super(worldRows, worldCols);
	}
	
	/**
	 * A method to validate neighbouring positions for bordered grid world.
	 * This method ensures any out-of-bounds positions are removed.
	 *
	 * @param neighbours all possible neighbours of the given position
	 */
	public int[][] validateNeighbours(int[][] neighbours) {
		
		int[][] validNList = new int[super.NEIGHBOURS2D][super.COORDS2D];
		int counter = 0;
		
		for (int i = 0; i < neighbours.length; i++) {
			//only perform the following code if the entry *isn't* out of bounds
			if (!(neighbours[i][0] < 0 || neighbours[i][1] < 0 || neighbours[i][0] > super.worldRows-1 || neighbours[i][1] > super.worldCols-1)) {
				validNList[counter][0] = neighbours[i][0];
				validNList[counter][1] = neighbours[i][1];
				counter++;
			}
		}
		
		int[][] validN = new int[counter][2];
		//create a shorter array 

		for (int i = 0; i < validN.length; i++) {
			validN[i][0] = validNList[i][0];
			validN[i][1] = validNList[i][1];
		}
		
		return validN;
	}
	

}
