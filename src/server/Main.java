package server;

import Entity.Customer;
import Entity.Employee;
import Entity.Supplier;

public class Main {

	public static void main(String[] args) {
		
		ConnectionToDB.connectToDB("myfueldb","1611");
		try {
			Object o = LogINController.LogIn("a23","123");
			
			if(o instanceof Customer) System.out.println("customer");
			else if(o instanceof Employee) System.out.println("employee");
			else if(o instanceof Supplier) System.out.println("supplier"); 
			else System.out.println("not exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
