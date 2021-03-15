package ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RestaurantAdministratorGUI {

    public final String SIGNUP_FXML = "signup.fxml";

    public final String MAIN_FXML = "main.fxml";

    @FXML
    private VBox vbMainPane;

    @FXML
    private BorderPane bpPaneMain;

    @FXML
    private JFXTextField tfUserLogin;

    @FXML
    private JFXPasswordField pfPasswordLogin;

    @FXML
    private JFXTextField tfUserSignup;

    @FXML
    private JFXPasswordField pfPassword1Signup;

    @FXML
    private JFXPasswordField pfPassword2Signup;

    @FXML
    private JFXTextField tfFirstNameSignup;

    @FXML
    private JFXTextField tfLastNameSignup;

    @FXML
    private JFXTextField tfIdentificationSignup;

    public RestaurantAdministratorGUI(){

    }
    public void setFirstPane() throws IOException {

    }
    public VBox getMainPanePrincipal() {
        return vbMainPane;
    }

    @FXML
    public void actLoginLogin(ActionEvent event) throws IOException{

    }

    @FXML
    public void actSignupLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SIGNUP_FXML));
        fxmlLoader.setController(this);
        Parent signUp = fxmlLoader.load();

        bpPaneMain.getChildren().setAll(signUp);
    }

    @FXML
    public void actBackSignup(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_FXML));
        fxmlLoader.setController(this);
        Parent main = fxmlLoader.load();

        vbMainPane.getChildren().setAll(main);
    }

    @FXML
    public void actSignupSignup(ActionEvent event) throws IOException {

    }

}
