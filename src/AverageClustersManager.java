import java.util.ArrayList;

public class AverageClustersManager extends ClusterManager {



	public AverageClustersManager(int wanted, ArrayList<Point> points) {
		super(wanted,points);
	}

	@Override
	protected double  calcDistOfTowHierarchies(Cluster A, Cluster B) {

		return -1;
	}
}
