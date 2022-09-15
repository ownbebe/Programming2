package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private Button display;
    private Button write;
    private Button color;
    private Button exit;
    private TextField date;
    private TextField save;
    private TextField hue;
    Scene scene = null;
    GridPane gridPane = new GridPane();
    
    @Override
    public void start(Stage applicationStage) {		
	gridPane = new GridPane();
	scene = new Scene(gridPane, 400, 400);
			
	display = new Button("Show time and date");
	write = new Button("Save time and date");
	color = new Button("Random green background");
	exit = new Button("Exit");
	date = new TextField("Date and time: ");
        date.setEditable(false);
	save = new TextField("Save: ");
        save.setEditable(false);
        hue = new TextField ("Hue: ");
        hue.setEditable(false);
			
			
			
	gridPane.add(display, 0, 0);
	gridPane.add(date, 0, 1);
	gridPane.add(write, 1, 0);
	gridPane.add(save, 1, 1);
	gridPane.add(color, 2, 0);
	gridPane.add(exit, 3, 0);
        gridPane.add(hue, 2, 1);
			
	gridPane.setPadding(new Insets(10, 10, 10, 10));
	gridPane.setHgap(10);
	gridPane.setVgap(10);
			
	display.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(("MM/dd/yyyy HH:mm:ss"));
                LocalDateTime now = LocalDateTime.now();
					
                date.setText(dtf.format(now));
            }
        });
			
	write.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    File myObj = new File("log.txt");
                    if (myObj.createNewFile()) {
                        save.setText("log.txt created");
                        FileWriter myWriter = new FileWriter("log.txt");
                        myWriter.write(date.getText());
                        myWriter.close();
                    }
                    else {
                        save.setText("log.txt exists");
                        FileWriter myWriter = new FileWriter("log.txt");
                        myWriter.write(date.getText());
                        myWriter.close();
                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
	});
			
	color.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Random rand = new Random();
                float r1 = rand.nextFloat();
                float g1 = rand.nextFloat();
                float b1 = rand.nextFloat();
                
                r1*= 10;
                g1 *= 250;
                b1 *= 10;
					
                int r = Math.round(r1);
                int g = Math.round(g1);
                int b = Math.round(b1);
                hue.setText("Hue: " + r + "," + g + "," + b);
					
                gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b), CornerRadii.EMPTY, Insets.EMPTY)));
            }
	});
			
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
	});
			
	applicationStage.setScene(scene);
        applicationStage.setHeight(1000);
        applicationStage.setWidth(1000);
	applicationStage.setTitle("User Interface");
	applicationStage.show();
    }    
}
