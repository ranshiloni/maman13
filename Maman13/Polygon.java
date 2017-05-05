
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
     * @return True if the operation is successful, false if the shape is already complete or input is invalid.
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
     * Finds the highest point in the polygon. 
     * @return The highest Point in the polygon. Returns null if the array is empty.
     */
    public Point highestVertex()
    {
        if (_noOfVertices == 1) return new Point(_vertices[0]);
        int i;
        if (_noOfVertices > 1)
        {
            Point highest = new Point(_vertices[0]); 
            //highest getting the first point now that we know that the Polygon has more than one point
            for (i=1; i<_noOfVertices; i++)
            {

                if (_vertices[i].isAbove(_vertices[i-1]))
                {
                    highest = new Point(_vertices[i]);
                }
            }
            return highest;
        }
        return null;

    }

    /**
     * Return a string representation of this polygon in the format ((2.0,1.0),(5.0,0.0),(7.0,5.0),(4.0,6.0),(1.0,4.0)) for example.
     * @return String representation of this segment or that the array is empty.
     */
    public String toString()
    {
        if (_noOfVertices == 1) 
        {
            return "(" + _vertices[0] +")";
        }
        else if (_noOfVertices > 1)
        {
            int i;
            String output = "("; 
            for (i=0; i<_noOfVertices-1; i++) 
            //for all the array except the last point
            {
                output+= _vertices[i] + ",";
            }
            output+= _vertices[_noOfVertices-1] + ")"; //adding the last point with closing ( and without comma
            return output;
        }
        return "The polygon has 0 vertices.";
    }
    
    
    
    


    
}
