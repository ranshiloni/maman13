
/**
 * Represent a Polygon 
 *
 * @author Ran Shiloni
 * @version 3018992212
 */
public class Polygon
{
    private Point[] _vertices;
    private int _noOfVertices;
    final int MAX_VERTICES = 10;
    
    // Constructor
    /**
     * Initialazation constructor building an array of Points that will make a Polygon
     */
    public Polygon ()
    {
        _vertices = new Point[MAX_VERTICES]; 
        _noOfVertices = 0;
    }
    
    /**
     * Adds a point to the Polygon, assuming the input is valid and in order. 
     * returns true if the operation is successful, false if the shape is already complete or input is invalid.
     */
    public boolean addVertex(double x, double y)
    {
        if (_noOfVertices < MAX_VERTICES)
        {
            _vertices[_noOfVertices] = new Point(x,y);
            _noOfVertices++; // Updating the counter
            return true;
        }
        return false;
    }
    
    /**
     * Finds the highest point in the polygon and returns it. If there's more than one, it returns the first in the series. 
     * @return 
     */
    public Point highestVertex()
    {
        while (
    }
    
    
    
    

}
