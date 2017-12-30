import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Ex3_java {

	public static void main(String args[]) {

		Reader reader = new Reader();
		ClusterManager clusterManager = reader.read();
		clusterManager.calculateClusters();
		clusterManager.calculateClusters();
		ArrayList<Cluster> arr = clusterManager.getIterationLevel();
		ArrayList<Point> points = new ArrayList<Point>();
		for (Cluster clus : arr) {
			for (Point p : clus.getPoints()) {
				p.setCluster(clus.getClusterNum());
				points.add(p);
			}
		}

		points.sort(new PointFinalSortComperator());
		Iterator<Point> iterator = points.iterator();
		//print the result
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			while (iterator.hasNext()) {
				writer.println(iterator.next().getCluster());
			}
			writer.close();
		} catch (Exception e) {
			System.out.print("error");
		}
	}
}
