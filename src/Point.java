public class Point {


	private int x;
	private int y;
	private int cluster;
	private int creation;

	/**
	 * the constructor
	 */
	public Point(int x, int y, int create) {
		this.x = x;
		this.y = y;
		this.creation = create;
	}

	/**
	 * getters
	 */
	public int getX() {
		return x;
	}

	public int getY() {
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
