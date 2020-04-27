package server;

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
	 Message message=Message.stringToMessage(msg.toString());
	 
	 System.out.println("Message received: cmd " + message.getCmd() +" the object "+message.getObj()+ " from " + client);
	 
	 switch(message.getCmd()) {
	  case(1)://get all the data of employees
		  System.out.println("case 1");
		  this.sendToAllClients(MysqlConnection.getAllEmployeeData());
		  break;
	  case(2)://update employee job
		  MysqlConnection.updateEmployeeJob((Employee)message.getObj());
	  System.out.println("case 2");
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
//End of EchoServer class
