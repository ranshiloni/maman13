/**
 * Represents 2 dimensional points.
 *
 * @author Ran Shiloni  
 * @version 301892212
 */

public class Point
{
    private double _radius;
    private double _alpha;

    final double MIN_X = 0;
    final double MIN_Y = 0;
    final double STRAIGHT_ANGLE = 90.0;
    final double HALF_CIRCLE = 180.0;

    //Constructors

    /**
     * Constructor for objects of class Point. Construct a new point with the specified x y coordinates. If the x coordinate is negative it is set to zero. If the y coordinate is negative it is set to zero.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(double x, double y)
    {
        double _x; 
        //assigning x=0 if it's a negative number
        if (x<MIN_X) 
        {
            _x = MIN_X;
        } 
        else 
        {
            _x = x;
        }
        // assigning y=0 if it's a negative number 
        if (y<MIN_Y) 
        {
            _radius = _radius = cartesianToRadius(_x,0);
            _alpha = cartesianToAlpha(_x,0);
        }
        else
        {
            _radius = cartesianToRadius(_x,y);
            _alpha = cartesianToAlpha(_x,y);
        }
    }

    /**
     * Constructor for objects of class Point. Copy constructor, construct a point using another point.
     * @param other The point to check the distance from
     * @return The distance
     */
    public Point (Point other) 
    {
        _radius = other._radius;
        _alpha = other._alpha;
    }

    //Private methods 
    private double cartesianToRadius(double x, double y) // Calculates a (x,y) point to it's radius equivalend in the Polar system
    {
        return ((Math.sqrt((Math.pow(x,2)+(Math.pow(y,2)))))); // Pitagoras
    }

    private double cartesianToAlpha(double x, double y) // Calculates an (x,y) point to it's Alpha equivalend in the Polar system
    {
        if (x == 0) 
        {
            return STRAIGHT_ANGLE;
        }
        double radians = ((Math.atan((y/x))));
        return (radiansToDegrees(radians)); 
    }

    private double radiansToDegrees(double radians) // returns the conversion of radians to degress
    {
        return ((radians*HALF_CIRCLE)/Math.PI);
    }

    private double degreesToRadians(double a) // returns the conversion of degress to radians
    {
        return (a*(Math.PI/HALF_CIRCLE));
    }

    private double polarToCartesianX() // retrieves the X coordinate based on the the polar system
    {
        return ((Math.round(((_radius * Math.cos(degreesToRadians(_alpha)))*10000)))/(double)10000);
    }

    private double polarToCartesianY() // retrieves the Y coordinate based on the the polar system
    {
        return ((Math.round(((_radius * Math.sin(degreesToRadians(_alpha)))*10000)))/(double)10000);
    }

    // Setters and Getters
    /**
     * This method returns the x coordinate of the point.
     * @param x The x coordinate of the point
     */
    public double getX()
    {
        return polarToCartesianX();
    }

    /**
     * This method returns the y coordinate of the point.
     * @param y The y coordinate of the point
     */
    public double getY()
    {
        return polarToCartesianY();
    }

    /**
     * This method sets the x coordinate of the point. If the new x coordinate is negative the old x coordinate will remain unchanged.
     * @param x The new x coordinate
     */
    public void setX (double num) 
    {
        if (num >= 0)
        {
            double _y = getY();
            _radius = cartesianToRadius(num, _y);
            _alpha = cartesianToAlpha(num, _y) ;
        }
    }

    /**
     * This method sets the y coordinate of the point. If the new y coordinate is negative the old y coordinate will remain unchanged.
     * @param y The new y coordinate
     */
    public void setY (double num) 
    {
        if (num >= 0)
        {
            double _x = getX();
            _radius = cartesianToRadius(_x,num);
            _alpha = cartesianToAlpha(_x, num);
        }
    }

    // Main Public Methods 
    /**
     * Returns a string representation of Point in the format (x,y).
     * @return A String representation of the Point
     */
    public String toString()
    {
        return "(" + getX() + "," + getY() + ")";
    }

    /**
     * Check if the given point is equal to this point.
     * @param other The point to check equality with
     * @return True if the given point is equal to this point
     */
    public boolean equals (Point other)
    {
        return (_radius == other._radius && _alpha == other._alpha);
    }

    /**
     * Check if this point is above a received point.
     * @param other The point to check if this point is above
     * @return True if this point is above the other point
     */
    public boolean isAbove (Point other)
    {
        return (getY() > other.getY());
    }

    /**
     * Check if this point is below a received point.
     * @param other The point to check if this point is below
     * @return True if this point is below the other point
     */
    public boolean isUnder (Point other)
    {
        return other.isAbove(this); //flipping parameters and the question
    }

    /**
     * Check if this point is left of a received point.
     * @param The point to check if this point is left of
     * @return True if this point is left of the other point
     */
    public boolean isLeft (Point other)
    {
        return (getX() < (other.getX()));
    }

    /**
     * Check if this point is right of a received point.
     * @param other The point to check if this point is right of
     * @return True if this point is right of the other point
     */
    public boolean isRight (Point other)
    {
        return other.isLeft(this); //flipping parameters and the question
    }

    /**
     * Check the distance between this point and a given point.
     * @param other The point to check the distance from
     * @return The distance
     */
    public double distance (Point p)
    {
        return (Math.sqrt((Math.pow((getX()-p.getX()),2)) + (Math.pow((getY()-p.getY()),2)))); //formula for length between two poin
    }

    /**
     * Moves a point. If either coordinate becomes negative the point remains unchanged.
     * @param dx The difference to add to x
     * @param dy The difference to add to y
     */
    public void move(double dx, double dy)
    {
        double newX = getX() + dx;
        double newY = getY() + dy;

        if (newX >= 0 && newY >= 0 ) //if the moved dots are on the first quarter
        {
            setX(newX); 
            setY(newY);
        }
    }

}

