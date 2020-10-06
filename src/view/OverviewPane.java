package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class OverviewPane extends BorderPane {

	private TextArea result;
	private Button saveOverview;
	
	public OverviewPane() {
		result = new TextArea();
		saveOverview = new Button("Save Overview");
		this.setPadding(new Insets(40,40,40,40));
		this.setCenter(result);
		this.setBottom(saveOverview);

		BorderPane.setAlignment(saveOverview, Pos.BOTTOM_CENTER);
		BorderPane.setMargin(saveOverview, new Insets(20,20,20,20));
		
	}
	

	//method to update the content of this pane
	public void setResults(String overview) {
		result.setText(overview);
	}
	

	//create event listener
	public void addSaveOverViewListener(EventHandler<ActionEvent> handler) {
		saveOverview.setOnAction(handler);
	}
    
	public void clearResults() {
		result.setText(" ");
		
	}

	public String getResults() {
		// TODO Auto-generated method stub
		return result.getText();
	}
}
