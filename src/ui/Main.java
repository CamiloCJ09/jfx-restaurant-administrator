package ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    private RestaurantAdministratorGUI restaurantAdministratorGUI;
    public Main(){
        restaurantAdministratorGUI = new RestaurantAdministratorGUI();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        fxmlLoader.setController(restaurantAdministratorGUI);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LA CASA DORADA");
        primaryStage.show();


        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("signin.fxml"));
        fxmlLoader2.setController(restaurantAdministratorGUI);
        Parent signIn = fxmlLoader2.load();

        restaurantAdministratorGUI.getMainPanePrincipal().setCenter(signIn);


    }
    public static void main(String[] args){
        launch(args);
    }

}
