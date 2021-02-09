
public class Facet {

	/**
	 * Instance variables consisting of Point3D objects to store the vertex
	 * associated to a normal vector and the v1,v2,v3 are to store the vertex values
	 * for that particular facet.
	 */
	private Point3D normal;
	private Point3D v1;
	private Point3D v2;
	private Point3D v3;

	/**
	 * This is a default constructor, where the 'normal' private instance variable
	 * stores the output of the static method 'calcNormal', which uses 'this.v1',
	 * 'this.v2', 'this.v3'.
	 */
	public Facet(Point3D v1, Point3D v2, Point3D v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.normal = Point3D.calcNormal(this.v1, this.v2, this.v3);
	}

	/**
	 * 'toString' method formats the vertexes and that calls the 'toString' method
	 * of 'Point3D.java'.
	 */
	public String toString() {
		return "\nfacet normal" + normal + "\n outer loop" + "\n  vertex" + v1 + "\n  vertex" + v2 + "\n  vertex" + v3
				+ "\n endloop" + "\nendfacet";
	}

}
