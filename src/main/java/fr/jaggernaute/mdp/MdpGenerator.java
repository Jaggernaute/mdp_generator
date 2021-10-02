package fr.jaggernaute.mdp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MdpGenerator extends Application {

    CheckBox checkBox1 = new CheckBox("Lettres");
    CheckBox checkBox2 = new CheckBox("Chiffres");
    CheckBox checkBox3 = new CheckBox("Symboles");
    Text text = new Text();
    Text label = new Text();
    int binaryBox;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Button genButton = new Button("Generer");
        TextField textField = new TextField();

        HBox checkBoxHbox = new HBox(
                checkBox1,
                checkBox2,
                checkBox3
        );

        HBox hbox = new HBox(
                textField,
                genButton
        );
        hbox.setSpacing( 1.0d );
        hbox.setAlignment(Pos.CENTER );
        hbox.setPadding( new Insets(40) );

        HBox hbox2 = new HBox(
               text
        );
        hbox2.setSpacing( 1.0d );
        hbox2.setAlignment(Pos.CENTER );
        hbox2.setPadding( new Insets(40) );

        VBox vbox = new VBox(
                hbox,
                checkBoxHbox,
                hbox2);
        vbox.setSpacing( 1.0d );
        vbox.setAlignment(Pos.CENTER );
        vbox.setPadding( new Insets(40) );

        genButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        if(Objects.equals(textField.getText(), "")){
                            text.setText("Veuillez rentrer une taille !");
                        }else{
                            if(checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected()){
                                int binaryBox = 0;

                                if(checkBox1.isSelected()) {
                                    System.out.println("Box 1 est séléctionée² !");
                                    binaryBox = binaryBox + 1;
                                }
                                if(checkBox2.isSelected()) {
                                    System.out.println("Box 2 est séléctionée !");
                                    binaryBox = binaryBox + 10;
                                }
                                if(checkBox3.isSelected()) {
                                    System.out.println("Box 3 est séléctionée !");
                                    binaryBox = binaryBox + 100;
                                }

                                if(binaryBox <= 0){
                                    System.out.println("No boxes are check");
                                }

                                Generator generator = new Generator();
                                String motDePasse = generator.mdpGen(Integer.parseInt(textField.getText()),binaryBox);
                                text.setText(motDePasse);
                                System.out.println(motDePasse);

                                System.out.println("BinaryBox value: " + binaryBox);

                            }else text.setText("Veuillez selectionner un type !");
                        }
                    }
                }
        );

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("MDP generator");
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public CheckBox getCheckBox(CheckBox checkBox) {
        return checkBox;
    }

    public static void main(String[] args) {launch(args);}
}