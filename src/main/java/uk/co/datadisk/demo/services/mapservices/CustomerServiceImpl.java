package uk.co.datadisk.demo.services.mapservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import uk.co.datadisk.demo.commands.CustomerForm;
import uk.co.datadisk.demo.converters.CustomerFormToCustomer;
import uk.co.datadisk.demo.domain.Customer;
import uk.co.datadisk.demo.domain.DomainObject;
import uk.co.datadisk.demo.services.CustomerService;

import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    public void setCustomerFormToCustomer(CustomerFormToCustomer customerFormToCustomer) {
        this.customerFormToCustomer = customerFormToCustomer;
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
        Customer newCustomer = customerFormToCustomer.convert(customerForm);

        if(newCustomer.getUser().getId() != null){
            Customer existingCustomer = getById(newCustomer.getId());

            newCustomer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
        }

        return saveOrUpdate(newCustomer);
    }
}
