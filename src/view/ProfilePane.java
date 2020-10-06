package view;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;

public class ProfilePane extends GridPane{
	
	private Label selectCourse, inputPNumber, inputFirstName, inputSurname, inputEmail, inputDate;
	private ComboBox<Course> course;
	private TextField pNumber, firstName, surname, email;
	private DatePicker dateInput;
	private Button createProfile;

	public ProfilePane() {
		
		this.setPadding(new Insets(80,80,80,80));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		
		
		selectCourse = new Label("Select course");
		inputPNumber = new Label("Input P number");
		inputFirstName = new Label("Input first name");
		inputSurname = new Label("Input surname");
		inputEmail = new Label("Input email");
		inputDate = new Label("Input date");
		
		course = new ComboBox<Course>();
		
		pNumber = new TextField();
		firstName = new TextField();
		surname = new TextField();
		email = new TextField();
		dateInput = new DatePicker();
		
		createProfile = new Button("Create Profile");
		
		this.add(selectCourse, 0, 0);
		this.add(course, 1, 0);
		
		this.add(inputPNumber, 0, 1);
		this.add(pNumber, 1, 1);
		
		this.add(inputFirstName, 0, 2);
		this.add(firstName, 1, 2);
		
		this.add(inputSurname, 0, 3);
		this.add(surname, 1, 3);
		
		this.add(inputEmail, 0, 4);
		this.add(email, 1, 4);
		
		this.add(inputDate, 0, 5);
		this.add(dateInput,1,5);
		
		this.add(new HBox(),0, 6);
		this.add(createProfile, 1, 6);
	}
	
	
	//public interface for this pane
	public void populateComboBoxWithCourses(Course[] courses) {
		course.getItems().addAll(courses);
		course.getSelectionModel().select(0);
	}
	
	public Course getSelectCourseName() {
		return course.getSelectionModel().getSelectedItem();
	}
	
	public String getPNumberInput() {
		return pNumber.getText();
	}
	
	public String getFNameInput() {
		return firstName.getText();
	}
	
	public String getSurnameInput() {
		return surname.getText();
	}
	
	public String getEmailInput() {
		return email.getText();
	}
	
	public LocalDate getDateInput() {
		return dateInput.getValue();
	}
	
	//create event listener
	public void addCreateProfileListener(EventHandler<ActionEvent> handler) {
		createProfile.setOnAction(handler);
	}
}
