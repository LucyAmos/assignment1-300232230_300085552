
/**
 * 
 * This class represent the information of a Employee Address. It
 * included all the attribute as listed in the memory diagram including
 * the street name, number and postal code
 * 
 * 
 *
 * @author Lucy 
 * @author Raphaelle Jean-Baptiste
 * @version May 2023
 */


public class Address {
    
    //Instance variables ************************************************
    private String street;
    private int Number;
    private String postal;


    //Constructors ******************************************************
    public Address( String street_employee, int Number_employee, String postal_Employee){

        
        this.street  = street_employee;
        this.Number = Number_employee;
        this.postal = postal_Employee;

    }
    //Instance methods **************************************************

    /**
     * Description: Retrieves the street name .
     *
     * @return name street
     *         Type String
     */
    public String getStreet(){
        return street;

    }

    /**
     * Description: Retrieves the number .
     *
     * @return numbers
     *         Type Int
     */
    public int getNumber(){
        return Number;
        
    }

    /**
     * Description: Retrieves the postal code .
     *
     * @return postal code(CAD)
     *         Type String
     */
    public String getPostal(){
        return postal;
    }
    
    /**
     * Description: Format all the address information in a string representation
     * Function has no input. Information include street name, number and postal code
     *
     * @return String containing address
     *         Type String
     */
    public String AddressToString(){
        String output= "";
        
        output = " || Employee Adresss ------------------------------\n"+
            "Street Name : " + getStreet() + "\n" +
            "Number : " + getNumber() + "\n"  +
            "Postal Code : " + getPostal() + "\n\n";
        
        return output;
    }
}
