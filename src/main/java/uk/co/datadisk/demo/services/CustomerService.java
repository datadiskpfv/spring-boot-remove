package uk.co.datadisk.demo.services;

import uk.co.datadisk.demo.commands.CustomerForm;
import uk.co.datadisk.demo.domain.Customer;

public interface CustomerService extends CRUDService<Customer>{

    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);

}
