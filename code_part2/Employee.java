/**
 * This class represent the information of a Employee. It
 * included all the attribute as listed in the memory diagram including
 * id, name, hours, rates. and address(es)

 *
 * @author Lucy 
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */

public class Employee {
    
    
    //Instance Variables
    private int Id;
    private String name;
    private int hours;
    private double rate;

    //Not sure about this one
    private Address address_array[];


    //Constructors ******************************************************

    /**
    * Constructs a Employee object.
    */

    public Employee( int Id_employee, String name_employee, int hours_employee, double rate_employee, Address address_employee[]){

        
        this.name = name_employee;
        this.Id = Id_employee;
        this.hours = hours_employee;
        this.rate = rate_employee;
        this.address_array = address_employee;
    }
        

    //Instance methods **************************************************

    /**
     * Description: Retrieves the randomly generated ID for the employee.
     *
     * @return The ID of the employee 
     *         Type int
     */

    public int GetID(){
        return Id;
    }

    /**
     * Description: Retrieves name of the employee.
     *
     * @return The name of the employee.
     *         Type String
     */
    public String GetName(){
        return name;
    }

    /**
     * Description: Retrieves number of hours of the employee.
     *
     * @return The number of hours of the employee.
     *         Type int
     */
    public int GetHours(){
        return hours;
    }


    /**
     * Description: Retrieves the rate for the employee.
     *
     * @return The rate for the employee.
     *         Type Double
     */
    public double GetRate(){
        return rate;
    
    }


    /**
     * Description: Retrieves the address of the employee.
     *
     * @return The Address of the employee.
     *         Type Address
     */
    public Address GetAdress(){

        Address address;
        String street = "";
        int Number = -1;
        String postal = "";

        // for every adress in array
        for ( int i=0;i< address_array.length;i++){
            address=address_array[i];
            street = address.getStreet();
            Number = address.getNumber();
            postal = address.getPostal();


        }
        return (new Address (street,Number,postal));

        
    }
    
    
    /**
     * Description: Format all the employee information in a string representation
     * Function has no input.
     *
     * @return String containing all the employee information associated with the
     * id.
     *         Type String
     */
    public String FormatEmployeeString(){
        String output= "";
        String str = "";
        boolean flag = true;
        int counter = 0;
        int i = 0;

        output = "------------------------------ Employee information ------------------------------\n" +
            "Employee ID : 0" + GetID() + "\n" +
            "Employee Name : " + GetName() + "\n" +
            "Employee Hours : " + GetHours() + "\n" +
            "Employee Rate : " + GetRate() +"\n\n\n";


        //Printing Adress Employee
        
        if(address_array.length != 0){ // if not empty
            
            while(flag && counter <= address_array.length){ // while next cell not empty
                if(address_array[i] !=null){
                    counter++;
                    
                }else // rest of cells empty
                    flag = false;
                i++;
            }

            for( int j=0;j<counter;j++){
                
                str = str + " " + (j +1) + " "; 
                String tmp = address_array[j].AddressToString() + "\n";
                str = str +tmp;
                
            }
            
        }
                
        
        output = output + str;
        return output;
    }
}