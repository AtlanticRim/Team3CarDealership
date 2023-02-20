package application;

import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.io.IOException;
public class CreateOrderforDealershipController {

	 private String previousPage = "SalespersonView.fxml";
	 @FXML
	 private Button ClearButton;
	 @FXML
	 private Button SendButton;
	 @FXML
	 private Button ReturnButton;
	 @FXML
	 private ChoiceBox<String> MakeCar;
     final private ObservableList<String> makeList = FXCollections.observableArrayList("Acura", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "BMW", "Buick", 
            "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Fiat", "Ford", "Genesis", "GMC", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", 
            "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Maserati", "Mazda", "McLaren", "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Porsche", "Ram", 
            "Rolls-Royce", "Subaru", "Tesla", "Toyota", "Volkswagen", "Volvo");
	 @FXML
	 private ChoiceBox<String> ModelCar;
	 final private ObservableList<String> modelList = FXCollections.observableArrayList("Integra", "Giulia", "Vantage", "Q5", "Bentayga Hybrid", "X1", "Encore", 
	    "Escalade", "Camaro", "Pacifica", "Charger", "Roma", "500X", "Ranger", "G80", "Terrain", "Civic", "Elantra", "Q60", "XF", "Wrangler", "Sportage", 
	    "Urus", "Range Rover", "GX", "Aviator", "Grecale", "Tribute Hybrid", "720S", "A-Class", "Cooper", "Outlander", "Pathfinder", "Boxster", "ProMaster City", 
	    "Phantom", "Ascent", "Model Y", "Camry", "Tiguan", "XC40");
	 @FXML
	 private ChoiceBox<String> bodyCondition;
	 	final private ObservableList<String> bodyconditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
	 @FXML
	 private ChoiceBox<String> mechCondition;
	     final private ObservableList<String> mechconditionList = FXCollections.observableArrayList("New", "Excellent", "Good", "Average", "Fair", "Poor", "Broken");
	 @FXML
	 private TextField dealershipEntry;
	 @FXML
	 private TextField orderNumber;
	 @FXML
	 private TextField mileageText;
	 @FXML
	 private TextField Year;
	 @FXML
	 private TextField Color;
 	@FXML
    private void initialize() {
        MakeCar.setValue("Select a Make");
        MakeCar.getItems().addAll(makeList);
        
        ModelCar.setValue("Select a Model");
        ModelCar.getItems().addAll(modelList);
        
        bodyCondition.setValue("Select condition");
        bodyCondition.getItems().addAll(bodyconditionList);
        
        mechCondition.setValue("Select condition");
        mechCondition.getItems().addAll(mechconditionList);       
    } // end initialize method
 	
	 public void clear(ActionEvent event) {
		if(event.getSource() == ClearButton) {
			 dealershipEntry.setText("");
			 orderNumber.setText("");
			 Year.setText("");
			 Color.setText("");
			 mileageText.setText("");
		 	 MakeCar.setValue("Select a Make");
		     ModelCar.setValue("Select a Model");
		     bodyCondition.setValue("Select condition");
		     mechCondition.setValue("Select condition");
	 	}
	 }
	
	 public void send(ActionEvent event) throws IOException {
		// After filling information, it goes to the next page,
		 // where different information are filled
		if(event.getSource() == SendButton) {
		 	 Main m = new Main();
			 m.changeScene2("CreateOrderforManufacturer.fxml");
	 	}
	 }
	 
	 public void returnPage(ActionEvent event) throws IOException {
		 // returns back to the main page
		 if(event.getSource() == ReturnButton) {
			 Main m = new Main();
			 m.changeScene1(previousPage);
		 }
	 }
}