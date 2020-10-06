package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Module;


public class ModulesPane extends VBox{
	
	private Label lbUnsTerm1Modules, lbUnsTerm2Modules, lbTerm1, lbTerm2, lbYearLongModules, lbSTerm1Modules, lbSTerm2Modules, lbCredit1, lbCredit2;
	private TextField tfTerm1Credits, tfTerm2Credits;
	private ListView<Module> lvUnsTerm1Modules, lvUnsTerm2Modules, lvYearModules, lvSTerm1Modules, lvSTerm2Modules;
	private Button add1, remove1, add2, remove2, reset, submit;
	private ObservableList<Module> unselectedTerm1ModulesList, unselectedTerm2ModulesList, selectedTerm1ModulesList, selectedTerm2ModulesList, yearLongModuleList;


	public ModulesPane() {
		
		this.setPadding(new Insets(20,20,20,20));
		
		//Initialised the ObservableList<Module> lists from field and pass them into the each list view. 
		unselectedTerm1ModulesList = FXCollections.observableArrayList();
		unselectedTerm2ModulesList = FXCollections.observableArrayList();
		selectedTerm1ModulesList = FXCollections.observableArrayList();
		selectedTerm2ModulesList = FXCollections.observableArrayList();
	    yearLongModuleList = FXCollections.observableArrayList();
	    
	    
        //put unselected term1 modules label and list view into a VBox
		VBox vbox1 = new VBox();
		lbUnsTerm1Modules = new Label("Unselected Term 1 modules");
		lvUnsTerm1Modules = new ListView<Module>(unselectedTerm1ModulesList);
		lvUnsTerm1Modules.setPrefSize(300,75);
		vbox1.getChildren().addAll(lbUnsTerm1Modules,lvUnsTerm1Modules);
		
		//put term1 label, add1 and remove1 buttons into a HBox
		lbTerm1 = new Label("Term 1");
		add1 = new Button("Add");
		remove1 = new Button("Remove");
		HBox hbox1 = new HBox();
		hbox1.setSpacing(10);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(lbTerm1,add1,remove1);
		
		//put unselected term2 modules label and list view into a VBox
		VBox vbox2 = new VBox();
		lbUnsTerm2Modules = new Label("Unselected Term 2 modules");
		lvUnsTerm2Modules = new ListView<Module>(unselectedTerm2ModulesList);
		lvUnsTerm2Modules.setPrefSize(300,75);
		vbox2.getChildren().addAll(lbUnsTerm2Modules, lvUnsTerm2Modules);
		
		//put term2 label, add2 and remove2 buttons into a HBox
		lbTerm2 = new Label("Term 2");
		add2 = new Button("Add");
		remove2 = new Button("Remove");
		HBox hbox2 = new HBox();
		hbox2.setSpacing(10);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.getChildren().addAll(lbTerm2,add2,remove2);
		
		//put term 1 credits label and text filed into a HBox
		lbCredit1 = new Label("Current term 1 credits:");
		tfTerm1Credits = new TextField();
		tfTerm1Credits.setPrefSize(50, 20);
		HBox hbox3 = new HBox();
		hbox3.setSpacing(10);
		hbox3.setAlignment(Pos.CENTER);
		hbox3.getChildren().addAll(lbCredit1,tfTerm1Credits);
		
		//put above elements into a VBox
		VBox leftBox = new VBox(20,vbox1,hbox1,vbox2,hbox2,hbox3);

		
		//put year long modules label and list view into a VBox
		VBox vbox3 = new VBox();
		lbYearLongModules = new Label("Selected Year Long modules");
		lvYearModules = new ListView<Module>(yearLongModuleList);
		lvYearModules.setPrefSize(300,45);
		vbox3.getChildren().addAll(lbYearLongModules,lvYearModules);
		
		//put selected term1 modules label and list view into a VBox
		VBox vbox4 = new VBox();
		lbSTerm1Modules = new Label("Selected Term 1 modules");
		lvSTerm1Modules = new ListView<Module>( selectedTerm1ModulesList);
		lvSTerm1Modules.setPrefSize(300,75);
		vbox4.getChildren().addAll(lbSTerm1Modules,lvSTerm1Modules);
		
		//put selected term1 modules label and list view into a VBox
		VBox vbox5 = new VBox();
		lbSTerm2Modules = new Label("Selected Term 2 modules");
		lvSTerm2Modules = new ListView<Module>( selectedTerm2ModulesList);
		lvSTerm2Modules.setPrefSize(300,75);
		vbox5.getChildren().addAll(lbSTerm2Modules,lvSTerm2Modules);
		
		//put term2 credits label and text field into a HBox
		lbCredit2 = new Label("Current term 2 credits:");
		tfTerm2Credits = new TextField();
		tfTerm2Credits.setPrefSize(50, 20);
		HBox hbox4 = new HBox();
		hbox4.setSpacing(10);
		hbox4.setAlignment(Pos.CENTER);
		hbox4.getChildren().addAll(lbCredit2,tfTerm2Credits);
		
		//put another above elements into a VBox
		VBox rightBox = new VBox(20,vbox3,vbox4,vbox5,hbox4);
		
		//put above two main VBox into a HBox
		HBox rootBox = new HBox(20,leftBox,rightBox);
		
		
		//put reset and submit buttons into a HBox
		HBox hbox5 = new HBox(20);
		reset = new Button("Reset");
		submit = new Button("Submit");
		hbox5.getChildren().addAll(reset,submit);
		hbox5.setAlignment(Pos.CENTER);
		
		
		
		this.getChildren().addAll(rootBox,hbox5);
		this.setSpacing(20);
		
		HBox.setHgrow(leftBox,Priority.ALWAYS);
		HBox.setHgrow(rightBox,Priority.ALWAYS);
		VBox.setVgrow(rootBox, Priority.ALWAYS);
	    VBox.setVgrow(lvUnsTerm1Modules,Priority.ALWAYS);
	    VBox.setVgrow(lvUnsTerm2Modules,Priority.ALWAYS);
	    VBox.setVgrow(lvYearModules,Priority.ALWAYS);
	    VBox.setVgrow(lvSTerm1Modules,Priority.ALWAYS);
	    VBox.setVgrow(lvSTerm2Modules,Priority.ALWAYS);
		VBox.setVgrow(vbox1,Priority.ALWAYS);
		VBox.setVgrow(vbox2,Priority.ALWAYS);
		VBox.setVgrow(vbox3,Priority.ALWAYS);
		VBox.setVgrow(vbox4,Priority.ALWAYS);
		VBox.setVgrow(vbox5,Priority.ALWAYS);
		
	}
	
	
	
