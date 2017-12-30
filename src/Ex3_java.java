import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Ex3_java {

	public static void main(String args[]) {

		//read the file
		Reader reader = new Reader();
		ClusterManager clusterManager = reader.read();
		//create the clusters
		clusterManager.calculateClusters();
		//get the clusters according to the wanted number of clusters wanted
		ArrayList<Cluster> arr = clusterManager.getIterationLevel();
		//get the point from each cluster to one list and sort the point for easy printing to file
		ArrayList<Point> points = new ArrayList<Point>();
		for (Cluster clus : arr) {
			for (Point p : clus.getPoints()) {
				p.setCluster(clus.getClusterNum());
				points.add(p);
			}
		}
		points.sort(new PointFinalSortComperator());

		//print the result to file
		Iterator<Point> iterator = points.iterator();
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
