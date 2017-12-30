import java.util.ArrayList;
import java.util.Iterator;

public abstract class ClusterManager {


	private ArrayList<ArrayList<Cluster>> clusters;
	protected ArrayList<Point> points;
	protected double[][] distanceMatrix;
	private int numOfSamplePoints;
	private int numOfClustersWanted;
	private int currIteration;

	/**
	 * the constructor
	 */
	public ClusterManager(int numWanted, ArrayList<Point> points) {
		this.numOfClustersWanted = numWanted;
		this.numOfSamplePoints = points.size();
		this.points = points;
		this.distanceMatrix = new double[points.size()][points.size()];
		this.currIteration = 0;
		this.clusters = new ArrayList<ArrayList<Cluster>>();
		this.initialFirstClusters();
		this.initialDistMatrix();
	}

	/**
	 * initial the matrix of distances
	 * for later use in calculations
	 */
	protected void initialDistMatrix() {
		for (int i = 0; i < this.points.size(); i++) {
			for (int j = 0; j < this.points.size(); j++) {
				double distIJ = Math.sqrt(points.get(i).getX() * points.get(j).getX()
						+ points.get(i).getY() * points.get(j).getY());
				distanceMatrix[i][j] = distIJ;
			}
		}
	}

	/**
	 * init the first list of clusters
	 * put every point in it's own cluster
	 */
	protected void initialFirstClusters() {
		ArrayList<Cluster> arr = new ArrayList<Cluster>();
		int i = 0;
		for (Point point : this.points) {
			Cluster clus = new Cluster(i);
			clus.addPoint(point);
			arr.add(i, clus);
			i++;
		}

		this.clusters.add(arr);
	}


	/**
	 * check if we are left with one big cluster -
	 * if we do then we finished.
	 */
	protected boolean checkFinishCalc() {
		ArrayList<Cluster> c = this.clusters.get(currIteration);
		return c.size() == 1;
	}

	/**
	 * the main function - runs and build the clusters
	 * until we are left with one big cluster
	 */
	protected void calculateClusters() {

		while (!this.checkFinishCalc()) {
			this.currIteration++;
			double closestDist = Double.MAX_VALUE;
			int clusterToMergeA = -1;
			int clusterToMergeB = -1;

			//get cluster one by one
			ArrayList<Cluster> clustersArr = this.clusters.get(currIteration--);
			//calc the 2 closest clusters
			for (int i = 0; i < clustersArr.size(); i++) {
				for (int j = 0; j < clustersArr.size(); j++) {
					double dist = calcDistOfTowHierarchies(clustersArr.get(i), clustersArr.get(j));
					if (dist < closestDist) {
						closestDist = dist;
						clusterToMergeA = i;
						clusterToMergeB = j;
					}
				}
			}
			//combine them to one
			Cluster clus = this.mergeClusters(clustersArr.get(clusterToMergeA), clustersArr.get(clusterToMergeB));
			//create new cluster list
			ArrayList<Cluster> newClustrArr = new ArrayList<Cluster>();
			// remove them from curr and enter the new one
			int index = 0;
			for (int i = 0; i < clustersArr.size(); i++) {
				if ((i != clusterToMergeA) && (i != clusterToMergeB)) {
					newClustrArr.add(clustersArr.get(i));
					index++;
				}
			}
			newClustrArr.add(clus);
			this.clusters.add(newClustrArr);
		}
	}

	/**
	 * get the wanted nu,ber of clusters
	 * as it came out from some iteration.
	 */
	public ArrayList<Cluster> getIterationLevel() {
		for (ArrayList<Cluster> arr : this.clusters) {
			if (arr.size() == this.numOfClustersWanted) {
				return arr;
			}
		}
		return null;
	}

	/**
	 * merge tow clusters into one big cluster
	 */
	protected Cluster mergeClusters(Cluster A, Cluster B) {
		Cluster c = new Cluster();
		Iterator<Point> iter = A.getIterator();
		while (iter.hasNext()) {
			c.addPoint(iter.next());
		}
		iter = B.getIterator();
		while (iter.hasNext()) {
			c.addPoint(iter.next());
		}
		return c;
	}

	/**
	 * the abstract method to calculate the distance between 2 clusters
	 * every metric will implement it by it's own standards .
	 * this it the template design pattern.
	 */
	protected abstract double calcDistOfTowHierarchies(Cluster A, Cluster B);

	/**
	 * getters and setters
	 */
	public ArrayList<ArrayList<Cluster>> getClusters() {
		return this.clusters;
	}

	public int getNumOfClustersWanted() {
		return this.numOfClustersWanted;
	}

	public void setNumOfClustersWanted(int size) {
		this.numOfClustersWanted = size;
	}

}
