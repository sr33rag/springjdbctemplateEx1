package net.codesree.customer.model;

import java.io.Serializable;

public class Customer implements Serializable {

  private int custId=-1,iAge=-1;
  private String cName=null;

  public Customer() {}
  
  public Customer(int _custId,String _cName,int _iAge) {
	setCustId(_custId);
	setCName(_cName);
	setIAge(_iAge);  
  }
  
  public void setCustId(int _custId) { this.custId=_custId; }
  public int getCustId() { return this.custId; }
  
  public void setCName(String _cName) { this.cName=_cName; }
  public String getCName() { return this.cName; }
  
  public void setIAge(int _iAge) { this.iAge=_iAge; }
  public int getIAge() { return this.iAge; }

  public String toString() {
	return "Customer[custId:"+getCustId()
	  +",cName:"+getCName()
	  +",iAge:"+getIAge()+"]";  
  }
}
