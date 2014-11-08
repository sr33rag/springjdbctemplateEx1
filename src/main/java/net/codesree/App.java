package net.codesree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.codesree.customer.model.Customer;
import net.codesree.customer.dao.ICustomerDao;

public class App  {

  public static void main( String[] args) {
    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Modules.xml");
    ICustomerDao customerDao=(ICustomerDao) context.getBean("customerDao");
    Customer cust=new Customer(1,"Sreerag",27);
    customerDao.insert(cust);
    
    Customer cust2=customerDao.findByCustomerId(1);
    System.out.println(cust2);
  }
}
