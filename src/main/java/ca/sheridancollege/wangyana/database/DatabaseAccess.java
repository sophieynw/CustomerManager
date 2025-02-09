package ca.sheridancollege.wangyana.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.wangyana.beans.Customer;
import ca.sheridancollege.wangyana.beans.Region;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    // method to retrieve a List of Customer objects from the database
    public List<Customer> getCustomerList() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM customer";
        return jdbc.query(query, namedParameters,
                new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    // method to retrieve a List of Region objects from the database
    public List<Region> getRegionList() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM region";
        return jdbc.query(query, namedParameters,
                new BeanPropertyRowMapper<Region>(Region.class));
    }

    // method to add a Customer object to the database
    public void addCustomer(String custName, String custAddress,
            String custRegion, String custCountry) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO customer "
                + "(custName, custAddress, custRegion, custCountry) "
                + "VALUES (:custName, :custAddress, :custRegion, :custCountry)";
        namedParameters.addValue("custName", custName);
        namedParameters.addValue("custAddress", custAddress);
        namedParameters.addValue("custRegion", custRegion);
        namedParameters.addValue("custCountry", custCountry);
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Inserted customer into database");
        }
    }

    // method to delete Customer object from the database
    public void deleteCustomer(Long custId) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "DELETE FROM customer WHERE custId = :custId";
        namedParameters.addValue("custId", custId);
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Deleted customer from database");
        }
    }

    // method to update Customer object in the database
    public void updateCustomer(Long custId) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE customer SET custName = :custName, custAddress = :custAddress, custRegion = :custRegion, custCountry = :custCountry WHERE custId = :custId";
        namedParameters.addValue("custId", custId);
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Updated customer in database");
        }
    }

    public List<Customer> getCustomerById(Long custId) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM customer WHERE custId = :custId";
        namedParameters.addValue("custId", custId);
        return jdbc.query(query, namedParameters,
                new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public void updateCustomerById(Long custId, String custName, String custAddress, String custRegion,
            String custCountry) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE customer SET custName = :custName, custAddress = :custAddress, custRegion = :custRegion, custCountry = :custCountry WHERE custId = :custId";
        namedParameters.addValue("custId", custId);
        namedParameters.addValue("custName", custName);
        namedParameters.addValue("custAddress", custAddress);
        namedParameters.addValue("custRegion", custRegion);
        namedParameters.addValue("custCountry", custCountry);
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0) {
            System.out.println("Updated customer in database");
        }
    }

}
