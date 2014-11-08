package net.codesree.customer.dao;

import java.io.Serializable;

import net.codesree.customer.model.Customer;

public interface ICustomerDao extends Serializable {

  public void insert(Customer cust);
  public Customer findByCustomerId(int custid);

}
