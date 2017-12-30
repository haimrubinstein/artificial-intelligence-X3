import java.util.Comparator;

public class PointFinalSortComperator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		return o1.getCreation() - o2.getCreation();
	}
}
