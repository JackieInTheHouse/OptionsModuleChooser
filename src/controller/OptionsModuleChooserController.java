package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Course;
import model.Delivery;
import model.Module;
import model.Name;
import model.StudentProfile;
import view.ModuleChooserMenuBar;
import view.ModulesPane;
import view.OptionsModuleChooserRootPane;
import view.OverviewPane;
import view.ProfilePane;



public class OptionsModuleChooserController {

	//fields to be used throughout the class
	private OptionsModuleChooserRootPane view;
	private ProfilePane pp;
	private ModulesPane mp;
	private OverviewPane op;
	private ModuleChooserMenuBar mcmb;

	private StudentProfile model;

	public OptionsModuleChooserController(OptionsModuleChooserRootPane view, StudentProfile model) {
		//initialise model and view fields
		this.model = model;
		this.view = view;
		pp = view.getProfilePane();
		mp = view.getModulesPane();
		op = view.getOverviewPane();
		mcmb = view.getModuleChooserMenuBar();

		//populate combobox in create profile pane, e.g. if profilePane represented your create profile pane you could invoke the line below
		pp.populateComboBoxWithCourses(setupAndRetrieveCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	

	}

	private void attachEventHandlers() {
		pp.addCreateProfileListener(new CreateProfileHandler());
		mp.addAdd1Listener(new Add1Handler());
		mp.addRemove1Listener(new Remove1Handler());
		mp.addAdd2Listener(new Add2Handler());
		mp.addRemove2Listener(new Remove2Handler());
		mp.addResetListener(new ResetHandler());
		mp.addSubmitListener(new SubmitHandler());
		op.addSaveOverViewListener(new SaveOverViewHandler());
		mcmb.addSaveHandler(new SaveMenuHandler());
		mcmb.addLoadHandler(new  LoadMenuHandler());
		mcmb.addExitHandler(e -> System.exit(0));
		mcmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Options mdule chooser tool MVC app v2.0"));
	}

	                
	private Course[] setupAndRetrieveCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Delivery.TERM_1);
		Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true, Delivery.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Delivery.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Delivery.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Delivery.TERM_1);
		Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false, Delivery.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Delivery.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Delivery.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Delivery.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Delivery.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Delivery.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Delivery.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Delivery.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Delivery.TERM_1);
		Module imat3611 = new Module("IMAT3611", "Popular Technology Ethics", 15, false, Delivery.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Delivery.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Delivery.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Delivery.TERM_2);

		Course compSci = new Course("Computer Science");
		compSci.addModuleToCourse(imat3423);
		compSci.addModuleToCourse(imat3451);
		compSci.addModuleToCourse(ctec3902_CompSci);
		compSci.addModuleToCourse(ctec3110);
		compSci.addModuleToCourse(ctec3426);
		compSci.addModuleToCourse(ctec3605);
		compSci.addModuleToCourse(ctec3606);
		compSci.addModuleToCourse(ctec3410);
		compSci.addModuleToCourse(ctec3904);
		compSci.addModuleToCourse(ctec3905);
		compSci.addModuleToCourse(ctec3906);
		compSci.addModuleToCourse(imat3410);
		compSci.addModuleToCourse(imat3406);
		compSci.addModuleToCourse(imat3611);
		compSci.addModuleToCourse(imat3613);
		compSci.addModuleToCourse(imat3614);
		compSci.addModuleToCourse(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModuleToCourse(imat3423);
		softEng.addModuleToCourse(imat3451);
		softEng.addModuleToCourse(ctec3902_SoftEng);
		softEng.addModuleToCourse(ctec3110);
		softEng.addModuleToCourse(ctec3426);
		softEng.addModuleToCourse(ctec3605);
		softEng.addModuleToCourse(ctec3606);
		softEng.addModuleToCourse(ctec3410);
		softEng.addModuleToCourse(ctec3904);
		softEng.addModuleToCourse(ctec3905);
		softEng.addModuleToCourse(ctec3906);
		softEng.addModuleToCourse(imat3410);
		softEng.addModuleToCourse(imat3406);
		softEng.addModuleToCourse(imat3611);
		softEng.addModuleToCourse(imat3613);
		softEng.addModuleToCourse(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}

	
	
	//create profile button handler
	private class CreateProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			model.setCourseOfStudy(pp.getSelectCourseName());
			model.setPnumber(pp.getPNumberInput());
			Name name = new Name(pp.getFNameInput(),pp.getSurnameInput());
			model.setStudentName(name);
			model.setEmail(pp.getEmailInput());
			model.setSubmissionDate(pp.getDateInput());
			
			if(pp.getPNumberInput().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "Enter Error", null, "Please fill in your P number");	
				view.changeTab(0);
			}else if(pp.getFNameInput().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "Enter Error", null, "Please fill in your first name");
			}else if(pp.getSurnameInput().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "Enter Error", null, "Please fill in your surname");
			}else if(pp.getEmailInput().isEmpty()) {
				alertDialogBuilder(AlertType.ERROR, "Enter Error", null, "Please fill in your Email address");
			}else if(pp.getDateInput()== null){
				alertDialogBuilder(AlertType.ERROR, "Enter Error", null, "Please pick a date");
			}else {
			 
				listViews();
				view.changeTab(1);
			}

		}
	}
	

	
	private class Add1Handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Module selectedModule = mp.getUnSelectedTerm1Modules().getSelectionModel().getSelectedItem();
			
			if(selectedModule != null) {
				mp.clearSelection();
				mp.getUnsTerm1ModulesList().remove(selectedModule);
				mp.getSTerm1ModulesList().add(selectedModule);
				getCredits1();
				
				
			}else {
				alertDialogBuilder(AlertType.ERROR, "Selection Error", null, "Please select an item");
			}
		}
	}
	
	private class Remove1Handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Module selectedModule = mp.getSelectedTerm1Modules().getSelectionModel().getSelectedItem();
			
			if(selectedModule != null) {
				mp.clearSelection();
				mp.getSTerm1ModulesList().remove(selectedModule);
				mp.getUnsTerm1ModulesList().add(selectedModule);
				getCredits1();
				
			}else {
				alertDialogBuilder(AlertType.ERROR, "Selection Error", null, "Please select an item");
			}
		}

	}
	
	private class Add2Handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Module selectedModule = mp.getUnSelectedTerm2Modules().getSelectionModel().getSelectedItem();
			
			if(selectedModule != null) {
				mp.clearSelection();
				mp.getUnseTerm2ModulesList().remove(selectedModule);
				mp.getSTerm2ModulesList().add(selectedModule);
				
				getCredits2();
			}else {
				alertDialogBuilder(AlertType.ERROR, "Selection Error", null, "Please select an item");
			}
		}
	}
	
	private class Remove2Handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Module selectedModule = mp.getSelectedTerm2Modules().getSelectionModel().getSelectedItem();
			
			if(selectedModule != null) {
				mp.clearSelection();
				mp.getSTerm2ModulesList().remove(selectedModule);
				mp.getUnseTerm2ModulesList().add(selectedModule);
				
				getCredits2();
			}else {
				alertDialogBuilder(AlertType.ERROR, "Selection Error", null, "Please select an item");
			}
		}
	}
	
	
	private class ResetHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			 
			listViews();
			view.changeTab(1);
		}
	}
	
	private class SubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			
			StringBuilder overview = new StringBuilder( "Name : " + model.getStudentName().getFirstName()+" "+ model.getStudentName().getFamilyName() + "\nP Number : " + model.getPnumber()+"\nEmail : " + model.getEmail()+ "\nDate : " + model.getSubmissionDate() +
					"\nCourse : " + model.getCourseOfStudy() + "\n\nSelected Modules: \n============\n" );



			ObservableList<Module> selectedModules= mp.getAllSelectedModules();
			String modules = "";
			for(Module m: selectedModules)
			{
				model.addToSelectedModules(m);
				modules += "Module Code: "+ m.getModuleCode()+", Module name: "+m.getModuleName();
				modules += "\nCredits: "+ m.getCredits()+", Mandatory on your course? "+(m.isMandatory()?"Yes":"No")+", Delivery: "+m.getRunPlan()+"\n\n";
			}
			op.clearResults();
			op.setResults(overview.toString()+ modules);
			view.changeTab(2);
		}
	}
	
	
	
	//save overview button handler
	private class SaveOverViewHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			String result = op.getResults();
			try (FileWriter oos = new FileWriter("student_info.txt")){
				PrintWriter out = new PrintWriter(oos);
				out.println(result);
				out.close();
				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "student_info.txt");
			} catch (IOException e2) {
				System.out.println("Error saving");
				e2.printStackTrace();
			}
			view.changeTab(0);
			op.clearResults();
			
		}
	}
	
	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentInfoObj.dat"));) {

				oos.writeObject(model);
				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Student infomation saved to StudentInfoObj.dat");
			}
			catch (IOException ioExcep){
				ioExcep.printStackTrace();
				System.out.println("Error saving");
			}
		}
	}
	
	//load handler for menu bar
	private class LoadMenuHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentInfoObj.dat"));) {

				model = (StudentProfile) ois.readObject();	

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Student information loaded from StduentInfoObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

		}
	}
	
	//helper method to build dialogs
		private void alertDialogBuilder(AlertType type, String title, String header, String content) {
			Alert alert = new Alert(type);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.showAndWait();
		}
		
	//Create method to populate modules into modules pane. 
		public void listViews() {
			mp.clearListViews();
			
			Course[] selectedCourses = setupAndRetrieveCourses();
			Collection<Module> compSci = selectedCourses[0].getAllModulesOnCourse();
			Collection<Module> softEng = selectedCourses[1].getAllModulesOnCourse();
			
			if(pp.getSelectCourseName().toString() == "Computer Science") {
				for(Module m: compSci) {
					if(m.getRunPlan() == Delivery.YEAR_LONG) {
						mp.addYearLongModule(m);
					}
				    if(m.getRunPlan() == Delivery.TERM_1 && m.getModuleCode()!= "IMAT3423") {
						mp.addUnselectedTerm1Modules(m);
					}
					if(m.getRunPlan() == Delivery.TERM_2) {
						mp.addUnselectedTerm2Modules(m);
					}
					if(m.getModuleCode() == "IMAT3423") {
						mp.addSelectedTerm1Modules(m);
					}
				}
				getCredits1();
				getCredits2();
			}else {
				for(Module m: softEng) {
					if(m.getRunPlan() == Delivery.YEAR_LONG) {
						mp.addYearLongModule(m);
					}
				    if(m.getRunPlan() == Delivery.TERM_1 && m.getModuleCode()!= "IMAT3423") {
						mp.addUnselectedTerm1Modules(m);
					}
					if(m.getRunPlan() == Delivery.TERM_2 && m.getModuleCode() != "CTEC3902") {
						mp.addUnselectedTerm2Modules(m);
					}
					if(m.getModuleCode() == "IMAT3423") {
						mp.addSelectedTerm1Modules(m);
					}
					if(m.getModuleCode() == "CTEC3902") {
						mp.addSelectedTerm2Modules(m);
					}
				}
				getCredits1();
				getCredits2();
			}
			
		}	
		
	//Create method to show the credits in the term 1 text field and validate the credits. 	
		private void getCredits1() {
			Integer total = mp.getSTerm1ModulesList().stream().collect(Collectors.summingInt(Module::getCredits));
			total = total + 15;	
			mp.getTerm1Credits().setText(total.toString());
			if(total > 60) {
				total = total -15;
				mp.getTerm1Credits().setText(total.toString());
				alertDialogBuilder(AlertType.INFORMATION, "CREDITS EXCEED", null, "You can not exceed credits over 60 in term 1");
				Module selectedModule = mp.getSTerm1ModulesList().get(3);
				mp.getSTerm1ModulesList().remove(selectedModule);
				mp.getUnsTerm1ModulesList().add(selectedModule);
				
			}
		}
		
	//Create method to show the credits in the term 2 text field and validate the creadits. 
		private void getCredits2() {
			Integer total = mp.getSTerm2ModulesList().stream().collect(Collectors.summingInt(Module::getCredits));
			total = total + 15;	
			mp.getTerm2Credits().setText(total.toString());
			if(total > 60) {
				total = total -15;
				mp.getTerm2Credits().setText(total.toString());
				alertDialogBuilder(AlertType.INFORMATION, "CREDITS EXCEED", null, "You can not exceed credits over 60 in term 2");
				Module selectedModule = mp.getSTerm2ModulesList().get(3);
				mp.getSTerm2ModulesList().remove(selectedModule);
				mp.getUnseTerm2ModulesList().add(selectedModule);
		}
     }
		
}
