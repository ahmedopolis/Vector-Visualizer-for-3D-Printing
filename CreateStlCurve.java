import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Application to create a text STL file for a Cone curve
 * 
 * @author Ahmed Ibrahim
 * @version 1.0
 */
public class CreateStlCurve {
	private List<List<Point3D>> list;

	/**
	 * Create a matrix of points
	 */
	public void createMatrix() {
		// TODO in lab 4, based on createList in PointList
	}

	/**
	 * Create Solid based on values in matrix
	 * 
	 * @param name Name of the solid
	 * @return Generated solid
	 */
	public Solid createSolid(String name) {
		Solid solid = new Solid(name);

		int height = list.size() - 1;
		int width = list.get(0).size() - 1;

		// Create curve
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				// as viewed from above
				solid.addFacet(list.get(h).get(w), // bottom left
						list.get(h).get(w + 1), // bottom right
						list.get(h + 1).get(w + 1), // top right
						list.get(h + 1).get(w)); // top left
			}
		}

		// Create bottom edge
		// TODO in lab 5

		// Create top edge
		// TODO in lab 5

		// Create left edge
		// TODO in lab 5

		// Create right edge
		// TODO in lab 5

		// Create base
		// TODO in lab 5

		return solid;
	}

	/**
	 * Print the points to the console
	 */
	public void printMatrix() {
		for (List<Point3D> row : list) {
			for (Point3D value : row)
				System.out.print("(" + value + ") ");
			System.out.println();
		}
	}

	/**
	 * Application main
	 * 
	 * @param arg Commandline argument (not used)
	 */
	public static void main(String[] arg) {
		CreateStlCurve curve = new CreateStlCurve();
		curve.createMatrix();
		Solid solid = curve.createSolid("ConeCurve");

		String name = "c:\\temp\\ConeCurve.stl";
		Path path = Paths.get(name);

		try {
			solid.toTextFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
