import java.util.Comparator;

public class PointFinalSortComperator implements Comparator<Point> {

	/**
	 * sort the points by order they were given in the input file
	 */
	@Override
	public int compare(Point o1, Point o2) {
		return o1.getCreation() - o2.getCreation();
	}
}
