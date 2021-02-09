/**
 * The 'IOException' package from 'io' are required to throw the 
 * required exceptions. As well as, the 'file.Path' packet from 'nio'
 * is need for the file/io component of the programming. The 'ArrayList' package is required to utilize array lists.
 * Also, the 'Arrays' package is required for the 'toString' method.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Solid {

	/**
	 * Instance variables to store the name of the solid ('name') and
	 * to store the facet objects in a list.
	 */
	private String name;
	private ArrayList<Facet> facets;


	/**
	 * Default Constructor is set to have all this.parameters to
	 * null values or zero. A second constructor is made with a single
	 * parameter being 'name', where a string value can be stored in the
	 * this.name and this.facets is initialized without being sized. Thus, it
	 * is worth noting that these are overloaded constructors.
	 */
	public Solid() {
		this.name = null;
		this.facets = new ArrayList<Facet>(0);
	}

	public Solid(String name) {
		this.name = name;
		this.facets = new ArrayList<Facet>();
	}
	
	/**
	 * 'addFacet' is used to load objects of the Facet.java class, into the
	 * this.facets being a list. Using the if-statement, this boolean method will
	 * return false if 'objectFacet' has any null values.
	 */
	public boolean addFacet(Facet objectFacet) {
		if (objectFacet == null) {
			return false;
		} else {
			this.facets.add(objectFacet);
			return true;
		}
	}

	/**
	 * 'toString' method that calls the 'toString' methods of 'Facet.jaca' and 'Point3D.java'.
	 * The 'toString' method in the 'Arrays' package cannot be used directly via the dot approach
	 * to an object of type ArrayList. However, when it is rendered a parameter in 'Arrays.toString(...)',
	 * it can be used in the same manner. This was stored in a local variable 'stringList' for readability
	 * purposes.
	 */
	public String toString() {
		String stringList = Arrays.toString(this.facets.toArray());
		return "solid "+ name + stringList.replace("[", "").replace("]", "").replace(",", "") + "\nendsolid " + name;
	}
	
	/**
	 * The method 'Files.write()' has been used to store the resulting 
	 * string method output 'toString()' into a file. This is done
	 * utilizing the NIO API with write() which is not the most efficient
	 * as opposed to the 'newBufferedWriter()'. However, with the small size of the 
	 * file the simpler choice seemed valid. 
	 * Resource: https://examples.javacodegeeks.com/core-java/nio/file-nio/java-nio-write-file-example/
	 */
	public void toTextFile(Path path) throws IOException{
		Files.write(path, toString().getBytes());
	}
	
	/**
	 * 
	 */
	public boolean addFacet(Point3D... vertex) {
		if (vertex == null || vertex.length < 3) {
			return false;
		} else {
			ArrayList<Point3D> listOfVertex = new ArrayList<Point3D>();
			for (Point3D objectVertex : vertex) {
				listOfVertex.add(objectVertex);
			}
			for (int i = 0; i < listOfVertex.size() - 2; i++) {
				Facet objectFacet = new Facet(listOfVertex.get(0),listOfVertex.get(i+1),listOfVertex.get(i+2));
				this.facets.add(objectFacet);
			}
			return true;
		}

	}
}
