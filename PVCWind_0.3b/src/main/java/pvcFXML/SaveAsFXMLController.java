package pvcFXML;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This is the controller class for SaveAsFXML.fxml.
 * 
 * @author a
 *
 */
public class SaveAsFXMLController {

	@FXML
	private TextField fileNameTextField;

	@FXML
	private Button saveButton;

	@FXML
	private Button cancelButton;

	@FXML
	void cancel(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	void save(ActionEvent event) {
		String fileName = fileNameTextField.getText();
		currentOrderToXMLFile(fileName);
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

	void currentOrderToXMLFile(String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("./saved_orders/" + fileName + ".xml"));
			XMLEncoder e = new XMLEncoder(new BufferedOutputStream(fos));
			e.writeObject(application.Main.order);
			e.close();

			fos.close();
		} catch (IOException ioe) {
			fileNameTextField.setText("Възникна грешка при запазването на поръчката във файл!");
		}
	}

}
