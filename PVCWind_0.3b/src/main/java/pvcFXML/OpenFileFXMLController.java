package pvcFXML;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import application.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

/**
 * This is the controller class for OpenFileFXML.fxml
 * 
 * @author a
 *
 */
public class OpenFileFXMLController {

	@FXML
	private Button openButton;

	@FXML
	private Button closeButton;

	@FXML
	private ListView<String> filesListView;

	public ListView<String> getFilesListView() {
		return filesListView;
	}

	@FXML
	void closeWindow(ActionEvent event) {
		filesListView.getItems().removeAll(application.Main.fileList);
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	void openFile(ActionEvent event) {
		application.Main.mainController.refreshGUI();
		// Decode XML
		openXMLFileContainingInstanceOfClassOrder(
				"./saved_orders/" + filesListView.getSelectionModel().getSelectedItem().toString());
		// Show decoded XML contents
		application.Main.mainController.readAndShowOrderContents();
		application.Main.mainController.showResults();
		updateVisualizationOfPricesPerSqMAndLM();
		filesListView.getItems().removeAll(application.Main.fileList);
		// Close dialog window
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	void openXMLFileContainingInstanceOfClassOrder(String file) {
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
			application.Main.order = (Order) dec.readObject();
			dec.close();
		} catch (IOException ioe) {
			application.Main.mainController.getInfoText().setText("Възникна грешка при отварянето на файла!");
		}
	}

	void readFileDirectory() {
		File savedFiles = new File("saved_orders");
		application.Main.fileList.addAll(savedFiles.list());
		filesListView.setItems(application.Main.fileList);
		filesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	void updateVisualizationOfPricesPerSqMAndLM() {
		String pricePerLM = Double.toString(application.Main.order.getPricePerLMFrame());
		String pricePerSqM = Double.toString(application.Main.order.getPricePerSqMGlass());
		application.Main.mainController.getFramePriceField().setText(pricePerLM);
		application.Main.mainController.getGlassPriceField().setText(pricePerSqM);
		application.Main.mainController.getMainLevsPerLMText().setText(pricePerLM + " лв./л.м");
		application.Main.mainController.getMainLevsPerSqMText()
				.setText(String.format("%.2f лв./м%c", application.Main.order.getPricePerSqMGlass(), '\u00B2'));
	}

}
