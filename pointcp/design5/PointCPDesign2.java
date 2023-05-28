public class PointCPDesign2 extends PointCP5 {
	
	private double Rho;
	private double Theta;
	
	
	public PointCPDesign2(char type, double Rho, double Theta)
	  {
		super(type);
	    
	    //Store polar coordinates
	    if(type == 'P'){
	        this.Rho = Rho;
	        this.Theta = Theta;
	    }
	    
	    typeCoord = type;
	  }
	
	@Override
	public double getX() {
		return (Math.cos(Math.toRadians(Theta)) * Rho);
	}

	@Override
	public double getY() {
		return (Math.sin(Math.toRadians(Theta)) * Rho);
	}

	@Override
	public double getRho() {
		return Rho;
	}

	@Override
	public double getTheta() {
		return Theta;
	}

	@Override
	public void convertStorage() {
		 if(typeCoord != 'C')
		    {
		      /*double temp = getX();
		      Theta = getY();
		      Rho = temp;*/
		   
		      typeCoord = 'C';
		    }

	}

	/*@Override
	public void convertStorage() {
		 if(typeCoord != 'P')
		    {
		      Rho = getRho();
		      Theta = getTheta();
		      typeCoord = 'P'; 
		      
		    }

	}*/

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
	        
	    return new PointCPDesign2('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}

	@Override
	public String toString() {
		return (typeCoord == 'C' 
	       ? "Cartesian Value as (" + getX() + "," + getY() + ")"
	       : "Polar Stored as [" + getRho() + "," + getTheta() + "]") + "\n";
	}
}
