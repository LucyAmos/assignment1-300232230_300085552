
// This file is a modification of the design1/PointCP 
// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 * 
 * Design 3: Store Cartesian coordinates only 
 * Polar coordinates are computed on demand, but not stored	
 * Cartesian coordianates are simply returned
 *
 * @author Lucy Amos
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */
public class PointCP3 {
//Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private char typeCoord;
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double x;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   * Store
   */

  public PointCP3(char type, double x, double y)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    
    //Store polar coordinates
    if(type == 'C'){
        this.x = x;
        this.y = y;
    }

    //store type
    typeCoord = type;
  }

  //Instance methods **************************************************
 
 //Cartesian
  public double getX()
  {
    return x;
  }
  
  public double getY()
  { 
    return y;
  }
  
  public double getRho()
  { 
    return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }
  
  public double getTheta()
  {
    return Math.toDegrees(Math.atan2(y, x));
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToCartesian()
  {
    if(typeCoord != 'C')
    {
    	// Set x and y
    	/*
      x = getX();
      y = getY();*/

      typeCoord = 'C';  //Change coord type identifier
    }
  }
	
  /**
   * Converts C to P.
   */

 
  public void convertStorageToPolar()
  {
    if(typeCoord != 'P')
    {
      //Calculate Rho and Theta
      /*
    	x = getRho();
    	y = getTheta();*/
      
   
      typeCoord = 'P';	//Change coord type identifier
    }
  }


  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP3 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  @Override
  public String toString()
  {
	  return (typeCoord == 'P' 
		       ? "Polar Value as [" + getRho() + "," + getTheta() + "]"
		       : "Cartesian Stored as (" + getX() + "," + getY() + ")") + "\n";
  }
}
