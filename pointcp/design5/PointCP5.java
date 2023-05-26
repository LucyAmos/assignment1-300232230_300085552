
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
 * Design 5: Uses design 2 or design 3 depending on concrete class.
 *
 * @author Lucy Amos
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */
public abstract class PointCP5 {
	protected char typeCoord;
	
	public PointCP5(char type)
	  {
	    if(type != 'C' && type != 'P')
	      throw new IllegalArgumentException();
	  	
		typeCoord = type;
	  	
	}
	
	public abstract double getX();
	public abstract double getY();
	public abstract double getRho();
	public abstract double getTheta();
	public abstract void convertStorageToCartesian();
	public abstract void convertStorageToPolar();
	public abstract double getDistance(PointCP5 point);
	public abstract PointCP5 rotatePoint(double rotation);
	
	@Override
	public abstract String toString();
}
	
 
