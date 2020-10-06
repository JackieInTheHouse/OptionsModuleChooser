package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

public class ModuleChooserMenuBar extends MenuBar {
	
	private MenuItem loadItem, saveItem, exitItem, aboutItem;
	
	public ModuleChooserMenuBar() {
		
		Menu menu;
		
		menu = new Menu("File");
		
		loadItem = new MenuItem("Load Student Data");
		loadItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(loadItem);
		
		saveItem = new MenuItem("Save Student Data");
		saveItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(saveItem);
		
		menu.getItems().add(new SeparatorMenuItem());
		
		exitItem = new MenuItem("Exit");
		exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menu.getItems().add(exitItem);
		
		this.getMenus().add(menu);
		
		menu = new Menu("Help");
		
		aboutItem = new MenuItem("About");
		aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		menu.getItems().add(aboutItem);
		
		this.getMenus().add(menu);
	}
	
	
	//create event listener 
	public void addLoadHandler(EventHandler<ActionEvent> handler) {
		loadItem.setOnAction(handler);
	}
	
	public void addSaveHandler(EventHandler<ActionEvent> handler) {
		saveItem.setOnAction(handler);
	}
	
	public void addExitHandler(EventHandler<ActionEvent> handler) {
		exitItem.setOnAction(handler);
	}
	
	public void addAboutHandler(EventHandler<ActionEvent> handler) {
		aboutItem.setOnAction(handler);
	}

}
