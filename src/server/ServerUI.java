package server;

public class ServerUI {
	final public static String DEFAULT_PORT = "5555";


	public static void main(String args[]) throws Exception {
		runServer(DEFAULT_PORT);
	}

	public static void runServer(String p) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(p); // Set port to 5555

		} catch (Throwable t) {
			System.out.println("ERROR - Could not connect!");
		}

		MyFuelServer sv = new MyFuelServer(port);
		
		
		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}

}
