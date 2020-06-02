import org.openxava.tests.ModuleTestBase;


// Must extend from ModuleTestBase
public class CustomerTest extends ModuleTestBase {
    public CustomerTest(String testName) {
        // We indicate the application name (Invoicing) and the module name (Customer)
        super(testName,"","Customer");
    }

    // The test methods must start with 'test'
    public void testCreateReadUpdateDelete() throws Exception {
        // The user sign in to access the module
        login("admin", "admin");

        //Create
        //Clicks on 'New' Button
        execute("CRUD.new");
        //Types 77 as the value for the 'number' field
        setValue("number", "77");
        //Sets the value for the 'name' field
        setValue("name", "JUNIT Customer");
        //use dot notation to access a reference member
        setValue("address.street", "JUNIT Street");
        setValue("address.zipCode", "77555"); // Etc
        setValue("address.city", "The JUNIT city"); // Etc
        setValue("address.state", "The JUNIT state"); // Etc

        //Clicks on 'Save' button
        execute("CRUD.save");

        //Verifies that the application does not show errors
        assertNoErrors();

        //Verifies that fields are empty after save
        assertValue("number", ""); // Verifies the 'number' field is empty
        assertValue("name", ""); // Verifies the 'name' field is empty
        assertValue("address.street", ""); // Etc
        assertValue("address.zipCode", ""); // Etc
        assertValue("address.city", ""); // Etc
        assertValue("address.state", ""); // Etc

        //Read

        //Types 77 as the value for the 'number' field
        setValue("number", "77");
        execute("CRUD.refresh");
        assertValue("number", "77");  // Verifies the 'number' field has 77
        assertValue("name", "JUNIT Customer");
        assertValue("address.street", "JUNIT Street"); // Etc
        assertValue("address.zipCode", "77555"); // Etc
        assertValue("address.city", "The JUNIT city"); // Etc
        assertValue("address.state", "The JUNIT state"); // Etc

        //Update
        //Change the value of 'name' field
        setValue("name", "JUNIT Customer MODIFIED");
        execute("CRUD.save");
        assertNoErrors();  // Verifies that the application does not show errors
        assertValue("name", "");
        assertValue("number", "");

        // Verify if modified
        setValue("number", "77"); // Types 77 as the value for 'number' field
        execute("CRUD.refresh"); // Clicks on 'Refresh' button
        assertValue("number", "77"); // Verifies the 'number' field has 77
        assertValue("name", "JUNIT Customer MODIFIED"); // and 'name' has 'JUNIT Customer MODIFIED'

        //Delete
        execute("CRUD.delete");
        // Verifies that the message 'Customer deleted successfully' is shown to the user
        assertMessage("Customer deleted successfully");





    }
}
