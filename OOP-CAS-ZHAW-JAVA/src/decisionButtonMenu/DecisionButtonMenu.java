package decisionButtonMenu;
//Test

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DecisionButtonMenu extends Application {
	ArrayList<String> answers = new ArrayList<String>();
	public String path = "src/answers.ser";
	
	public void start(Stage stage) {
				
		stage.setTitle("Decision Button");
		VBox root = new VBox();
		root.setSpacing(10);
	    root.setPadding(new Insets(0,0, 0, 10));
		Scene scene = new Scene(root, 400, 350);
		scene.setFill(Color.OLDLACE);

		MenuBar menuBar = new MenuBar();

		Menu menuDatei = new Menu("Datei");
		MenuItem loadItem = new MenuItem("Entscheidung laden");
		MenuItem saveItem = new MenuItem("Entscheidung speichern");
		
		Menu menuDateiStategie = new Menu("Speichere-Strategie");
		MenuItem objectItem = new MenuItem("Object");
		MenuItem textFileItem = new MenuItem("File");

		menuBar.getMenus().addAll(menuDatei, menuDateiStategie);
		menuDatei.getItems().addAll(loadItem,saveItem);
		menuDateiStategie.getItems().addAll(objectItem, textFileItem);
		
		// Add label, text field and buttons
		Label nameLabel = new Label("Tat:");
		TextField nameField = new TextField();
		Button saveButton = new Button("Save");
		Button showTextButton = new Button("Klick mich");
		
		nameField.setPromptText("Trage deine Tat ein");
		
		root.getChildren().addAll(menuBar, nameLabel, nameField, saveButton, showTextButton);

		stage.setScene(scene);
		stage.show();
		
		// Event Handling
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addNewAnswer(nameField.getText().toString());
			}
		});
		
		showTextButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showTextButton.setText(giveNewAnswer());
			}
		});		
		
		loadItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					DeSerialize deSerialize = new DeSerialize(path);
					deSerialize.deSerialize();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		saveItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Serialize serialize = new Serialize(path, answers);
				serialize.serialize();
			}
		});
		
		textFileItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				DecisionReadWriteText readWriteText = new DecisionReadWriteText(answers);
				try {
					readWriteText.writeTextFile();
					readWriteText.readTextFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		objectItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Serialize serialize = new Serialize(path, answers);
				serialize.serialize();
				DeSerialize deSerialize = new DeSerialize(path);
				try {
					deSerialize.deSerialize();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String giveNewAnswer() {
		Random randomInt= new Random();
		if (answers.isEmpty()) {
			return "Leere Liste";
		}
		
		else {
			return answers.get(randomInt.nextInt(answers.size()));
		}
	}

	public void addNewAnswer(String input) {
		if (input.isEmpty() == true || answers.contains(input)) {}
		
		else {
			System.out.println(input);
			answers.add(input);
		}
	}	

	public static void main(String[] args) {
		launch(args);
	}
}
