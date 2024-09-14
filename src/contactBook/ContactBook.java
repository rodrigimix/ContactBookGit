package contactBook;

/**
 * ContactBook Class
 * @Author Diogo Jesus - 59969
 * @Author Miguel Sequeira - 63220
 * @Author Rodrigo Marques - 64411
 */
public class ContactBook {
    static final int DEFAULT_SIZE = 100;

    private int counter;
    private Contact[] contacts;
    private int currentContact;

    /**
     * Constructor of ContactBook
     */
    public ContactBook() {
        counter = 0;
        contacts = new Contact[DEFAULT_SIZE];
        currentContact = -1;
    }


    /**
     * hasContact - verify if the name of the person exists on ContactBook
     * @
     * @param name name of the person
     * @return True - if the contact exists on ContactBook | False - otherwise
     */
    //Pre: name != null
    public boolean hasContact(String name) {
        return searchIndex(name) >= 0;
    }

    /**
     * getNumberOfContacts - it's a function that returns the total number of contacts that exists on ContactBook
     * @return total number of contacts that exists on ContactBook
     */
    public int getNumberOfContacts() {
        return counter;
    }

    /**
     * addContact - add the contact on the ContactBook
     * @param name Name of the person
     * @param phone Phone number of the person
     * @param email Email of the person
     */
    //Pre: name!= null && !hasContact(name)
    public void addContact(String name, int phone, String email) {
        if (counter == contacts.length)
            resize();
        contacts[counter] = new Contact(name, phone, email);
        counter++;
    }

    /**
     * deleteContact - deletes the contact of the ContactBook
     * @param name name of the person
     */
    //Pre: name != null && hasContact(name)
    public void deleteContact(String name) {
        int index = searchIndex(name);
        for(int i=index; i<counter; i++)
            contacts[i] = contacts[i+1];
        counter--;
    }

    /**
     * getPhone - Return the phone number of the person
     * @param name name of the person
     * @return phone number of the person
     */
    //Pre: name != null && hasContact(name)
    public int getPhone(String name) {
        return contacts[searchIndex(name)].getPhone();
    }

    /**
     * getEmail - Return the email of the person
     * @param name name of the person
     * @return email of the person
     */
    //Pre: name != null && hasContact(name)
    public String getEmail(String name) {
        return contacts[searchIndex(name)].getEmail();
    }

    /**
     * setPhone - Update the phone number of the person
     * @param name name of the person
     * @param phone number to change
     */
    //Pre: name != null && hasContact(name)
    public void setPhone(String name, int phone) {
        contacts[searchIndex(name)].setPhone(phone);
    }

    /**
     * setEmail - Update the email of the person
     * @param name name of the person
     * @param email email to change
     */
    //Pre: name != null && hasContact(name)
    public void setEmail(String name, String email) {
        contacts[searchIndex(name)].setEmail(email);
    }

    /**
     * searchIndex - function that searches throw the array the contact of the person
     * @param name name of the person
     * @return index of array contacts of the contact of the person
     */
    private int searchIndex(String name) {
        int i = 0;
        int result = -1;
        boolean found = false;
        while (i<counter && !found)
            if (contacts[i].getName().equals(name))
                found = true;
            else
                i++;
        if (found) result = i;
        return result;
    }

    /**
     * resize - function that expands the array's capacity "contacts"
     */
    private void resize() {
        Contact tmp[] = new Contact[2*contacts.length];
        for (int i=0;i<counter; i++)
            tmp[i] = contacts[i];
        contacts = tmp;
    }

    /**
     * initializeIterator - initialize the Iterator of contacts
     */
    public void initializeIterator() {
        currentContact = 0;
    }

    /**
     * hasNext - verify if the next iteration has another contact
     * @return True - there is another contact that was unseen | False - otherwise
     */
    public boolean hasNext() {
        return (currentContact >= 0 ) && (currentContact < counter);
    }

    /**
     * next - iterates the next contact
     * @return the Contact object
     */
    //Pre: hasNext()
    public Contact next() {
        return contacts[currentContact++];
    }

    /**
     * getContactName - Lookup a contact given its phone number
     * @param phoneNumber phone number to search throw the contacts
     * @return The name of the person who has this phone number
     */
    public String getContactName(int phoneNumber) {
        for (int i = 0; i < getNumberOfContacts(); i++) {
            if (contacts[i].getPhone() == phoneNumber) {
                return contacts[i].getName();
            }
        }
        return "";
    }

    /**
     * doesBookContainDuplicatePhoneNumbers - Check if there are contacts with the same phone number
     * @return True - if there is two different persons that possesses the same phone number | False - otherwise
     */
    public boolean doesBookContainDuplicatePhoneNumbers() {
        for (int i = 0; i < getNumberOfContacts()-1; i++) {
            for (int j = i+1; j < getNumberOfContacts(); j++) {
                if ( contacts[i].getPhone() == contacts[j].getPhone()) {
                    return true;
                }
            }
        }
        return false;
    }
}
