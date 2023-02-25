package application;

import java.time.LocalDate;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class VehicleInformationController {

    @FXML
    private TextField ValueField, VINField, YearField, ModelField, MileageField, ColorField;
    
    @FXML
    private Button returnButton;
    
    @FXML
    private DatePicker timeOnLot;
    // add datepicker to UI

    @FXML
    private ChoiceBox<String> MakeDropdown, BodyConDropdown, MechConDropdown;
    
    @FXML
    private Button SaveButton, ReturnButton, addVehToSale;   
    
    final private ObservableList<String> conditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
    final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
    
//    private String previousPage = Main.getView();
    
    @FXML
    private void initialize() {
        
        /* This method is called automatically, and initializes the dropdown
         * boxes with the values of the source ObservableLists*/
        
        MakeDropdown.setItems(makeList);
        BodyConDropdown.setItems(conditionList);
        MechConDropdown.setItems(conditionList);

        // get info from database
        
        
        
        
        
        
    } // end initialize method
    
    public void pageReturn(ActionEvent event) throws IOException {
        
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchVehicleUI.fxml"));
    	Parent root = loader.load();
    	
    	SearchVehicleController searchVehController = loader.getController();
    	searchVehController.showInformation(MakeDropdown.getValue(), ModelField.getText(), YearField.getText(), ColorField.getText(), 
    			BodyConDropdown.getValue(), MechConDropdown.getValue());
    	
    	Main m = new Main();
//    	m.changeScene("SearchVehicleUI.fxml");
    	m.changeScene("SearchVehicleUI.fxml", root);
        
    } // end pageReturn	
    
    public void addVehToSale(ActionEvent event) throws IOException{
    	
    	
    	
    	
    	
    	
    	
//    	Main m = new Main();
//    	m.changeScene("RecordOfSaleUI.fxml");
    }
    
    public void saveChanges(ActionEvent event) throws IOException {

//		firstName.getSelectedText();

    	// change info in database
    
    
    
    	
    	
    	
    	
    	
    
    

//    if success print out success through updateSuccessful Text field
//    if not, print out not successful
    }
}