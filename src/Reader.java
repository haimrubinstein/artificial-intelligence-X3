import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * reads the input file
 */
public class Reader {


	/**
	 * get the cluster class for current cluster type
	 */
	private ClusterManager getCluster(String type, ArrayList<Point> points, int numWanted) {
		switch (type) {
			case "average link":
				return new AverageClustersManager(numWanted, points);
			case "single link":
				return new SingleClusterManager(numWanted, points);
			default:
		}

		return null;
	}

	/**
	 * reads and returns the map we are working on
	 */
	public ClusterManager read() {
		ClusterManager clusterManager = null;

		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			StringBuilder sb = new StringBuilder();
			//get type
			String line = br.readLine();
			String type = line;
			//get size
			line = br.readLine();
			int size = Integer.parseInt(line);
			//start creating clusters
			ArrayList<Point> points = new ArrayList<>();
			line = br.readLine();
			int creationTime = 0;
			while (line != null) {
				String arr[] = line.split(",");
				points.add(new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), creationTime));
				line = br.readLine();
				creationTime++;
			}
			//create the management class
			clusterManager = this.getCluster(type, points, size);
			return  clusterManager;
		} catch (Exception e) {
			System.out.print(e);
			//todo handle error
		}

		return clusterManager;
	}
}
