import java.util.ArrayList;
import java.util.Iterator;

/**
 * a class that represent a cluster of points
 */
public class Cluster {

	private int clusNum;
	private ArrayList<Point> points;

	/**
	 * getters and setters
	 */
	public Cluster(int num) {
		this.clusNum = num;
		this.points = new ArrayList<>();
	}

	public int getClusterNum() {
		return this.clusNum;
	}

	public void setPoints(ArrayList<Point> p) {
		this.points = p;
	}

	public void setClusterNum(int n) {
		this.clusNum = n;
	}

	public Cluster clone() {
		Cluster c = new Cluster(this.clusNum);
		c.setPoints(this.points);
		return  c;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void addPoint(Point p) {
		this.points.add(p);
	}

	public Iterator<Point> getIterator() {
		return this.points.iterator();
	}
}
