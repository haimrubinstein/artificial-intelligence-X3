import java.util.ArrayList;
import java.util.Iterator;

public class Cluster {


	private int clusNum;

	public Cluster(int num) {
		this.clusNum = num;
	}

	public int getClusterNum() {
		return this.clusNum;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	private ArrayList<Point> points;


	public void addPoint(Point p) {
		this.points.add(p);
	}

	public boolean containPont(Point p) {
		return this.points.contains(p);
	}

	public int length() {
		return this.points.size();
	}

	public Iterator<Point> getIterator() {
		return this.points.iterator();
	}
}
