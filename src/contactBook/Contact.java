package contactBook;

/**
 * Contact Class
 * @Author Diogo Jesus - 59969
 * @Author Miguel Sequeira - 63220
 * @Author Rodrigo Marques - 64411
 */
public class Contact {
    private String name;
    private int phone;
    private String email;

    /**
     * Contact's Constructor
     * @param name name of the person
     * @param phone phone number of the person
     * @param email email of the person
     */
    public Contact(String name, int phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * getName - Returns the name of the person
     * @return name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * getPhone - Returns the phone number of the person
     * @return phone number of the person
     */
    public int getPhone() {
        return phone;
    }

    /**
     * getEmail - Return the email of the person
     * @return email of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * setPhone - update the phone number of the person
     * @param phone update cell phone number
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * setEmail - update the email of the person
     * @param email update email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * equals - Verify if this Contact Object is equal to the other Contact Object
     * @param otherContact the other Contact Object to compare
     * @return true - if this two contacts are identical | false - otherwise
     */
    //Pre: otherContact != null
    public boolean equals(Contact otherContact) {
        return name.equals(otherContact.getName());
    }
}
