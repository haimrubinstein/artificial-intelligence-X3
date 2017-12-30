import java.util.ArrayList;

public class SingleClusterManager extends ClusterManager {


	public SingleClusterManager(int wanted, ArrayList<Point> points) {
		super(wanted, points);
	}


	/**
	 * calculate the distance between 2 clusters
	 * according to single linkage metric
	 */
	@Override
	protected double calcDistOfTowHierarchies(Cluster A, Cluster B) {

		ArrayList<Point> ApointList = A.getPoints();
		ArrayList<Point> BppointList = B.getPoints();
		double dist = Double.MAX_VALUE;
		for (int i = 0; i < ApointList.size(); i++) {
			for (int j = 0; j < BppointList.size(); j++) {
				double temp = super.distanceMatrix[i][j];
				if (temp < dist) {
					dist = temp;
				}
			}
		}

		return dist;
	}
}
