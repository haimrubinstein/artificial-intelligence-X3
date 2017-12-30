import java.util.ArrayList;

public class SingleClusterManager extends ClusterManager {


	public SingleClusterManager(int wanted, ArrayList<Point> points) {
		super(wanted, points);
	}


	@Override
	protected double calcDistOfTowHierarchies(Cluster A, Cluster B) {

		return -1;
	}
}
