package pvcFXML;

import application.PVCDoor;
import application.PVCWindow;
import application.PVCWindow1With1OpenableWing;
import application.PVCWindow2Unopenable;
import application.PVCWindow2With1OpenableWing;
import application.PVCWindow2With2OpenableWings;
import application.PVCWindow3Unopenable;
import application.PVCWindow3With1OpenableWing;
import application.PVCWindow3With2OpenableWings;
import application.PVCWindow3With3OpenableWings;
import application.PVCWindow4Unopenable;
import application.PVCWindow4With1OpenableWing;
import application.PVCWindow4With2OpenableWings;
import application.PVCWindow4With3OpenableWings;
import application.PVCWindow4With4OpenableWings;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This is the controller class for MainFXML.fxml.
 * 
 * @author a
 *
 */

public class MainFXMLController {

	@FXML
	private TextField glassPriceField;

	@FXML
	private TextField framePriceField;

	@FXML
	private Button glassPriceButton;

	@FXML
	private Button framePriceButton;

	@FXML
	private MenuItem newOrderMenuItem;

	@FXML
	private MenuItem openMenuItem;

	@FXML
	private MenuItem saveAsMenuItem;

	@FXML
	private MenuItem createPDFMenuItem;

	@FXML
	private MenuItem closeMenuItem;

	@FXML
	private MenuItem doorMenuItem;

	@FXML
	private MenuItem window1_UnopenableMenuItem;

	@FXML
	private MenuItem window1_OpenableMenuItem;

	@FXML
	private MenuItem window2_UnopenableHorizontalMenuiItem;

	@FXML
	private MenuItem window2_UnopenableVerticalMenuiItem;

	@FXML
	private MenuItem window2_1Of2OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window2_1Of2OpenableVerticalMenuItem;

	@FXML
	private MenuItem window2_2Of2OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window2_2Of2OpenableVerticalMenuItem;

	@FXML
	private MenuItem window3_UnopenableHorizontalMenuItem;

	@FXML
	private MenuItem window3_UnopenableVerticalMenuItem;

	@FXML
	private MenuItem window3_1Of3OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window3_1Of3OpenableVerticalMenuItem;

	@FXML
	private MenuItem window3_2Of3OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window3_2Of3OpenableVerticalMenuItem;

	@FXML
	private MenuItem window3_3Of3OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window3_3Of3OpenableVerticalMenuItem;

	@FXML
	private MenuItem window4_UnopenableHorizontalMenuItem;

	@FXML
	private MenuItem window4_UnopenableVerticalMenuItem;

	@FXML
	private MenuItem window4_1Of4OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window4_1Of4OpenableVerticalMenuItem;

	@FXML
	private MenuItem window4_2Of4OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window4_2Of4OpenableVerticalMenuItem;

	@FXML
	private MenuItem window4_3Of4OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window4_3Of4OpenableVerticalMenuItem;

	@FXML
	private MenuItem window4_4Of4OpenableHorizontalMenuItem;

	@FXML
	private MenuItem window4_4Of4OpenableVerticalMenuItem;

	@FXML
	private MenuItem deleteMenuiItem;

	@FXML
	private MenuItem deleteAllMenuItem;

	@FXML
	private Text mainLevsPerSqMText;

	@FXML
	private Text mainLevsPerLMText;

	@FXML
	private Text totalSqMGlassText;

	@FXML
	private Text totalLMFrameText;

	@FXML
	private Text totalGlassPriceText;

	@FXML
	private Text totalFramePriceText;

	@FXML
	private Text finalPriceText;

	@FXML
	private Button orderCalculationButton;

	@FXML
	private ListView<String> orderListView;

	@FXML
	private AnchorPane pvcWindowPropertiesPane;

	@FXML
	private Text infoText;

	@FXML
	private AnchorPane pvcWindowDimensionsPane;

	@FXML
	private TextField fullWidthTF;

	@FXML
	private TextField fullHeightTF;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	@FXML
	private AnchorPane wing1Pane;

