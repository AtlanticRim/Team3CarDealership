package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.time.LocalDate;
import javafx.scene.text.Text;
import backend.Vehicle;
import dao.VehicleDao;


public class SearchVehicleController {
	
	// searched vehicle
	private Vehicle veh;
	
    @FXML
    private TextField VINField, mileageField, valueField, 
    customerID, custFirstName, custLastName, tempYear, tempModel, tempVIN, tempValue;
    
    @FXML
    private ChoiceBox<String> paymentMethod, makeDropdown, bodyConDropdown, mechConDropdown, tempMake;
	
    @FXML
    private DatePicker salesDate;
    
    @FXML
    private Button searchButton, clearButton, returnButton, purchaseVehButton, openVehInfo;    
    
    @FXML
    private Text vehInfo;
    
    @FXML
    private void initialize() {
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
    	
        // only allows alphabetical characters and numbers up to 17
    	VINField.setTextFormatter(new TextFormatter<> (change -> {
	    	change.setText(change.getText().toUpperCase());
			if ((change.getControlNewText().length() > 17) ||
				(change.getText().matches("[^0-9A-Z]"))) {
				return null;
			}
			return change;
		})); 
    } // end initialize method
    
   
    public void clear(ActionEvent event) {
        /* This method clears all of the fields.*/
    	VINField.clear();
    } // end clear
    
    public void pageReturn(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
    	Parent root = loader.load();
    	
    	RecordOfSaleController controller = loader.getController();
    	controller.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), tempYear.getText(), tempMake.getValue(), tempModel.getText(), tempVIN.getText(), tempValue.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("RecordOfSaleUI.fxml", root);

    } // end pageReturn
    
    public void searchVehicle(ActionEvent event) throws IOException {
    	
    	// if input field is empty return nd print out error message
    	if (VINField.getText().isBlank()) {
    		vehInfo.setText("*Please input a VIN Number*");
    		return;
    	}
    	
        try {
        
        // search database for vehicle with inputed VIN
            VehicleDao dao = new VehicleDao();
            this.veh = dao.retriveVehicle(VINField.getText());
            
        // prints information of the searched vehicle
        	vehInfo.setText("	\r\n"
        			+ veh.getYear() + " "
        			+ veh.getMake() + " "
        			+ veh.getModel() + " "
                	+ "\r\nColor: "
        			+ veh.getColor()
        			+ "\r\nBody Condition: "
        			+ veh.getBodyCondition()
        			+ "\r\nMechanical Condition: "
        			+ veh.getMechCondition() 
        			+ "\r\nMileage: "
        			+ veh.getMileage()
        			+ "\r\nPrice: $"
        			+ veh.getValue()
        			+ "\r\nVIN: "
        			+ veh.getVIN());
            
        } catch (Exception e) {
    		vehInfo.setText("No Vehicle Found");
        	return;
        }
      } // not complete
        	
    // only accessible for managers
    public void openVehInfo(ActionEvent event) throws IOException{    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("VehicleInformationUI.fxml"));
    	Parent root = loader.load();
    	
    	// passes searched vehicle VIN to the vehicle information UI
    	VehicleInformationController controller = loader.getController();
    	controller.showInformation(veh.getVIN(), custFirstName.getText(), custLastName.getText(), customerID.getText(), paymentMethod.getValue(), salesDate.getValue());
    	
    	Main m = new Main();
    	m.changeScene("VehicleInformationUI.fxml", root);
    	
	} // not complete/tested
	
	@FXML
	// switches scene to record of sales UI
	public void purchaseVeh(ActionEvent event) throws IOException {		
		try {
			
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("RecordOfSaleUI.fxml"));
		   	Parent root = loader.load();
		   	RecordOfSaleController recSaleController = loader.getController();
		   	
			// sends searched vehicle information as well as customer information to record of sale UI
		   	recSaleController.showInformation(custFirstName.getText(), custLastName.getText(), customerID.getText(), veh.getMake(), veh.getModel(), 
		   			veh.getYear().toString(), veh.getVIN(), veh.getValue().toString(), paymentMethod.getValue(), salesDate.getValue());
	    	
	    	Main m = new Main();
	    	m.changeScene("RecordOfSaleUI.fxml", root);
        } catch (Exception e) {
        	System.out.println("Error in SearchVehicleController.java");
        	return;
        }		
	} // testing needed
	
	// receives information from vehicle information UI
    public void showInformation (String VIN) {
    	VINField.setText(VIN);
    }
    
    // receives car information from record of sales UI
    public void showInformation(String first, String last, String cusID, String year, String make, String model, String VIN, String price, String paymentMethod, LocalDate salesDate) {
    	custFirstName.setText(first);
    	custLastName.setText(last);
    	customerID.setText(cusID);
    	tempYear.setText(year);
    	tempMake.setValue(make);
    	tempModel.setText(model);
    	tempVIN.setText(VIN);
    	tempValue.setText(price);
    	this.paymentMethod.setValue(paymentMethod);
    	this.salesDate.setValue(salesDate);
    } 
} // end RecordVehicleController
