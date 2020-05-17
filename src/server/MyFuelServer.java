package server;

import java.io.IOException;

import entity.Employee;
import entity.Message;
import ocsf.server.*;


public class MyFuelServer extends AbstractServer 
{

  public MyFuelServer(int port) 
  {
    super(port);
  }

  //this.sendToAllClients(students[i].toString());
  
  public void handleMessageFromClient  (Object msg, ConnectionToClient client)
  {
	 Message message=(Message)msg;
	 
	 System.out.println("Message received: cmd " + message.getCmd() +" the object "+message.getObj()+ " from " + client);
	 
	 switch(message.getCmd()) {
	  case(1)://get all the data of employees
		  //this.sendToAllClients(MysqlConnection.getAllEmployeeData());
	      try {
			client.sendToClient(new Message(MysqlConnection.getAllEmployeeData(),1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  break;
	  case(2)://update employee job
	      Employee temp=(Employee)message.getObj();
	      System.out.println(temp+"   handleMessageFromClient");
		  MysqlConnection.updateEmployeeJob(temp);
		  System.out.println("database updated");
	      try {
			client.sendToClient(new Message("updated the employee Job",0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  break;
		  default:
			  System.out.println("default");
	  }
	 
  }
   
  protected void serverStarted()
  {
	MysqlConnection.startConnection();
    System.out.println ("Server listening for connections on port " + getPort());
  }
  
  
  protected void serverStopped()
  {
    System.out.println ("Server has stopped listening for connections.");
  }  
}