package net.codesree.customer.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import net.codesree.customer.model.Customer;
import net.codesree.customer.dao.ICustomerDao;

public class JdbcCustomerDaoImpl implements ICustomerDao {

  private DataSource dataSource=null;
  private JdbcTemplate jdbcTemplate=null;
  
  public void setDataSource(DataSource _dataSource) { this.dataSource=_dataSource; }

  public void insert(Customer cust) {
	String query="INSERT INTO tbl_customers(cust_Id,cName,iAge) VALUES (?,?,?)";
	jdbcTemplate=new JdbcTemplate(dataSource);
	jdbcTemplate.update(query,new Object[]{cust.getCustId(), cust.getCName(),cust.getIAge()});
  }
  
  public Customer findByCustomerId(int custId) {
	Customer cust=null;
	String query="SELECT * FROM tbl_customers cust WHERE cust.cust_Id=?";
	jdbcTemplate=new JdbcTemplate(dataSource);
	cust=(Customer)jdbcTemplate.queryForObject(query,new Object[]{custId},new CustomerMapper());
	return cust;
  }
}

class CustomerMapper implements RowMapper {

  public Object mapRow(ResultSet rs,int rowNum) throws SQLException {
	Customer cust=new Customer();
	cust.setCustId(rs.getInt("cust_Id"));
	cust.setCName(rs.getString("cName"));
	cust.setIAge(rs.getInt("iAge"));
	return cust;
  }
  
}

