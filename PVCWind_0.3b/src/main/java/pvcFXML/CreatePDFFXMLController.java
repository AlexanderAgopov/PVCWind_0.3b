package pvcFXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This is the controller class for CreatePDFFXML.fxml
 * 
 * @author a
 *
 */

public class CreatePDFFXMLController {

	@FXML
	private TextField pdfTextField;

	@FXML
	private Button createButton;

	@FXML
	private Button cancelButton;

	@FXML
	void cancel(ActionEvent event) {
		closeStage();
	}

	@FXML
	void createPDFDoc(ActionEvent event) {
		application.Main.pdfGenerator.createPDF(pdfTextField.getText(), application.Main.observableList);
		closeStage();
	}

	void closeStage() {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

}
