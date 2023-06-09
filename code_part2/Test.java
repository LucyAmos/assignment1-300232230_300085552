import java.util.Random;
 /**
 * This class test everything contained in part 2- Object oriented review
 * it is  a main method (that is used to create the necessary instances and initialize all variables)
 * all input class are generated by the methods below
 * 
 * 
 * 
 * @author Lucy Amos
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */

public class Test {
    
    /**
   * This method is responsible for the creation of the Employee
   * object.
   * 
   * 
   * @param none; User input prompted
   */
    public static void main(String[] args){
        RunTester();
    }

    public static void RunTester(){
        System.out.println("\n Running Address.java and Employee.java Test...\n\n");
        
        Employee employee;
        Address[] employee_ad;

        //Prompt user for ID
        System.out.println("------------------------------ Employee DataBase ------------------------------ \n\n");

        try{
            int id = getIDEmployee();
            String name = getNameEmployee();

            //Primary address
            System.out.println("\n| First address information------------------------------ "+"\n");
            String street1 = getStreetEmployee(1);
            String postal1 = getPostalEmployee();

            //Secondary address
            System.out.println("\n| Secondary address information------------------------------ "+"\n");
            String street2 = getStreetEmployee(2);
            String postal2 = getPostalEmployee();

            
            employee_ad = new Address[6];
            employee_ad[0]= new Address(street1,48,postal1);
            employee_ad[1]= new Address(street2,800,postal2);
            
            employee = new Employee(id,name,40,15.50,employee_ad);
            
            System.out.println("\n| Your employee Information  \n" + employee.FormatEmployeeString()); 
            

        }catch(Exception except){
            System.out.println("Error getting employee information. Ending program.");
            return;
        }
    
    }

    //Methods used to generate information for Class

    private static int getIDEmployee(){  
        
        System.out.print("Random employee Id generated ... " + "\n\n");
        Random r = new Random();
        int id = r.nextInt(500);
        /* 
        try{

            id = Integer.parseInt(input);
            if(id < 0)// check if id greater than 0
                throw new IOException();

        }catch(Exception e){
            System.out.println("Incorrect input;" + "\n\n");
            throw new IOException();
        }*/
        
        return id;
    }
    private static String getNameEmployee(){  
        System.out.print("Employee Name generated ... " + "\n\n");
        String name = "John Smith ";

        //If USER INPUT NEEDED
       /* 
       byte[] buffer = new byte[1024];   
        String input = ""; 

        System.out.print("Enter the your employee Name " +"\n");

        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';

        System.in.read(buffer);
        input = new String(buffer).trim();

        try{
            if(!(input.matches("[a-zA-Z]+"))){ // check if name only composed of letters
                throw new IOException();
            }else  
                name = input;

        }catch(Exception e){
            System.out.println("Incorrect input;" + "\n");
            throw new IOException();
        }
        */
        
        return name;
        

    }
    private static String getStreetEmployee(int i){  
        System.out.print("Employee street name generated... " + "\n\n");

        String street = "mainland drive";
        String street2 = "okaland 3rd avenue";

        if(i==1){
            return street;
        }
        return street2;

        //If user input 
        /*
        byte[] buffer = new byte[1024];   
        String input = ""; 
        String street = "";


        System.out.print("Enter the your street name " +"\n");

        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';

        //Read input
        System.in.read(buffer);
        input = new String(buffer).trim();

        try{
            if(!(input.matches("[a-zA-Z]+"))){ 
                throw new IOException("I/O error occured when getting postal Code");
            }else  
                street = input;

        }catch(Exception e){
            System.out.println("Incorrect input;" + "\n");
            throw new IOException();
        }

        */
    }
    private static String getPostalEmployee(){  
        
        System.out.print("Postal Code generated ... " + "\n\n");
        return "K9O P5T";
        

    }
   

}
