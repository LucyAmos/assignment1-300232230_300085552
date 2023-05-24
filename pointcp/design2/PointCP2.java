
//Question FOR TA?

/**
 * convertSTorgae to cartesian also just simply returned or the intrsutcion dont apply?
 * 
 */

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
 * Design 2: Store polar coordinates only 
 * Cartesian coordinates are computed on demand, but not stored 
 * Polar coordianates are simply returned
 *
 * @author Lucy 
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */
public class PointCP2 {
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
  //private double xOrRho;
  private double Rho;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  //private double yOrTheta;
  private double Theta;
  
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   * Store
   */

  public PointCP2(char type, double Rho, double Theta)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    
    //Store polar coordinates
    if(type == 'P'){
        this.Rho = Rho;
        this.Theta = Theta;
    }

    //store type
    typeCoord = type;
  }

  //Instance methods **************************************************
 
 //Cartesian
  public double getX()
  {
    //if(typeCoord == 'C') 
      //return xOrRho;
    //else 
    return (Math.cos(Math.toRadians(Theta)) * Rho);
  }
  
  public double getY()
  {
    //if(typeCoord == 'C') 
      //return yOrTheta;
    //else 
    return (Math.sin(Math.toRadians(Theta)) * Rho);
  }
  
  public double getRho()
  {
    //if(typeCoord == 'P') 
    return Rho;
    //else 
    //  return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
  }
  
  public double getTheta()
  {
    //if(typeCoord == 'P')
    return Theta;
    //else 
    //  return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
  }
  
  
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    if(typeCoord != 'P')
    {
      //Calculate RHO and THETA

      /*
      double temp = getRho();
      Theta = getTheta();
      Rho = temp;
      */
    
      Rho = getRho();
      Theta = getTheta();

      typeCoord = 'P';  //Change coord type identifier
    }
  }
  
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */

 
  public void convertStorageToCartesian()
  {
    if(typeCoord != 'C')
    {
      //Calculate X and Y
      double temp = getX();
      Theta = getY();
      Rho = temp;
   
      typeCoord = 'C';  //Change coord type identifier
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
  public double getDistance(PointCP2 pointB)
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
  public PointCP2 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP2('C',
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
    return "Calculated Value " + (typeCoord == 'C' 
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar Stored as [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}