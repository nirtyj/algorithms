package epi.graph;

/**
 * in a matrix of boolean, takes a co-ordinate that is 1 and nukes all the ones connected to it
 * @author njaganat
 *
 */
public class PaintBooleanMatrix {

	public static void flipColor(int[][] matrix, Coordinate mark) {

		if (matrix[mark.x][mark.y] == 0)
			return;

		matrix[mark.x][mark.y] = 0;
		for (int[] direction : Coordinate.DIRECTIONS) {
			Coordinate newCoordinate = new Coordinate(mark.x + direction[0], mark.y + direction[1]);
			if (Coordinate.isValidCoordirnate(newCoordinate, matrix)) {
				flipColor(matrix, newCoordinate);
			}
		}
	}
}
