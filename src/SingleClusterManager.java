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
				if (!ApointList.get(i).equals(BppointList.get(j))) {
					Point p1 = ApointList.get(i);
					Point p2 = BppointList.get(j);
					double temp = super.distanceMatrix[p1.getCreation()][p2.getCreation()];
					if (temp < dist) {
						dist = temp;
					}
				}
			}
		}

		return dist;
	}
}
