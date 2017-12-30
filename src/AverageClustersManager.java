import java.util.ArrayList;

public class AverageClustersManager extends ClusterManager {



	public AverageClustersManager(int wanted, ArrayList<Point> points) {
		super(wanted,points);
	}

	/**
	 * calculate the distance between 2 clusters
	 * according to average linkage metric
	 */
	@Override
	protected double  calcDistOfTowHierarchies(Cluster A, Cluster B) {
		return -1;
	}
}
