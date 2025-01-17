package controll.customer;

import DBConnection.GetDBConnection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class customerController implements customerService{




    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deletecustomer(String id) {
        return false;
    }

    @Override
    public Customer searchCustomer(String id) {
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        ArrayList<Customer>customerArrayList=new ArrayList<>();

        ResultSet resultSet = GetDBConnection.getInstance().getConnection().createStatement().executeQuery("select * from customer");

        while (resultSet.next())customerArrayList.add(new Customer(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4)
        ));

        return customerArrayList;

    }
}
