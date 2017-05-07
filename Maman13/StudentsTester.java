/**
 * Students tester to Polygon class
 */
public class StudentsTester {
    public static void main(String[] args) {

        System.out.println("start");
        Polygon polygon = new Polygon();
        polygon.addVertex(2.0, 1.0);
        polygon.addVertex(5.0, 0.0);
        polygon.addVertex(7.0, 5.0);
        polygon.addVertex(4.0, 6.0);
        polygon.addVertex(1.0, 4.0);

        Point highest = polygon.highestVertex();
        System.out.println("\nTest highestVertex:\nhighest = "  +highest + " while it should be (4.0,6.0)" );
        
        Polygon polygon1 = new Polygon();
        polygon1.addVertex(4.0, 6.0);
        highest = polygon1.highestVertex();
        System.out.println("\nTest highestVertex:\nhighest = "  +highest + " while it should be (4.0,6.0)" );
        
        Polygon polygon2 = new Polygon();
        highest = polygon2.highestVertex();
        System.out.println("\nTest highestVertex:\nhighest = "  +highest + " while it should be null" );
        
        Polygon polygon3 = new Polygon();
        polygon3.addVertex(4.0, 6.0);
        polygon3.addVertex(4.0, 6.0);
        polygon3.addVertex(4.0, 1.0);
        highest = polygon3.highestVertex();
        System.out.println("\nTest highestVertex:\nhighest = "  +highest + " while it should be (4.0,6.0)" );
        
        System.out.println("\nTest toString() method:\n" + polygon);
        System.out.println("\nTest toString() methodP1:\n" + polygon1);
        System.out.println("\nTest toString() methodP2:\n" + polygon2);
        
        
        double perimeter = polygon.calcPerimeter();
        System.out.println("\nTest calcPerimeter:\nperimeter = "  + perimeter + " while it should be 18.47754906310363");
        
        perimeter = polygon1.calcPerimeter();
        System.out.println("\nTest calcPerimeter:\nperimeter = "  + perimeter + " while it should be 0");
        
        perimeter = polygon2.calcPerimeter();
        System.out.println("\nTest calcPerimeter:\nperimeter = "  + perimeter + " while it should be 0");
        
        Polygon po2d = new Polygon();
        po2d.addVertex(0,0);
        po2d.addVertex(5.0, 0.0);
        perimeter = po2d.calcPerimeter();
        System.out.println("\nTest calcPerimeter:\nperimeter = "  + perimeter + " while it should be 5");
        
        double area = polygon.calcArea();
        System.out.println("\nTest calcArea:\narea = "  + area  +" while it should be: 22.499999999999996");
        
        Polygon triangle = new Polygon();
        triangle.addVertex(0,0);
        triangle.addVertex(3,0);
        triangle.addVertex(3,3);
        area = triangle.calcArea();
        System.out.println("\nTest calcArea:\narea = "  + area  +" while it should be: 4.5");
        
        Polygon square = new Polygon();
        square.addVertex(0,0);
        square.addVertex(3,0);
        square.addVertex(3,3);
        square.addVertex(0,3);
        area = square.calcArea();
        System.out.println("\nTest calcArea:\narea = "  + area  +" while it should be: 9");
        
        Point point = new Point(4.0, 6.0);
        int index = polygon.findVertex(point);
        System.out.println("\nTest findVertex:\nindex = "  + index + " while actual result should be 3");
        
        point = new Point(1.0, 4.0);
        index = polygon.findVertex(point);
        System.out.println("\nTest findVertex:\nindex = "  + index + " while actual result should be 4");
        
        point = new Point(2.0, 1.0);
        index = polygon.findVertex(point);
        System.out.println("\nTest findVertex:\nindex = "  + index + " while actual result should be 0");
        
        point = new Point(0.0, 0.0);
        index = polygon.findVertex(point);
        System.out.println("\nTest findVertex:\nindex = "  + index + " while actual result should be -1");
        
        
        Polygon biggerPolygon = new Polygon();
        biggerPolygon.addVertex(2.0, 1.0);
        biggerPolygon.addVertex(5.0, 0.0);
        biggerPolygon.addVertex(7.0, 5.0);
        biggerPolygon.addVertex(4.0, 7.0);
        biggerPolygon.addVertex(1.0, 4.0);

        System.out.println ("\nTest isBigger:\nexpected result here is false and actual result is: " + polygon.isBigger(biggerPolygon));// should be false// Point actualNextVertex = new Point(1.0, 4.0);
        
        Point nextVertex = polygon.getNextVertex(point);
        System.out.println("\nTest getNextVertex:\nnext point after (4.0,6.0) is = " + nextVertex + " while it should be should be (1.0,4.0)");

        // Polygon boundingBox = polygon.getBoundingBox();
        // System.out.println("\nTest getBoundingBox:\nthe bounding box is:\n" + boundingBox + "\nwhile it should be:\nThe polygon has 4 vertices:\n((1.0,0.0),(7.0,0.0),(7.0,6.0),(1.0,6.0))");
        
        // System.out.println("\nNote that this is only a basic test. Make sure you test all cases!");
        // System.out.println("end");
  }
}
