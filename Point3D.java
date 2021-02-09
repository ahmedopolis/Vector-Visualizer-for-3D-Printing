
public class Point3D {

	// Instance Variables consisting of the axis for the vertex.
	private double x;
	private double y;
	private double z;

	// Sole Constructor to store the coordinates into an object representing the
	// vertex.
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * 'calcNormal' is a static method to calculate the normal unit vertex. Its
	 * parameters consist of three objects of type 'Point3D', which the coordinates
	 * of these three vertex are use to compute the desired normal coordinates. This
	 * method returns a vertex being an object of type Point3D. The resources used
	 * for this computation are the following: -> Resource 1:
	 * https://en.wikipedia.org/wiki/Normal_(geometry) -> Resource 2:
	 * https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:vectors/x9e81a4f98389efdf:unit-vec/v/unit-vector-intro
	 */

	public static Point3D calcNormal(Point3D v1, Point3D v2, Point3D v3) {
		/**
		 * Local variables are created to store the axis-values of each vertex for
		 * readability.
		 */
		double x1 = v1.x;
		double y1 = v1.y;
		double z1 = v1.z;

		double x2 = v2.x;
		double y2 = v2.y;
		double z2 = v2.z;

		double x3 = v3.x;
		double y3 = v3.y;
		double z3 = v3.z;

		/**
		 * The sum of the Normal axis-values must be zero. The following local
		 * variables: xN, yN, zN are for non-normalized values (Resource 1). The sum of
		 * the non-normalized coordinates to the power of 2 is stored in the local
		 * variable 'sum', which the square of 'sum' is stored in 'alpha' being the
		 * magnitude of the normal vector. Using this "alpha" coefficient, the
		 * normalized coordinates are computed and stored in Ax, Ay and Az.
		 */
		double xN = (y2 - y1) * (z3 - z1) - (y3 - y1) * (z2 - z1);
		double yN = (z2 - z1) * (x3 - x1) - (z3 - z1) * (x2 - x1);
		double zN = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);

		double sum = Math.pow(xN, 2) + Math.pow(yN, 2) + Math.pow(zN, 2);
		double alpha = Math.pow(sum, 0.5);

		double Ax = xN / alpha;
		double Ay = yN / alpha;
		double Az = zN / alpha;

		// New object of Point3D to return the normal values.
		Point3D Normal = new Point3D(Ax, Ay, Az);

		return Normal;
	}

	/**
	 * 'toString' Method to print the coordinates of a vertex used by the
	 * 'PointArray' class.
	 */
	public String toString() {
		return " " + x + " " + y + " " + z;
	}

}
