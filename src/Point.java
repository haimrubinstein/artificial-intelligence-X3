public class Point {


	private double x;
	private double y;
	private int cluster;
	private int creation;

	/**
	 * the constructor
	 */
	public Point(double x, double y, int create) {
		this.x = x;
		this.y = y;
		this.creation = create;
	}

	/**
	 * getters
	 */
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getCreation() { return this.creation; }

	public void setCluster(int cluster) { this.cluster = cluster; }

	public int getCluster() { return cluster; }

	@Override
	public boolean equals(Object obj) {
		return ((((Point) obj).getX() == this.getX()) && (((Point) obj).getY() == this.getY()));
	}
}
