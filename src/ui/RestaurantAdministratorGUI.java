package ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
        String userName = tfUserLogin.getText();
        String password = pfPasswordLogin.getText();
        if(!userName.equals("") && !password.equals("")){
            if(manager.activeUser(userName, password)){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-menu.fxml"));
                fxmlLoader.setController(this);
                Parent signUp = fxmlLoader.load();
                bpPaneMain.setCenter(signUp);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect data");
                alert.showAndWait();
            }
        }
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
        String userName = tfUserSignup.getText();
        String password = pfPassword1Signup.getText();
        String passwordVer = pfPassword2Signup.getText();
        boolean passValid = true;
        if(password.equals(passwordVer)){
            passValid = false;
        }
        boolean created = manager.addUser(firstName, lastName, id, userName, password);
        if((!firstName.equals("")&&!lastName.equals("")&&!id.equals("")
        &&!userName.equals("")&&!password.equals(""))&&created &&!passValid){
            System.out.println("Creado papi, cual es la desconfianza?");
            manager.saveUsersData();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("User created successfully");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Revisa que los campos hayan sido llenados correctamente y que las contraseñas sean iguales");
            alert.showAndWait();
        }
    }

}
