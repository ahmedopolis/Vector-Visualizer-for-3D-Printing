public class ConeCurve {

	/**
	 * The following 'getters' are used to store the desired minimum, maximum and
	 * step size values necessary in the 'DoubleArray' and 'PointArray' classes. The
	 * 'getZ' method stores the parameters 'x' and 'y' to calculate the resulting
	 * absolute sum. These 'getters' are rendered static to facilitate their
	 * accessibility in the classes in the package by eliminating the need to create
	 * objects of 'ConeCurve' for the sake of using methods of 'ConeCurve'.
	 */
	public static double getMinX() {
		return -10.0;
	}

	public static double getMinY() {
		return -10.0;
	}

	public static double getMaxX() {
		return 10.0;
	}

	public static double getMaxY() {
		return 10.0;
	}

	public static double getStepSize() {
		return 1.0;
	}

	public static double getZ(double x, double y) {
		return Math.abs(x) + Math.abs(y);
	}

}
