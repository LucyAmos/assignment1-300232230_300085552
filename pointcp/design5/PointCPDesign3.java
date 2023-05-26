public class PointCPDesign3 extends PointCP5 {
	
	
	public PointCPDesign3(char type, double x, double y)
	  {
		super(type, x, y);
	    
	    //Store cartesian coordinates
	    if(type == 'C'){
	        this.x = x;
	        this.y = y;
	    }

	    //store type
	    typeCoord = type;
	  }
	
	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getRho() {
		return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
	}

	@Override
	public double getTheta() {
		return Math.toDegrees(Math.atan2(y, x));
	}

	@Override
	public void convertStorageToCartesian() {
		if(typeCoord != 'C')
	    {
	    	// Set x and y
	    	
	      x = getX();
	      y = getY();

	      typeCoord = 'C';  //Change coord type identifier
	    }
	}

	@Override
	public void convertStorageToPolar() {
		if(typeCoord != 'P')
	    {
	      //Calculate Rho and Theta
	      
	    	x = getRho();
	    	y = getTheta();
	    	
	    	typeCoord = 'P';	//Change coord type identifier
	    }
	}

	@Override
	public double getDistance(PointCP5 point) {
		double deltaX = getX() - point.getX();
	    double deltaY = getY() - point.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	@Override
	public PointCP5 rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCPDesign3('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

	@Override
	public String toString() {
		return "Calculated Value " + (typeCoord == 'P' 
			       ? "Polar  [" + getRho() + "," + getTheta() + "]"
			       : "Cartesian Stored as (" + getX() + "," + getY() + ")") + "\n";
	}

}