	@FXML
	private TextField wing1WidthTF;

	@FXML
	private TextField wing1HeightTF;

	@FXML
	private AnchorPane wing2Pane;

	@FXML
	private TextField wing2WidthTF;

	@FXML
	private TextField wing2HeightTF;

	@FXML
	private AnchorPane wing3Pane;

	@FXML
	private TextField wing3WidthTF;

	@FXML
	private TextField wing3HeightTF;

	@FXML
	private AnchorPane wing4Pane;

	@FXML
	private TextField wing4WidthTF;

	@FXML
	private TextField wing4HeightTF;

	// Create a variable the value of which determines what kind of window
	// configuration area would be invoked in the GUI by user.
	static int windowVariantChoice = 0;

	public Text getInfoText() {
		return infoText;
	}

	public void setInfoText(Text infoText) {
		this.infoText = infoText;
	}

	public TextField getGlassPriceField() {
		return glassPriceField;
	}

	public TextField getFramePriceField() {
		return framePriceField;
	}

	public Text getMainLevsPerSqMText() {
		return mainLevsPerSqMText;
	}

	public Text getMainLevsPerLMText() {
		return mainLevsPerLMText;
	}

	@FXML
	void createNewOrder(ActionEvent event) {
		resetDataForMoneyPerSqmAndLM();
		deleteAllItems();
		infoText.setText("");
		showResults();

	}

