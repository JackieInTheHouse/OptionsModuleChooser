package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class OptionsModuleChooserRootPane extends BorderPane{

	private ProfilePane pp;
	private ModulesPane mp;
	private OverviewPane op;
	private ModuleChooserMenuBar mcmb;
	private TabPane containerPane;
	
	public OptionsModuleChooserRootPane() {
		pp = new ProfilePane();
		mp = new ModulesPane();
		op = new OverviewPane();
		mcmb = new ModuleChooserMenuBar();
		
		
	    containerPane = new TabPane();
		Tab t1 = new Tab("Create Profile",pp);
		Tab t2 = new Tab("Select Modules",mp);
		Tab t3 = new Tab("Overview Selection",op);
		
		containerPane.getTabs().addAll(t1,t2,t3);
		containerPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setTop(mcmb);
		this.setCenter(containerPane );
	}
	
	
	/*Create public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the controller. */
	public ProfilePane getProfilePane() {
		return pp;
	}
	public ModulesPane getModulesPane() {
		return mp;
	}
	public OverviewPane getOverviewPane() {
		return op;
	}
	public ModuleChooserMenuBar getModuleChooserMenuBar(){
		return mcmb;
	}
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		containerPane.getSelectionModel().select(index);
	}
}
