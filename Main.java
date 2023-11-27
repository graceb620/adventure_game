/**
 * The Little Wizard Game File
 * @author Grace Bero
 * Switching Scene method influenced by https://www.youtube.com/watch?v=SB9AnciLmsw by javacodejunkie
 * 
 */

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;


/**
 * Main class that runs the game in a GUI
 */

public class Main extends Application {

    private Stage stage;
    private Scene startScene;
    private Scene nameScene;
    private Scene storyScene;
    private Scene combatScene;

    private Wizard player;

    private Text introText;

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creates the start screen
        stage = primaryStage;
        stage.setTitle("The Little Wizard");

        startScene = createStartScene();
        nameScene = createNameScene();
        storyScene = createStoryScene();
        combatScene = createCombatScene();

        stage.setScene(startScene);

        stage.show();
    }

    /**
     * Creates the start scene
     * @return the start scene
     */
    private Scene createStartScene() {
        Text titleText;
        Button button;
        VBox vbox;

        titleText = new Text("The Little Wizard");
        titleText.setFont(Font.font("Lucida Calligraphy", 30));
        button = new Button("Start");
        button.setOnAction(e -> switchScenes(nameScene));  // Switch Scenes

        vbox = new VBox(10, titleText, button);
        vbox.setAlignment(Pos.CENTER);

        startScene = new Scene(vbox, 1000, 700);

        return startScene;
    }

    /**
     * Creates the name scene
     * @return the name scene
     */
    private Scene createNameScene() {
        Label nameLabel;
        TextField nameField;
        Button button;
        VBox vbox;

        nameLabel = new Label("What is your name?");
        nameLabel.setFont(Font.font( "Lucida Calligraphy", 20));
        nameField = new TextField();
        nameField.setMaxWidth(200);
        player = new Wizard("TBD");
        player.setName(nameField.getText());

        button = new Button("continue");
        button.setOnAction(e -> switchScenes(storyScene));

        vbox = new VBox(10, nameLabel, nameField, button);
        vbox.setAlignment(Pos.CENTER);

        nameScene = new Scene(vbox, 1000, 700);
        return nameScene;
    }

    /**
     * Creates the story scene that evolves as the user chooses answers with buttons 
     * @return storyScene
     */
    private Scene createStoryScene() {
        Text introText;
        Button introTextNext;
        VBox vbox;



        introText = new Text("Welcome to the game " + player.getName() + "! \nYou will be given a series of choices that will affect the outcome of the game");
        introText.setFont(Font.font("Lucida Calligraphy", 14));
        introTextNext = new Button("Next");
        introTextNext.setOnAction(new TextButtonHandler());

        vbox = new VBox(10, introText, introTextNext);
        vbox.setAlignment(Pos.TOP_CENTER);

        storyScene = new Scene(vbox, 1000, 700);
        
        return storyScene;
    } 

    /**
     * Handles the text button
     */

    class TextButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            ArrayList<Text> text1 = new ArrayList<Text>();
            text1.add(new Text("Lets Begin! \nYou wake up in your dorm room, do you go to class?"));
            text1.add(new Text("You cant skip your first day of class! \nYou go to class and learn spark!"));

            int count = 0;
            count++;
            introText = text1.get(count);
        }
    }

    
    


    

    /**
     * Creates the combat scene that evolves as the user chooses what to do
     * @return combatScene
     */
    private Scene createCombatScene() {

        return combatScene;
    }

    /**
     * Switch Scenes in single Stage 
     * @author javacodejunkie
     * @param scene the scene to switch to
     * 
     */
	public void switchScenes(Scene scene) {
		stage.setScene(scene);
	}

    /**
     * Main method to launch the program
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    
    
 }
