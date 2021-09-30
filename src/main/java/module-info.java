module fr.jaggernaute.mdp {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.jaggernaute.mdp to javafx.fxml;
    exports fr.jaggernaute.mdp;
}