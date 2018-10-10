package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pvcFXML.MainFXMLController;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The purpose of this application is to help window and frame manufacturers in
 * managing orders received from clients and partners through the following GUI
 * functionalities: 1) creating new list of items ordered by a client or
 * business partner; 2) storing these lists (orders) in XML files which can be
 * opened later on the same device or another; 3) configuring each item (window
 * or door) in terms of required materials and positioning; 4) calculating the
 * materials required for the creation of each item and for the expedition of
 * the whole order; 5) calculating the price of each item and the price of the
 * whole order; 6) allowing user to create PDF files for representation of
 * orders. The language of the GUI is Bulgarian. This application is created as
 * a study project and is not intended for actual use by real manufacturers, nor
 * is any kind of trade product!
 * 
 * @author a
 *
 */
public class Main extends Application {

	// Create an instance of the MainFXMLController class in order to have access to
	// it from other controller classes
	public static MainFXMLController mainController;

	public static OrderToPDF pdfGenerator = new OrderToPDF();

	// The following observable list holds references to the string representations
	// of
	// objects of classes of type Window which are elements of the instance variable
	// orderList in class Order. This observable list is backing the ListView in
	// class MainFXMLController
	public static ObservableList<String> observableList = FXCollections.observableArrayList();

	// The following observable list holds references to all files contained in the
	// folder
	// "saved_orders" and is backing the ListView in class
	// OpenFileFXMLController
	public static ObservableList<String> fileList = FXCollections.observableArrayList();

	// Create an instance of the MainFXMLController class in order to have access to
	// it from all controller classes
	public static Order order = new Order();

	@Override
	public void start(Stage primaryStage) {

		try {
			FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("/pvcFXML/MainFXML.fxml"));
			Parent root = (Parent) mainFXMLLoader.load();
			mainController = (MainFXMLController) mainFXMLLoader.getController();

			Scene scene = new Scene(root, 960, 600);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
			primaryStage.setMinWidth(960);
			primaryStage.setMinHeight(600);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
