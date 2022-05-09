package au.com.planittesting.challenge7;

/**
 * This is Customer POJO class contains getter, setter and toString method.
 *
 * @author Parbati Budhathoki
 * @Created On May 7, 2022 1:01:01 PM
 */
public class Customer {

    private Integer CustomerId;
    private String CustomerName;
    private String Country;
    private String Email;

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return CustomerId + " \t\t" + CustomerName + " \t\t" + Country + " \t" + Email + " \t";
    }

}
