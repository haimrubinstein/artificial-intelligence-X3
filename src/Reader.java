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
	private ClusterManager getCluster(String type,ArrayList<Point> points) {
		switch (type) {
			case "average link":
				return new AverageClustersManager(-1, points);
			case "single link":
				return new SingleClusterManager(-1, points);
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
			int currCluster = 0;
			ArrayList<Point> points = new ArrayList<Point>();
			line = br.readLine();

			int creationTime = 0;
			while (line != null) {
				String arr[] = line.split(",");
				points.add(new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), creationTime));
				line = br.readLine();
				creationTime++;
			}

			clusterManager.setNumOfClustersWanted(size);

			clusterManager = this.getCluster(line,points);

		} catch (Exception e) {
			//todo handle error
		}
		return clusterManager;
	}
}
