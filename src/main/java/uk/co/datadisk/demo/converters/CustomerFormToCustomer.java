package uk.co.datadisk.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import uk.co.datadisk.demo.commands.CustomerForm;
import uk.co.datadisk.demo.domain.Address;
import uk.co.datadisk.demo.domain.Customer;
import uk.co.datadisk.demo.domain.User;


@Component
public class CustomerFormToCustomer implements Converter<CustomerForm, Customer> {

    @Override
    public Customer convert(CustomerForm customerForm) {

        Customer customer = new Customer();
        customer.setUser(new User());
        customer.setBillingAddress(new Address());
        customer.setShippingAddress(new Address());
        customer.getUser().setId(customerForm.getUserId());
        customer.getUser().setVersion(customerForm.getUserVersion());
        customer.setId(customerForm.getCustomerId());
        customer.setVersion(customerForm.getCustomerVersion());
        customer.getUser().setUsername(customerForm.getUserName());
        customer.getUser().setPassword(customerForm.getPasswordText());
        customer.setFirstName(customerForm.getFirstName());
        customer.setLastName(customerForm.getLastName());
        customer.setEmail(customerForm.getEmail());
        customer.setPhoneNumber(customerForm.getPhoneNumber());

        return customer;
    }
}
