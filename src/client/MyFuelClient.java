// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.MyFuelIF;
import entity.Employee;
import entity.Message;

import java.io.*;
import java.util.ArrayList;

public class MyFuelClient extends AbstractClient {

	MyFuelIF clientUI;
	public static ArrayList<Employee> s1;
	// to be check Saleem Yosuf
	public static boolean awaitResponse = false;

	public MyFuelClient(String host, int port, MyFuelIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		openConnection();
	}

	@SuppressWarnings("unchecked")
	public void handleMessageFromServer(Object msg) {
		System.out.println("recive---");
		if (msg != null) {
			Message message = (Message) msg;
			if(message.getObj()!=null) {
				switch (message.getCmd()) {
				case (1):// receive from server ArrayList<employee>
					s1 = (ArrayList<Employee>) message.getObj();
					break;
				}
			}
		}
		awaitResponse = false;
	}

	public void handleMessageFromClientUI(Object str) {
		try {
			awaitResponse = true;
			sendToServer(str);
			// wait for response
			while (awaitResponse) {
				try {
					Thread.sleep(100);
					System.out.println("still waiting");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			clientUI.display("Could not send message to server.  Terminating client.");
			e.printStackTrace();
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