	@FXML
	void openFile(ActionEvent event) {
		// Open the dialog window containing information about saved orders
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pvcFXML/OpenFileFXML.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			OpenFileFXMLController openFileController = fxmlLoader.<OpenFileFXMLController>getController();
			openFileController.readFileDirectory();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void saveOrderAs(ActionEvent event) {
		loadFXML("/pvcFXML/SaveAsFXML.fxml");
	}

	@FXML
	void createPDFDoc(ActionEvent event) {
		loadFXML("/pvcFXML/CreatePDFFXML.fxml");
	}

	@FXML
	void exitProgram(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void inputFramePrice(ActionEvent event) {
		infoText.setText("");
		try {
			application.Main.order.setPricePerLMFrame(Double.parseDouble(framePriceField.getText()));
			mainLevsPerLMText.setText(framePriceField.getText() + " лв./л.м");
		} catch (NumberFormatException nfe) {
			infoText.setText("Грешка! Опитвате се да въведете невалидни данни. Моля опитайте отново.");
		}
		// Delete the following lines if you want to allow users to create orders
		// that include items based on different types of frame with different price per
		// linear meter
		for (PVCWindow w : application.Main.order.getOrderList()) {
			calculateThisWindowPrice(w);
		}
		calculateTotalValues();
		orderListView.getItems().removeAll(application.Main.observableList);
		readAndShowOrderContents();
		showResults();
	}

	@FXML
	void inputGlassPrice(ActionEvent event) {
		infoText.setText("");
		try {
			application.Main.order.setPricePerSqMGlass(Double.parseDouble(glassPriceField.getText()));
			mainLevsPerSqMText.setText(String.format("%s лв./м%c", glassPriceField.getText(), '\u00B2'));
		} catch (NumberFormatException nfe) {
			infoText.setText("Грешка! Опитвате се да въведете невалидни данни. Моля опитайте отново.");
		}
		// Delete the following lines if users should be allowed to create orders
		// that include items based on different types of glass with different price per
		// square meter
		for (PVCWindow w : application.Main.order.getOrderList()) {
			calculateThisWindowPrice(w);
		}
		calculateTotalValues();
		orderListView.getItems().removeAll(application.Main.observableList);
		readAndShowOrderContents();
		showResults();
	}

	public ListView<String> getOrderListView() {
		if (orderListView == null) {
			orderListView = new ListView<String>();
		}
		return orderListView;
	}

	@FXML
	void openConfigurationPaneForDoor(ActionEvent event) {
		showUnopenableWindowConfiguration(0);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow1(ActionEvent event) {
		showUnopenableWindowConfiguration(100);
	}

	@FXML
	void openConfigurationPaneForWindow1With1OpenableWing(ActionEvent event) {
		resetWindowConfiguration();
		openConfigurationPane_1_OpenableWing();
		windowVariantChoice = 110;
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow2Horizontal(ActionEvent event) {
		showUnopenableWindowConfiguration(201);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow2Vertical(ActionEvent event) {
		showUnopenableWindowConfiguration(200);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow3Horizontal(ActionEvent event) {
		showUnopenableWindowConfiguration(301);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow3Vertical(ActionEvent event) {
		showUnopenableWindowConfiguration(300);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow4Horizontal(ActionEvent event) {
		showUnopenableWindowConfiguration(401);
	}

	@FXML
	void openConfigurationPaneForUnopenableWindow4Vertical(ActionEvent event) {
		showUnopenableWindowConfiguration(400);
	}

	@FXML
	void openConfigurationPaneForWindow2With1OpenableWingHorizontal(ActionEvent event) {
		showOneOpenableWingConfiguration(211);
	}

	@FXML
	void openConfigurationPaneForWindow2With1OpenableWingVertical(ActionEvent event) {
		showOneOpenableWingConfiguration(210);
	}

	@FXML
	void openConfigurationPaneForWindow2With2OpenableWingsHorizontal(ActionEvent event) {
		showTwoOpenableWingsConfiguration(221);
	}

	@FXML
	void openConfigurationPaneForWindow2With2OpenableWingsVertical(ActionEvent event) {
		showTwoOpenableWingsConfiguration(220);
	}

	@FXML
	void openConfigurationPaneForWindow3With1OpenableWingHorizontal(ActionEvent event) {
		showOneOpenableWingConfiguration(311);
	}

	@FXML
	void openConfigurationPaneForWindow3With1OpenableWingVertical(ActionEvent event) {
		showOneOpenableWingConfiguration(310);
	}

	@FXML
	void openConfigurationPaneForWindow3With2OpenableWingsHorizontal(ActionEvent event) {
		showTwoOpenableWingsConfiguration(321);
	}

	@FXML
	void openConfigurationPaneForWindow3With2OpenableWingsVertical(ActionEvent event) {
		showTwoOpenableWingsConfiguration(320);
	}

	@FXML
	void openConfigurationPaneForWindow3With3OpenableWingsHorizontal(ActionEvent event) {
		showThreeOpenableWingsConfiguration(331);
	}

	@FXML
	void openConfigurationPaneForWindow3With3OpenableWingsVertical(ActionEvent event) {
		showThreeOpenableWingsConfiguration(330);
	}

	@FXML
	void openConfigurationPaneForWindow4With1OpenableWingHorizontal(ActionEvent event) {
		showOneOpenableWingConfiguration(411);
	}

	@FXML
	void openConfigurationPaneForWindow4With1OpenableWingVertical(ActionEvent event) {
		showOneOpenableWingConfiguration(410);
	}

	@FXML
	void openConfigurationPaneForWindow4With2OpenableWingsHorizontal(ActionEvent event) {
		showTwoOpenableWingsConfiguration(421);
	}

	@FXML
	void openConfigurationPaneForWindow4With2OpenableWingsVertical(ActionEvent event) {
		showTwoOpenableWingsConfiguration(420);
	}

	@FXML
	void openConfigurationPaneForWindow4With3OpenableWingsHorizontal(ActionEvent event) {
		showThreeOpenableWingsConfiguration(431);
	}

	@FXML
	void openConfigurationPaneForWindow4With3OpenableWingsVertical(ActionEvent event) {
		showThreeOpenableWingsConfiguration(430);
	}

	@FXML
	void openConfigurationPaneForWindow4With4OpenableWingsHorizontal(ActionEvent event) {
		showFourOpenableWingsConfiguration(441);
	}

	@FXML
	void openConfigurationPaneForWindow4With4OpenableWingsVertical(ActionEvent event) {
		showFourOpenableWingsConfiguration(440);
	}

	@FXML
	void acceptPVCWindowConfiguration(ActionEvent event) {
		application.Main.order.addItem(createNewWindow());
		application.Main.order.getLastItem().setHorizontal(isHorizontal());
		try {
			calculateWindowGlassAndFrame(application.Main.order.getLastItem());
			calculateThisWindowPrice(application.Main.order.getLastItem());
			int t = application.Main.order.getOrderList().size();
			String temp = t + ". " + application.Main.order.getLastItem().toString();
			application.Main.observableList.add(temp);
			orderListView.setItems(application.Main.observableList);
			orderListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			refreshGUI();
		} catch (NumberFormatException nfe) {
			infoText.setText("Грешка! Опитвате се да въведете невалидни данни. Моля опитайте отново.");
		}

	}

	@FXML
	void AbortPVCWindowConfiguration(ActionEvent event) {
		resetWindowConfiguration();
	}

	@FXML
	void deleteSelected(ActionEvent event) {
		// OBSERVABLE LIST AS A FIELD IN CLASS ORDER, WITHOUT ARRAYLIST AND WITHOUT
		// NUMBERS OF CELLS IN LISTVIEW ???
		int position = extractNumberFromString(orderListView.getSelectionModel().getSelectedItem().substring(0, 3));
		// the number used as an ending index of the substring (i.e. 3) will work for up
		// to 999
		// order items
		application.Main.order.getOrderList().remove(position - 1);
		orderListView.getItems().removeAll(application.Main.observableList);
		readAndShowOrderContents();
	}

	@FXML
	void deleteAll(ActionEvent event) {
		deleteAllItems();
	}

	@FXML
	void calculateOrder(ActionEvent event) {
		try {
			calculateTotalValues();
			showResults();
		} catch (NullPointerException npe) {
			infoText.setText("Заявката е празна! Моля добавете артикул.");
		}

	}

	void openConfigurationUnopenableWindow() {
		pvcWindowDimensionsPane.setVisible(true);
	}

	void openConfigurationPane_1_OpenableWing() {
		pvcWindowDimensionsPane.setVisible(true);
		wing1Pane.setVisible(true);
	}

	void openConfigurationPane_2_OpenableWings() {
		pvcWindowDimensionsPane.setVisible(true);
		wing1Pane.setVisible(true);
		wing2Pane.setVisible(true);
	}

	void openConfigurationPane_3_OpenableWings() {
		pvcWindowDimensionsPane.setVisible(true);
		wing1Pane.setVisible(true);
		wing2Pane.setVisible(true);
		wing3Pane.setVisible(true);
	}

	void openConfigurationPane_4_OpenableWings() {
		pvcWindowDimensionsPane.setVisible(true);
		wing1Pane.setVisible(true);
		wing2Pane.setVisible(true);
		wing3Pane.setVisible(true);
		wing4Pane.setVisible(true);
	}

	void resetWindowConfiguration() {
		// Hide all elements in the PVC window configuration area of the GUI.
		pvcWindowDimensionsPane.setVisible(false);
		wing1Pane.setVisible(false);
		wing2Pane.setVisible(false);
		wing3Pane.setVisible(false);
		wing4Pane.setVisible(false);
		// Reset all text fields used in the PVC window configuration area of the GUI.
		wing1WidthTF.setVisible(true);
		wing2WidthTF.setVisible(true);
		wing3WidthTF.setVisible(true);
		wing4WidthTF.setVisible(true);
		wing1HeightTF.setVisible(true);
		wing2HeightTF.setVisible(true);
		wing3HeightTF.setVisible(true);
		wing4HeightTF.setVisible(true);
		fullWidthTF.setText("0");
		fullHeightTF.setText("0");
		wing1WidthTF.setText("0");
		wing2WidthTF.setText("0");
		wing3WidthTF.setText("0");
		wing4WidthTF.setText("0");
		wing1HeightTF.setText("0");
		wing2HeightTF.setText("0");
		wing3HeightTF.setText("0");
		wing4HeightTF.setText("0");
		infoText.setText("");
	}

	void banInputIntoUnusedTextFieldsInWindowConfigurationArea(int windowVariantChoice) {
		if (windowVariantChoice % 2 == 1) {
			wing1HeightTF.setVisible(false);
			wing2HeightTF.setVisible(false);
			wing3HeightTF.setVisible(false);
			wing4HeightTF.setVisible(false);
			wing1WidthTF.setVisible(true);
			wing2WidthTF.setVisible(true);
			wing3WidthTF.setVisible(true);
			wing4WidthTF.setVisible(true);
		} else {
			wing1WidthTF.setVisible(false);
			wing2WidthTF.setVisible(false);
			wing3WidthTF.setVisible(false);
			wing4WidthTF.setVisible(false);
			wing1HeightTF.setVisible(true);
			wing2HeightTF.setVisible(true);
			wing3HeightTF.setVisible(true);
			wing4HeightTF.setVisible(true);
		}
	}

	void allowInputIntoAllTextFieldsInWindowConfigurationArea() {
		wing1HeightTF.setEditable(true);
		wing2HeightTF.setEditable(true);
		wing3HeightTF.setEditable(true);
		wing4HeightTF.setEditable(true);
		wing1WidthTF.setEditable(true);
		wing2WidthTF.setEditable(true);
		wing3WidthTF.setEditable(true);
		wing4WidthTF.setEditable(true);
	}

	String printInformationAccordingToSelectedWindowCode() {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		if (windowVariantChoice < 200) {
			if (windowVariantChoice == 100) {
				return "В момента въвеждате данни за прозорец с 1 крило, неотваряем.";
			}
			if (windowVariantChoice == 110) {
				return "В момента въвеждате данни за прозорец с 1 крило, отваряем.";
			}
			return "В момента въвеждате данни за врата.";
		} else {
			n3 = windowVariantChoice % 10;
			n2 = ((windowVariantChoice - n3) / 10) % 10;
			n1 = (windowVariantChoice - 10 * n2 - n3) / 100;
			return String.format("В момента въвеждате данни за:\n%s %s %s", printWindowType(n1),
					printNumberOfOpenableWings(n2), printWindowPosition(n3));
		}
	}

	String printWindowType(int n1) {
		switch (n1) {
		case 0:
			return "Врата";
		case 1:
			return "Прозорец - 1 крило,";
		case 2:
			return "Прозорец - 2 крила,";
		case 3:
			return "Прозорец - 3 крила,";
		case 4:
			return "Прозорец - 4 крила,";
		default:
			return "";
		}
	}

	String printNumberOfOpenableWings(int n2) {
		switch (n2) {
		case 0:
			return "неотваряем";
		case 1:
			return "с 1 отваряемо крило";
		case 2:
			return "с 2 отваряеми крила";
		case 3:
			return "с 3 отваряеми крила";
		case 4:
			return "с 4 отваряеми крила";
		default:
			return "";
		}
	}

	String printWindowPosition(int n3) {
		switch (n3) {
		case 0:
			return ", вертикално разположение.";
		case 1:
			return ", хоризонтално разположение.";
		default:
			return "";
		}
	}

	void showUnopenableWindowConfiguration(int windowChoice) {
		resetWindowConfiguration();
		openConfigurationUnopenableWindow();
		windowVariantChoice = windowChoice;
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	void showOneOpenableWingConfiguration(int windowChoice) {
		resetWindowConfiguration();
		openConfigurationPane_1_OpenableWing();
		windowVariantChoice = windowChoice;
		banInputIntoUnusedTextFieldsInWindowConfigurationArea(windowVariantChoice);
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	void showTwoOpenableWingsConfiguration(int windowChoice) {
		resetWindowConfiguration();
		openConfigurationPane_2_OpenableWings();
		windowVariantChoice = windowChoice;
		banInputIntoUnusedTextFieldsInWindowConfigurationArea(windowVariantChoice);
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	void showThreeOpenableWingsConfiguration(int windowChoice) {
		resetWindowConfiguration();
		openConfigurationPane_3_OpenableWings();
		windowVariantChoice = windowChoice;
		banInputIntoUnusedTextFieldsInWindowConfigurationArea(windowVariantChoice);
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	void showFourOpenableWingsConfiguration(int windowChoice) {
		resetWindowConfiguration();
		openConfigurationPane_4_OpenableWings();
		windowVariantChoice = windowChoice;
		banInputIntoUnusedTextFieldsInWindowConfigurationArea(windowVariantChoice);
		infoText.setText(printInformationAccordingToSelectedWindowCode());
	}

	/**
	 * Calculates the square meters of glass and linear meters of frame needed for
	 * the production of given window or door.
	 * 
	 * @param win - an instance of class PVCWindow or its child classes
	 */
	void calculateWindowGlassAndFrame(PVCWindow win) throws NumberFormatException {
		// Read from text fields and set the instance variables
		win.setWidth(Double.parseDouble(fullWidthTF.getText()));
		win.setHeight(Double.parseDouble(fullHeightTF.getText()));
		win.setWing1Width(Double.parseDouble(wing1WidthTF.getText()));
		win.setWing1Height(Double.parseDouble(wing1HeightTF.getText()));
		win.setWing2Width(Double.parseDouble(wing2WidthTF.getText()));
		win.setWing2Height(Double.parseDouble(wing2HeightTF.getText()));
		win.setWing3Width(Double.parseDouble(wing3WidthTF.getText()));
		win.setWing3Height(Double.parseDouble(wing3HeightTF.getText()));
		win.setWing4Width(Double.parseDouble(wing4WidthTF.getText()));
		win.setWing4Height(Double.parseDouble(wing4HeightTF.getText()));
		win.setSqCmGlass(win.calculateSqCmGlass());
		win.setLCmFrame(win.calculateLCmFrame());
	}

	/**
	 * Calculates the price of given window or door
	 * 
	 * @param win - an instance of class PVCWindow or its child classes
	 */
	void calculateThisWindowPrice(PVCWindow win) throws NumberFormatException {
		double thisWindowPrice = win.calculateWindowPrice(application.Main.order.getPricePerSqMGlass(),
				application.Main.order.getPricePerLMFrame());
		win.setWindowPrice(thisWindowPrice);
	}

	PVCWindow createNewWindow() {
		switch (windowVariantChoice) {
		case 0:
			return new PVCDoor();
		case 100:
			return new PVCWindow();
		case 110:
			return new PVCWindow1With1OpenableWing();
		case 201:
			return new PVCWindow2Unopenable();
		case 200:
			return new PVCWindow2Unopenable();
		case 211:
			return new PVCWindow2With1OpenableWing();
		case 210:
			return new PVCWindow2With1OpenableWing();
		case 221:
			return new PVCWindow2With2OpenableWings();
		case 220:
			return new PVCWindow2With2OpenableWings();
		case 301:
			return new PVCWindow3Unopenable();
		case 300:
			return new PVCWindow3Unopenable();
		case 311:
			return new PVCWindow3With1OpenableWing();
		case 310:
			return new PVCWindow3With1OpenableWing();
		case 321:
			return new PVCWindow3With2OpenableWings();
		case 320:
			return new PVCWindow3With2OpenableWings();
		case 331:
			return new PVCWindow3With3OpenableWings();
		case 330:
			return new PVCWindow3With3OpenableWings();
		case 401:
			return new PVCWindow4Unopenable();
		case 400:
			return new PVCWindow4Unopenable();
		case 411:
			return new PVCWindow4With1OpenableWing();
		case 410:
			return new PVCWindow4With1OpenableWing();
		case 421:
			return new PVCWindow4With2OpenableWings();
		case 420:
			return new PVCWindow4With2OpenableWings();
		case 431:
			return new PVCWindow4With3OpenableWings();
		case 430:
			return new PVCWindow4With3OpenableWings();
		case 441:
			return new PVCWindow4With4OpenableWings();
		case 440:
			return new PVCWindow4With4OpenableWings();
		default:
			return null;
		}
	}

	/**
	 * Returns true if the user has chosen to create a window with horizontal
	 * position.
	 * 
	 * @return true if the user has chosen to create a window with horizontal
	 *         position
	 */
	boolean isHorizontal() {
		switch (windowVariantChoice) {
		case 201:
			return true;
		case 200:
			return false;
		case 211:
			return true;
		case 210:
			return false;
		case 221:
			return true;
		case 220:
			return false;
		case 301:
			return true;
		case 300:
			return false;
		case 311:
			return true;
		case 310:
			return false;
		case 321:
			return true;
		case 320:
			return false;
		case 331:
			return true;
		case 330:
			return false;
		case 401:
			return true;
		case 400:
			return false;
		case 411:
			return true;
		case 410:
			return false;
		case 421:
			return true;
		case 420:
			return false;
		case 431:
			return true;
		case 430:
			return false;
		case 441:
			return true;
		case 440:
			return false;
		default:
			return false;
		}
	}

	void calculateTotalValues() {
		application.Main.order.setTotalSqMGlass(application.Main.order.calculateTotalSqMGlass());
		application.Main.order.setTotalLMFrame(application.Main.order.calculateTotalLMFrame());
		application.Main.order.setTotalPriceGlass(application.Main.order.calculateTotalPriceGlass());
		application.Main.order.setTotalPriceFrame(application.Main.order.calculateTotalPriceFrame());
		application.Main.order.setTotalPriceOrder(application.Main.order.calculateTotalPriceOrder());
	}

	void showResults() {
		totalSqMGlassText.setText(String.format("%.3f м%c", application.Main.order.getTotalSqMGlass(), '\u00B2'));
		totalLMFrameText.setText(String.format("%.2f л.м", application.Main.order.getTotalLMFrame()));
		totalGlassPriceText.setText(String.format("%.2f лв.", application.Main.order.getTotalPriceGlass()));
		totalFramePriceText.setText(String.format("%.2f лв.", application.Main.order.getTotalPriceFrame()));
		finalPriceText.setText(String.format("%.2f лв.", application.Main.order.getTotalPriceOrder()));
	}

	int extractNumberFromString(String sourceString) {
		String temp1 = sourceString;
		String[] temp = temp1.split("\\D+");
		String temp2 = "";
		for (String t : temp) {
			temp2 = temp2 + t;
		}
		return Integer.parseInt(temp2);
	}

	void readAndShowOrderContents() {
		for (int i = 0; i < application.Main.order.getOrderList().size(); i++) {
			// Create string with item indexing starting from 1
			String temp = (i + 1) + ". " + application.Main.order.getOrderList().get(i).toString();
			application.Main.observableList.add(i, temp);
		}
		orderListView.setItems(application.Main.observableList);
		calculateTotalValues();
		showResults();
	}

	void deleteAllItems() {
		application.Main.order.getOrderList().removeAll(application.Main.order.getOrderList());
		orderListView.getItems().removeAll(application.Main.observableList);
		application.Main.observableList.removeAll(application.Main.observableList);
		calculateTotalValues();
		showResults();
	}

	void resetDataForMoneyPerSqmAndLM() {
		application.Main.order.setPricePerSqMGlass(0);
		application.Main.order.setPricePerLMFrame(0);
		glassPriceField.setText("");
		framePriceField.setText("");
		mainLevsPerSqMText
				.setText(String.format("%.2f лв./м%c", application.Main.order.getPricePerSqMGlass(), '\u00B2'));
		mainLevsPerLMText.setText(application.Main.order.getPricePerLMFrame() + " лв./л.м");
	}
	
	void refreshGUI() {
		allowInputIntoAllTextFieldsInWindowConfigurationArea();
		resetWindowConfiguration();
		windowVariantChoice = 0;
		calculateTotalValues();
		showResults();
	}

	void loadFXML(String fxmlFilePath) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFilePath));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
