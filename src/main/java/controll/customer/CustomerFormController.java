package controll.customer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController implements customerService {

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnDelete;

        @FXML
        private Button btnReload;

        @FXML
        private Button btnSearch;

        @FXML
        private Button btnUpdate;

        @FXML
        private TableColumn colAddress;

        @FXML
        private TableColumn colId;

        @FXML
        private TableColumn colName;

        @FXML
        private TableColumn colSalary;

        @FXML
        private TableView tblCustomer;

        @FXML
        private TextField txtAddress;

        @FXML
        private TextField txtId;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtSalary;

        @FXML
        void btnAddOnAction(ActionEvent event) {

        }

        @FXML
        void btnDeleteOnAction(ActionEvent event) {

        }

        @FXML
        void btnReloadOnAction(ActionEvent event) {
            loadTable();
        }

        @FXML
        void btnSearchOnAction(ActionEvent event) {

        }

        @FXML
        void btnUpdateOnAction(ActionEvent event) {

        }



        

        private  void loadTable() {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

            ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
            try {
                new customerController().getAll().forEach(customer -> {
                    customerObservableList.add(customer);
                });
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            tblCustomer.setItems(customerObservableList);


        }


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
    public List<Customer> getAll() {
        return List.of();
    }
}
