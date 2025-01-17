package controll.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface customerService {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deletecustomer(String id);
    Customer searchCustomer(String id);

    List<Customer> getAll() throws SQLException;

}
