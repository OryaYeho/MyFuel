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
//Very Important Saleem

public class ClientController{
/*
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
	private TableColumn<Employee,String> AffiliationCol;
*/
	@FXML
	private TableView<Employee> employeeTable;

	// The table's data
	private ObservableList<Employee> data;

	// Client stuff
	private static int itemIndex = 3;

	public ClientConsole ClientMyFuel = new ClientConsole("localhost", 5555);

	public void ChangeJob(CellEditEvent<Employee, Jobs> event) throws Exception {
       TablePosition<Employee, Jobs> pos = event.getTablePosition();
       Jobs newJob = event.getNewValue();
       Employee employee = event.getTableView().getItems().get(pos.getRow());
       employee.setWorkerJob(newJob);
            
       ClientMyFuel.accept(new Message(employee,2));
       
       System.out.println("the job is "+newJob);

	}

	public void loadEmployees(ArrayList<Employee> s1) {
		data = FXCollections.observableArrayList(s1);
		employeeTable.setItems(data);
	}
	
	
	public void initialize() {
		/*
		employeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("workerID"));
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		MailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("mail"));
		AffiliationCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("organizationalAffiliation"));
		
		ObservableList<Jobs> jobsList = FXCollections.observableArrayList(Jobs.values());
		jobCol.setCellFactory(ComboBoxTableCell.forTableColumn(jobsList));
		*/
		
		@SuppressWarnings("unchecked")
		TableColumn<Employee, String> employeeIDCol= (TableColumn<Employee, String>)
		        employeeTable.getColumns().get(0);
		employeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("workerID"));
		
		@SuppressWarnings("unchecked")
		TableColumn<Employee, String> firstNameCol= (TableColumn<Employee, String>)
				employeeTable.getColumns().get(1);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		
		@SuppressWarnings("unchecked")
		TableColumn<Employee, String> lastNameCol= (TableColumn<Employee, String>)
				employeeTable.getColumns().get(2);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		
		@SuppressWarnings("unchecked")
		TableColumn<Employee, String> MailCol= (TableColumn<Employee, String>)
				employeeTable.getColumns().get(3);
		MailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("mail"));
		
		//this is the part of COMBO BOX
		
		@SuppressWarnings("unchecked")
		TableColumn<Employee, Jobs> jobCol = (TableColumn<Employee, Jobs>)
				employeeTable.getColumns().get(4);
		
		ObservableList<Jobs> jobsList = FXCollections.observableArrayList(Jobs.values());
		jobCol.setCellFactory(ComboBoxTableCell.forTableColumn(jobsList));
				
		@SuppressWarnings("unchecked")
		TableColumn<Employee, String> organizationalAffiliationCol = (TableColumn<Employee, String>)
				employeeTable.getColumns().get(5);
		organizationalAffiliationCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("organizationalAffiliation"));
		
		jobCol.setCellValueFactory(new Callback<CellDataFeatures<Employee, Jobs>, ObservableValue<Jobs>>() {
			@Override
			public SimpleObjectProperty<Jobs> call(CellDataFeatures<Employee, Jobs> param) {
				Employee employee = param.getValue();
				return new SimpleObjectProperty<Jobs>(employee.getWorkerJob());
			}
		});

		

	}

	public void start(Stage primaryStage) throws Exception {
		Pane mainPane;
		Scene s;
		//ClientMyFuel.accept(new Message("getAllData",1).toString());
		ClientMyFuel.accept(new Message("getAllData",1));
		
		
		// load the fxml file called 'ClientGUI' to mainPane
		// because the main fram is Pane object
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ClientGUI.fxml"));
		mainPane = loader.load();
		//sfc = loader.getController();
		
		
		employeeTable=(TableView<Employee>)mainPane.getChildren().get(0);
		employeeTable.setEditable(true);
		
		initialize();
		this.loadEmployees(MyFuelClient.s1);
		
		
		// connect the scene to the file
	    s = new Scene(mainPane);
	    
		primaryStage.setTitle("MyFuel ltm");
		primaryStage.setScene(s);
		primaryStage.show();

	}


}