	//public interface for this pane
	
	
	public void addUnselectedTerm1Modules(Module m) {
		 unselectedTerm1ModulesList.add(m);
	}
	
	public ListView<Module> getUnSelectedTerm1Modules(){
		return lvUnsTerm1Modules;
	}
	
	public ObservableList<Module> getUnsTerm1ModulesList(){
		return unselectedTerm1ModulesList;
	}
	
	public void addUnselectedTerm2Modules(Module m) {
		unselectedTerm2ModulesList.add(m);
	}
	
	public ListView<Module> getUnSelectedTerm2Modules(){
		return lvUnsTerm2Modules;
	}
	
	public ObservableList<Module> getUnseTerm2ModulesList(){
		return unselectedTerm2ModulesList;
	}
	
	public void addSelectedTerm1Modules(Module m){
		selectedTerm1ModulesList.add(m);
	}
	
	public ListView<Module> getSelectedTerm1Modules(){
		return lvSTerm1Modules;
	}
	
	public ObservableList<Module> getSTerm1ModulesList(){
		return selectedTerm1ModulesList;
	}
	
	public void addSelectedTerm2Modules(Module m) {
		selectedTerm2ModulesList.add(m);
	}
	
	public ListView<Module> getSelectedTerm2Modules(){
		return lvSTerm2Modules;
	}
	
	public ObservableList<Module> getSTerm2ModulesList(){
		return selectedTerm2ModulesList;
	}
	
	public void addYearLongModule(Module m) {
		yearLongModuleList.add(m);
	}
	
	public ListView<Module> getYearLongModule(){
		return lvYearModules;
	}
	
	public ObservableList<Module> getYearModuleList(){
		return yearLongModuleList;
	}
	
	public TextField getTerm1Credits() {
		return tfTerm1Credits;
	}
	
	public TextField getTerm2Credits() {
		return tfTerm2Credits;
	}
	public ObservableList<Module> getAllSelectedModules(){
		ObservableList<Module> modules = lvYearModules.getItems();
		modules.addAll(lvSTerm1Modules.getItems());
		modules.addAll(lvSTerm2Modules.getItems());
		return modules;
	}
	
	
	public void clearListViews() {
		lvUnsTerm1Modules.getItems().clear();
		lvUnsTerm2Modules.getItems().clear();
		lvYearModules.getItems().clear();
		lvSTerm1Modules.getItems().clear();
		lvSTerm2Modules.getItems().clear();
	
	}
	
	public void clearSelection() {
		lvUnsTerm1Modules.getSelectionModel().clearSelection();
		lvUnsTerm2Modules.getSelectionModel().clearSelection();
		lvYearModules.getSelectionModel().clearSelection();
		lvSTerm1Modules.getSelectionModel().clearSelection();
		lvSTerm2Modules.getSelectionModel().clearSelection();
		
	}
	
	
	//create event listener 
	public void addAdd1Listener(EventHandler<ActionEvent> handler) {
		add1.setOnAction(handler);
	}
	public void addRemove1Listener(EventHandler<ActionEvent> handler) {
		remove1.setOnAction(handler);
	}
	public void addAdd2Listener(EventHandler<ActionEvent> handler) {
		add2.setOnAction(handler);
	}
	public void addRemove2Listener(EventHandler<ActionEvent> handler) {
		remove2.setOnAction(handler);
	}
	public void addResetListener(EventHandler<ActionEvent> handler) {
		reset.setOnAction(handler);
	}
	public void addSubmitListener(EventHandler<ActionEvent> handler) {
		submit.setOnAction(handler);
	}
		
}
