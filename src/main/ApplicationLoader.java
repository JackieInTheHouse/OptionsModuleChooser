package main;

import controller.OptionsModuleChooserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StudentProfile;
import view.OptionsModuleChooserRootPane;

public class ApplicationLoader extends Application {

	private OptionsModuleChooserRootPane view;
	
	@Override
	public void init() {
		//create model and view and pass their references to the controller
		StudentProfile model = new StudentProfile();
		view = new OptionsModuleChooserRootPane();
		new OptionsModuleChooserController(view, model);	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setMinWidth(530); 
		stage.setMinHeight(500);
		
		
		stage.setTitle("Final Year Module Chooser Tool");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}