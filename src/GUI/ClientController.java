package GUI;

import java.util.ArrayList;

import client.ClientConsole;
import client.MyFuelClient;
import entity.Employee;
import entity.Jobs;
import entity.Message;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

//import client.*; when we create the client class
//Very Important 

public class ClientController{

	@FXML
	private TableColumn<Employee, String> employeeIDCol;
	@FXML
	private TableColumn<Employee, String> firstNameCol;
	@FXML
	private TableColumn<Employee, String> lastNameCol;
	@FXML
	private TableColumn<Employee, String> MailCol;
	@FXML
	private TableColumn<Employee, Jobs> jobCol;
	@FXML
	private TableView<Employee> employeeTable;

	// The table's data
	private ObservableList<Employee> data;

	// Client stuff
	private static int itemIndex = 3;

	public ClientConsole ClientMyFuel;

	public void ChangeJob(CellEditEvent<Employee, Jobs> event) throws Exception {
       TablePosition<Employee, Jobs> pos = event.getTablePosition();
       Jobs newJob = event.getNewValue();
       Employee employee = event.getTableView().getItems().get(pos.getRow());
       employee.setWorkerJob(newJob);
            
       //call the server for update job to newJob
       ClientMyFuel.accept(new Message(employee,2).toString());
       
       System.out.println("the job is "+newJob);

	}

	public void loadEmployees(ArrayList<Employee> s1) {
		data = FXCollections.observableArrayList(s1);
		employeeTable.setItems(data);
	}
	
	
	public void initialize() {

		employeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("workerID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		MailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("mail"));

		ObservableList<Jobs> jobsList = FXCollections.observableArrayList(Jobs.values());

		jobCol.setCellValueFactory(new Callback<CellDataFeatures<Employee, Jobs>, ObservableValue<Jobs>>() {
			@Override
			public SimpleObjectProperty<Jobs> call(CellDataFeatures<Employee, Jobs> param) {
				Employee employee = param.getValue();
				return new SimpleObjectProperty<Jobs>(employee.getWorkerJob());
			}
		});

		jobCol.setCellFactory(ComboBoxTableCell.forTableColumn(jobsList));

	}

	public void start(Stage primaryStage) throws Exception {
		Pane mainPane;
		Scene s;
        String res="1getAllData";
		//send to server
		ClientMyFuel = new ClientConsole("localhost", 5555);
		//ClientMyFuel.accept(new Message("getAllData",1).toString());
		ClientMyFuel.accept(res);
		
		System.out.println("I had send the message THanks");
		
		// load the fxml file called 'ClientGUI' to mainPane
		// because the main fram is Pane object
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ClientGUI.fxml"));
		mainPane = loader.load();
		//sfc = loader.getController();
		
		// connect the scene to the file
		s = new Scene(mainPane);
		
		initialize();
		this.loadEmployees(MyFuelClient.s1);
		
		primaryStage.setTitle("MyFuel ltm");
		primaryStage.setScene(s);
		primaryStage.show();

	}

}
