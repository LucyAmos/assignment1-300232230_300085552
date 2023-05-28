// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/


import java.util.Random;

/**
 * This class calculates the average time in 5000 instances it takes to process operations in design 1 
 * and design 5 in order to determine which is more efficient.
 *
 * @author Lucy Amos
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */
public class PointCPPerformanceTest
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP and PointCP5
   * object. 
   *
   */
  public static void main(String[] args)
  {
	int instances = 50000;
	
	long design1TotalTimePolar = 0;
	long design1TotalTimeCartesian = 0;
	long design1TotalTimeConvertToPolar = 0;
	long design1TotalTimeConvertToCartesian = 0;
	long design1TotalTimeGetX = 0;
	long design1TotalTimeGetY = 0;
	long design1TotalTimeGetRho = 0;
	long design1TotalTimeGetTheta = 0;
	long design1TotalTimeToString = 0;
	long design2TotalTimePolar = 0;
	long design2TotalTimeCartesian = 0;
	long design2TotalTimeConvertToPolar = 0;
	long design2TotalTimeConvertToCartesian = 0;
	long design2TotalTimeGetX = 0;
	long design2TotalTimeGetY = 0;
	long design2TotalTimeGetRho = 0;
	long design2TotalTimeGetTheta = 0;
	long design2TotalTimeToString = 0;
	long design3TotalTimePolar = 0;
	long design3TotalTimeCartesian = 0;
	long design3TotalTimeConvertToPolar = 0;
	long design3TotalTimeConvertToCartesian = 0;
	long design3TotalTimeGetX = 0;
	long design3TotalTimeGetY = 0;
	long design3TotalTimeGetRho = 0;
	long design3TotalTimeGetTheta = 0;
	long design3TotalTimeToString = 0;
	long design5TotalTimePolar = 0;
	long design5TotalTimeCartesian = 0;
	long design5TotalTimeConvertStorage = 0;
	long design5TotalTimeGetX = 0;
	long design5TotalTimeGetY = 0;
	long design5TotalTimeGetRho = 0;
	long design5TotalTimeGetTheta = 0;
	long design5TotalTimeToString = 0;
	
	for(int i = 0; i < instances; i++) {
		PointCP pointD1 = pointD1Generator();
		PointCP2 pointD2 = pointD2Generator();
		PointCP3 pointD3 = pointD3Generator();
		PointCP5 pointD5 = pointD5Generator();
		
		long tempStart = System.nanoTime();
		pointD1.getRho();
		pointD1.getTheta();
		long tempEnd = System.nanoTime();
		design1TotalTimePolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getRho();
		pointD2.getTheta();
		tempEnd = System.nanoTime();
		design2TotalTimePolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getRho();
		pointD3.getTheta();
		tempEnd = System.nanoTime();
		design3TotalTimePolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getRho();
		pointD5.getTheta();
		tempEnd = System.nanoTime();
		design5TotalTimePolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.getX();
		pointD1.getY();
		tempEnd = System.nanoTime();
		design1TotalTimeCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getX();
		pointD2.getY();
		tempEnd = System.nanoTime();
		design2TotalTimeCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getX();
		pointD3.getY();
		tempEnd = System.nanoTime();
		design3TotalTimeCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getX();
		pointD5.getY();
		tempEnd = System.nanoTime();
		design5TotalTimeCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.convertStorageToPolar();
		tempEnd = System.nanoTime();
		design1TotalTimeConvertToPolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.convertStorageToPolar();
		tempEnd = System.nanoTime();
		design2TotalTimeConvertToPolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.convertStorageToPolar();
		tempEnd = System.nanoTime();
		design3TotalTimeConvertToPolar += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.convertStorage();
		tempEnd = System.nanoTime();
		design5TotalTimeConvertStorage += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.convertStorageToCartesian();
		tempEnd = System.nanoTime();
		design1TotalTimeConvertToCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.convertStorageToCartesian();
		tempEnd = System.nanoTime();
		design2TotalTimeConvertToCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.convertStorageToCartesian();
		tempEnd = System.nanoTime();
		design3TotalTimeConvertToCartesian += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.getX();
		tempEnd = System.nanoTime();
		design1TotalTimeGetX += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getX();
		tempEnd = System.nanoTime();
		design2TotalTimeGetX += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getX();
		tempEnd = System.nanoTime();
		design3TotalTimeGetX += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getX();
		tempEnd = System.nanoTime();
		design5TotalTimeGetX += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.getY();
		tempEnd = System.nanoTime();
		design1TotalTimeGetY += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getY();
		tempEnd = System.nanoTime();
		design2TotalTimeGetY += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getY();
		tempEnd = System.nanoTime();
		design3TotalTimeGetY += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getY();
		tempEnd = System.nanoTime();
		design5TotalTimeGetY += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.getRho();
		tempEnd = System.nanoTime();
		design1TotalTimeGetRho += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getRho();
		tempEnd = System.nanoTime();
		design2TotalTimeGetRho += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getRho();
		tempEnd = System.nanoTime();
		design3TotalTimeGetRho += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getRho();
		tempEnd = System.nanoTime();
		design5TotalTimeGetRho += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.getTheta();
		tempEnd = System.nanoTime();
		design1TotalTimeGetTheta += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.getTheta();
		tempEnd = System.nanoTime();
		design2TotalTimeGetTheta += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.getTheta();
		tempEnd = System.nanoTime();
		design3TotalTimeGetTheta += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.getTheta();
		tempEnd = System.nanoTime();
		design5TotalTimeGetTheta += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD1.toString();
		tempEnd = System.nanoTime();
		design1TotalTimeToString += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD2.toString();
		tempEnd = System.nanoTime();
		design2TotalTimeToString += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD3.toString();
		tempEnd = System.nanoTime();
		design3TotalTimeToString += (tempEnd - tempStart);
		
		tempStart = System.nanoTime();
		pointD5.toString();
		tempEnd = System.nanoTime();
		design5TotalTimeToString += (tempEnd - tempStart);
	}
		
	System.out.println("Average Computation Speeds for Design 1 (Nanoseconds)");
	System.out.println("......................................................");
	System.out.println("Get polar coordinates: " + design1TotalTimePolar/instances);
	System.out.println("Get cartesian coordinates: " + design1TotalTimeCartesian/instances);
	System.out.println("Convert to polar coordinates: " + design1TotalTimeConvertToPolar/instances);
	System.out.println("Convert to cartesian coordinates: " + design1TotalTimeConvertToCartesian/instances);
	System.out.println("Get X coordinates: " + design1TotalTimeGetX/instances);
	System.out.println("Get Y coordinates: " + design1TotalTimeGetY/instances);
	System.out.println("Get Rho coordinates: " + design1TotalTimeGetRho/instances);
	System.out.println("Get Theta coordinates: " + design1TotalTimeGetTheta/instances);
	System.out.println("To string: " + design1TotalTimeToString/instances);
	System.out.println();
	System.out.println("Average Computation Speeds for Design 2 (Nanoseconds)");
	System.out.println("......................................................");
	System.out.println("Get polar coordinates: " + design2TotalTimePolar/instances);
	System.out.println("Get cartesian coordinates: " + design2TotalTimeCartesian/instances);
	System.out.println("Convert to polar coordinates: " + design2TotalTimeConvertToPolar/instances);
	System.out.println("Convert to cartesian coordinates: " + design2TotalTimeConvertToCartesian/instances);
	System.out.println("Get X coordinates: " + design2TotalTimeGetX/instances);
	System.out.println("Get Y coordinates: " + design2TotalTimeGetY/instances);
	System.out.println("Get Rho coordinates: " + design2TotalTimeGetRho/instances);
	System.out.println("Get Theta coordinates: " + design2TotalTimeGetTheta/instances);
	System.out.println("To string: " + design2TotalTimeToString/instances);
	System.out.println();
	System.out.println("Average Computation Speeds for Design 3 (Nanoseconds)");
	System.out.println("......................................................");
	System.out.println("Get polar coordinates: " + design3TotalTimePolar/instances);
	System.out.println("Get cartesian coordinates: " + design3TotalTimeCartesian/instances);
	System.out.println("Convert to polar coordinates: " + design3TotalTimeConvertToPolar/instances);
	System.out.println("Convert to cartesian coordinates: " + design3TotalTimeConvertToCartesian/instances);
	System.out.println("Get X coordinates: " + design3TotalTimeGetX/instances);
	System.out.println("Get Y coordinates: " + design3TotalTimeGetY/instances);
	System.out.println("Get Rho coordinates: " + design3TotalTimeGetRho/instances);
	System.out.println("Get Theta coordinates: " + design3TotalTimeGetTheta/instances);
	System.out.println("To string: " + design3TotalTimeToString/instances);
	System.out.println();
	System.out.println("Average Computation Speeds for Design 5 (Nanoseconds)");
	System.out.println("......................................................");
	System.out.println("Get polar coordinates: " + design5TotalTimePolar/instances);
	System.out.println("Get cartesian coordinates: " + design5TotalTimeCartesian/instances);
	System.out.println("Convert to opposite system: " + design5TotalTimeConvertStorage/instances);
	System.out.println("Get X coordinates: " + design5TotalTimeGetX/instances);
	System.out.println("Get Y coordinates: " + design5TotalTimeGetY/instances);
	System.out.println("Get Rho coordinates: " + design5TotalTimeGetRho/instances);
	System.out.println("Get Theta coordinates: " + design5TotalTimeGetTheta/instances);
	System.out.println("To string: " + design5TotalTimeToString/instances);
	
	
  }
	private static PointCP pointD1Generator() {
		Random rand = new Random();
		if (rand.nextBoolean() == true) {
			char coordType = 'P';
			double rho = rand.nextDouble();
			double theta = rand.nextDouble();
			return new PointCP(coordType, rho, theta);
		}else {
			char coordType = 'C';
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			return new PointCP(coordType, x, y);
		}
	}
	
	private static PointCP2 pointD2Generator() {
		Random rand = new Random();
		if (rand.nextBoolean() == true) {
			char coordType = 'P';
			double rho = rand.nextDouble();
			double theta = rand.nextDouble();
			return new PointCP2(coordType, rho, theta);
		}else {
			char coordType = 'C';
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			return new PointCP2(coordType, x, y);
		}
	}
	
	private static PointCP3 pointD3Generator() {
		Random rand = new Random();
		if (rand.nextBoolean() == true) {
			char coordType = 'P';
			double rho = rand.nextDouble();
			double theta = rand.nextDouble();
			return new PointCP3(coordType, rho, theta);
		}else {
			char coordType = 'C';
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			return new PointCP3(coordType, x, y);
		}
	}
	
	private static PointCP5 pointD5Generator() {
		Random rand = new Random();
		if (rand.nextBoolean() == true) {
			char coordType = 'P';
			double rho = rand.nextDouble();
			double theta = rand.nextDouble();
			return new PointCPDesign2(coordType, rho, theta);
		}else {
			char coordType = 'C';
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			return new PointCPDesign3(coordType, x, y);
		}
	}
}


    