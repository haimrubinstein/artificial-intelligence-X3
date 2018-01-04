import java.util.ArrayList;

public class AverageClustersManager extends ClusterManager {


	public AverageClustersManager(int wanted, ArrayList<Point> points) {
		super(wanted, points);
	}

	/**
	 * calculate the distance between 2 clusters
	 * according to average linkage metric
	 */
	@Override
	protected double calcDistOfTowHierarchies(Cluster A, Cluster B) {
		ArrayList<Point> ApointList = A.getPoints();
		ArrayList<Point> BppointList = B.getPoints();
		int numOfPoints = ApointList.size() * BppointList.size();
		double dist = 0;
		for (int i = 0; i < ApointList.size(); i++) {
			for (int j = 0; j < BppointList.size(); j++) {
				if(!ApointList.get(i).equals(BppointList.get(j))) {
					dist += super.distanceMatrix[ApointList.get(i).getCreation()][BppointList.get(j).getCreation()];
				}
			}
		}

		return dist / numOfPoints;
	}
}
