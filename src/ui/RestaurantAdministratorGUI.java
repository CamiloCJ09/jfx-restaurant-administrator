package ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.RestaurantManager;

import java.io.IOException;

public class RestaurantAdministratorGUI {

    private RestaurantManager manager;

    public final String SIGNUP_FXML = "signup.fxml";

    public final String SIGNIN_FXML = "signin.fxml";

    @FXML
    private BorderPane bpPaneMain;

    @FXML
    private VBox vbMainPane;

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
        manager = new RestaurantManager();
    }
    public void setFirstPane() throws IOException {

    }
    public BorderPane getMainPanePrincipal() {
        return bpPaneMain;
    }

    @FXML
    public void actLoginLogin(ActionEvent event) throws IOException{

    }

    @FXML
    public void actSignupLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SIGNUP_FXML));
        fxmlLoader.setController(this);
        Parent signUp = fxmlLoader.load();

        bpPaneMain.setCenter(signUp);
    }

    @FXML
    public void actBackSignup(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SIGNIN_FXML));
        fxmlLoader.setController(this);
        Parent signIn = fxmlLoader.load();

        bpPaneMain.setCenter(signIn);
    }

    @FXML
    public void actSignupSignup(ActionEvent event) throws IOException {
        String firstName = tfFirstNameSignup.getText();
        String lastName = tfLastNameSignup.getText();
        String id = tfIdentificationSignup.getText();
        String username = tfUserSignup.getText();
        String password = pfPassword1Signup.getText();

        boolean created = manager.addUser(firstName, lastName, id, username, password);
        if(created){
            System.out.println("Creado papi, cual es la desconfianza?");
            manager.saveUsersData();
        }
    }

}
