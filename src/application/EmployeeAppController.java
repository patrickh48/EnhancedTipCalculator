package application;


import javafx.beans.property.ReadOnlyStringWrapper;
/*
 * @TODO Exception HANDLING
	Have at least one person help
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;



public class EmployeeAppController implements Initializable {
	@FXML
	private TableView<Employee> employeeTableView;
	
	@FXML
	private TableColumn<Employee, String> nameColumn;
	
	@FXML
	private TableColumn<Employee, String> salaryColumn;
	
	@FXML
	private TableColumn<Employee, String> typeOfEmployeeColumn;
	
	public static int id = 4800;

	@FXML
	private TextField typeOfEmployee;
	
    @FXML
    private TextField completedSalary;

    @FXML
    private TextField ficaMedicareField;

    @FXML
    private TextField ficaSocialField;

    @FXML
    private TextField futaField;

    @FXML
    private TextField healthInsurance;

    @FXML
    private TextField medicalInsuranceTax;


    @FXML
    private TextField salaryAfterTax;

    @FXML
    private TextField selectionName;

    @FXML
    private TextField sutaField;

    @FXML
    private TextField totalTaxesField;
	
	
	private ObservableList<Employee> employeeArr = FXCollections.observableArrayList();
	
    @FXML
    private Label label1;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextField testTextField;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    private static final String[] typeOfEmployees = {"Salary", "Commission","Base+Comission"};
    
    @FXML
    private ChoiceBox<String> typeChoiceBox1;

    private static final String[] typeOfInsurance = {"HSA", "PPO","HMO"};


    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	// Creates an Array of textFields for easy changing of stuff
    	TextField[] textFieldArr = {taxTextField, selectionName, completedSalary, typeOfEmployee,
    			healthInsurance,salaryAfterTax,ficaSocialField,ficaMedicareField,futaField,sutaField,
    			medicalInsuranceTax,totalTaxesField};
    	for(TextField field:textFieldArr) {
    		field.setEditable(false);
    	}
    	System.out.println(employeeArr);
        typeChoiceBox.getItems().addAll(typeOfEmployees);
        typeChoiceBox1.getItems().addAll(typeOfInsurance);
        // Lambda vectors, sets CellData equal to the CellData's objects name, salary, and name of object in each lamba function respectively
        nameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        salaryColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.format("$%.2f",cellData.getValue().getTotalSalary())));
        typeOfEmployeeColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getClass().getSimpleName()));
       
        employeeTableView.setItems(employeeArr);
        /*
         * Code for populating rightside table using left side tableview
         */
        // Probably should use Currency Formatting import to be honest
        employeeTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)-> {
        	if(newVal != null) {
        		selectionName.setText(newVal.getName());
        		typeOfEmployee.setText(newVal.getClass().getSimpleName());
        		completedSalary.setText(String.format("$%.2f", newVal.getTotalSalary()));
        		healthInsurance.setText(newVal.getHealthInsurance());
        		salaryAfterTax.setText(String.format("$%.2f", newVal.getTotalSalary()-newVal.getTaxHoldings()));
        		ficaSocialField.setText(String.format("$%.2f", newVal.getFICASocial()));
        		ficaMedicareField.setText(String.format("$%.2f", newVal.getFICAMedicare()));
        		futaField.setText(String.format("$%.2f", newVal.getFederalIncomeTax()));
        		sutaField.setText(String.format("$%.2f", newVal.getSUTA()));
        		medicalInsuranceTax.setText(String.format("$%.2f", newVal.getMedicalInsurance()));
        		totalTaxesField.setText(String.format("$%.2f", newVal.getTaxHoldings()));
        		
        	}
        });
    }
    
    @FXML
    private void addEmployeePressed(ActionEvent event){
    	try {
    	//Increment id
	    	id++;
	    	//Get Name, Salary, Employee Type
	        String tempName = nameTextField.getText();
	        String employeeType = typeChoiceBox.getValue();
	        String insuranceType = typeChoiceBox1.getValue();	
	        double tempSalary = Double.parseDouble(salaryTextField.getText());
	        if(employeeType == "Salary") {
	        	employeeArr.add(new SalaryEmployee(tempName,id,insuranceType,tempSalary));
	        }
	        else if(employeeType == "Commission") {
	        	employeeArr.add(new CommissionEmployee(tempName,id,insuranceType,tempSalary, 0));
	        }
	        else {
	        	employeeArr.add(new BaseComissionEmployee(tempName,id,insuranceType,tempSalary,tempSalary));
	        }
	        taxTextField.setText(String.format("$%.2f",employeeArr.get(employeeArr.size()-1).getTaxHoldings()));
	        for(Employee employee: employeeArr) {
	        	System.out.println(employee);
	        }
    	}
    	catch(Exception e) {
    		nameTextField.setText("Insert a Name");
    		salaryTextField.setText("####.##");
    	}

    }
    
    //Deletion of Employee Button
    @FXML
    public void deleteEmployeePressed() {
    	employeeArr.remove(employeeTableView.getSelectionModel().getSelectedItem());
    	//Yes its really that easy
    }



}
