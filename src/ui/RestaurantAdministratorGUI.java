package ui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.*;

import java.io.IOException;
import java.util.List;

public class RestaurantAdministratorGUI {

    private RestaurantManager manager;

    public final static String SIGNUP_FXML = "signup.fxml";

    public final static String LOGIN_FXML = "login.fxml";

    public final static String ADDMENU_FXML = "addmenu.fxml";

    public final static String EDITMENU_FXML = "editmenu.fxml";

    public final static String ADDEMPLOYEE_FXML = "addemployee.fxml";

    public final static String ADDCLIENT_FXML = "addclient.fxml";

    public final static String ADDPRODUCT_FXML = "addproduct.fxml";

    public final static String ADDINGREDIENT_FXML = "addingredient.fxml";

    public final static String ADDTYPE_FXML = "addtype.fxml";

    private ObservableList<Ingredients> tempIngredients;

    private ObservableList<Size> tempSizes;

    private ObservableList<OrderMenuItem> orderItems;

    private ObservableList<Client> clients;

    @FXML
    private BorderPane bpPaneMain;

    @FXML
    private BorderPane bpPaneAdd;

    @FXML
    private MenuBar mbMenuMain;

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

    @FXML
    private JFXTextField tfCodeOrder;

    @FXML
    private JFXTextField tfDateOrder;

    @FXML
    private JFXComboBox<String> cbEmployeeOrder;

    @FXML
    private JFXComboBox<String> cbClientOrder;

    @FXML
    private JFXComboBox<String> cbProductOrder;

    @FXML
    private JFXComboBox<String> cbSizeOrder;

    @FXML
    private JFXTextField tfAmountOrder;

    @FXML
    private JFXTextField tfUPriceOrder;

    @FXML
    private JFXTextField tfTPriceOrder;

    @FXML
    private JFXComboBox<String> cbTypeAdd;

    @FXML
    private JFXTextField tfFirstNameAddClient;

    @FXML
    private JFXTextField tfLastNameAddClient;

    @FXML
    private JFXTextField tfIdAddClient;

    @FXML
    private JFXTextField tfAddressAddClient;

    @FXML
    private JFXTextField tfTelAddClient;

    @FXML
    private JFXTextArea taObservationsAddClient;

    @FXML
    private JFXTextField tfFirstNameAddEmployee;

    @FXML
    private JFXTextField tfLastNameAddEmployee;

    @FXML
    private JFXTextField tfIdAddEmployee;

    @FXML
    private JFXTextField tfNameAddIngredient;

    @FXML
    private JFXTextField tfNameAddType;

    @FXML
    private JFXTextField tfNameAddProduct;

    @FXML
    private JFXComboBox<String> cbTypeAddProduct;

    @FXML
    private JFXComboBox<String> cbIngredientsAddProduct;

    @FXML
    private TableView<Ingredients> tvIngredientsAddProduct;

    @FXML
    private JFXTextField tfSizeAddProduct;

    @FXML
    private JFXTextField tfPriceAddProduct;

    @FXML
    private TableView<Size> tvSizeAddProduct;

    @FXML
    private TableColumn<Size, String> tcSizeAddProduct;

    @FXML
    private TableColumn<Size, String> tcPriceAddProduct;

    @FXML
    private TableColumn<Ingredients, String> tcIngredientsAddProduct;

    @FXML
    private TableView<OrderMenuItem> tvOrdersOrder;

    @FXML
    private TableColumn<OrderMenuItem, String> tcProductOrder;

    @FXML
    private TableColumn<OrderMenuItem, String> tcSizeOrder;

    @FXML
    private TableColumn<OrderMenuItem, String> tcAmountOrder;

    @FXML
    private TableColumn<OrderMenuItem, String> tcUPriceOrder;

    @FXML
    private TableColumn<OrderMenuItem, String> tcTPriceOrder;

    @FXML
    private TableView<Client> tvClientsAddClient;

    @FXML
    private TableColumn<Client, String> tcFirstNameAddClient;

    @FXML
    private TableColumn<Client, String> tcLastNameAddClient;

    @FXML
    private TableColumn<Client, String> tcIDAddClient;

    @FXML
    private TableColumn<Client, String> tcAddressAddClient;

    @FXML
    private TableColumn<Client, String> tcTelAddClient;

    @FXML
    private TableColumn<?, ?> tcObservationsAddClient;

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
                Parent ordermenu = fxmlLoader.load();
                bpPaneMain.setCenter(ordermenu);
                mbMenuMain.setVisible(true);
                mbMenuMain.setDisable(false);
                setupOrderScreen();
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_FXML));
        fxmlLoader.setController(this);
        Parent signIn = fxmlLoader.load();

        bpPaneMain.setCenter(signIn);
    }

    @FXML
    public void actSignupSignup(ActionEvent event) throws IOException, ClassNotFoundException {
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
            manager.saveUsersData();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("User created successfully");
            alert.showAndWait();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_FXML));
            fxmlLoader.setController(this);
            Parent login = fxmlLoader.load();
            bpPaneMain.setCenter(login);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Revisa que los campos hayan sido llenados correctamente y que las contraseñas sean iguales");
            alert.showAndWait();
        }
    }

    public void loadAllData() throws IOException, ClassNotFoundException {
        manager.loadUsersData();
    }

    public void setupClientsAddClientsScreen(){
        clients = FXCollections.observableArrayList(manager.getClients());
        tcFirstNameAddClient.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastNameAddClient.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcIDAddClient.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcAddressAddClient.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcTelAddClient.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tvClientsAddClient.setItems(clients);
    }

    public void setupOrderScreen(){
        for(int a = 0; a<manager.getEmployees().size(); a++){
            cbEmployeeOrder.getItems().add(manager.getEmployees().get(a).getFirstName() + " " + manager.getEmployees().get(a).getLastName());
        }
        for(int b = 0; b<manager.getClients().size(); b++){
            cbClientOrder.getItems().add(manager.getClients().get(b).getFirstName() + " " + manager.getClients().get(b).getLastName());
        }
        for(int c = 0; c<manager.getProducts().size(); c++){
            cbProductOrder.getItems().add(manager.getProducts().get(c).getName());
        }
        orderItems = FXCollections.observableArrayList();
        tcProductOrder.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tcSizeOrder.setCellValueFactory(new PropertyValueFactory<>("size"));
        tcAmountOrder.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tcUPriceOrder.setCellValueFactory(new PropertyValueFactory<>("priceU"));
        tcTPriceOrder.setCellValueFactory(new PropertyValueFactory<>("priceT"));
    }


    @FXML
    public void miAboutMain(ActionEvent event) {

    }

    @FXML
    public void miAddItemsMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDMENU_FXML));
        fxmlLoader.setController(this);
        Parent addmenu = fxmlLoader.load();

        bpPaneMain.setCenter(addmenu);
        setupAddItemsScreen();
    }

    public void setupAddItemsScreen(){
        ObservableList<String> options = FXCollections.observableArrayList(
                "Empleado",
                "Cliente",
                "Producto",
                "Ingrediente",
                "Tipo de comida"
        );
        cbTypeAdd.getItems().setAll(options);
    }

    @FXML
    public void miAddOrderMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order-menu.fxml"));
        fxmlLoader.setController(this);
        Parent ordermenu = fxmlLoader.load();
        bpPaneMain.setCenter(ordermenu);

        setupOrderScreen();
    }

    @FXML
    public void miEditItemsMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(EDITMENU_FXML));
        fxmlLoader.setController(this);
        Parent editmenu = fxmlLoader.load();

        bpPaneMain.setCenter(editmenu);
    }

    @FXML
    public void actAddOrderOrder(ActionEvent event) {
        orderItems.add(manager.newOrderMenuItem(
                manager.findProduct(cbProductOrder.getSelectionModel().getSelectedItem().toString()),
                manager.findSize(manager.findProduct(cbProductOrder.getSelectionModel().getSelectedItem().toString()), cbSizeOrder.getSelectionModel().getSelectedItem().toString()),
                Double.parseDouble(tfAmountOrder.getText())
        ));
        System.out.println(manager.findSize(manager.findProduct(cbProductOrder.getSelectionModel().getSelectedItem().toString()), cbSizeOrder.getSelectionModel().getSelectedItem().toString()).getPrice());
        tvOrdersOrder.setItems(orderItems);
        tvOrdersOrder.refresh();
    }

    @FXML
    public void actDeleteOrder(ActionEvent event) {
        orderItems.remove(tvOrdersOrder.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void actInfoOrder(ActionEvent event) {

    }

    @FXML
    public void actDisplayAdd(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader;
        switch (cbTypeAdd.getSelectionModel().getSelectedItem().toString()){
            case("Empleado"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDEMPLOYEE_FXML));
                fxmlLoader.setController(this);
                Parent addemployee = fxmlLoader.load();

                bpPaneAdd.setCenter(addemployee);
            break;
            case("Cliente"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDCLIENT_FXML));
                fxmlLoader.setController(this);
                Parent addclient = fxmlLoader.load();

                setupClientsAddClientsScreen();
                bpPaneAdd.setCenter(addclient);
            break;
            case("Producto"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDPRODUCT_FXML));
                fxmlLoader.setController(this);
                Parent addproduct = fxmlLoader.load();

                bpPaneAdd.setCenter(addproduct);
                setupAddProductScene();
            break;
            case("Ingrediente"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDINGREDIENT_FXML));
                fxmlLoader.setController(this);
                Parent addingredient = fxmlLoader.load();

                bpPaneAdd.setCenter(addingredient);
            break;
            case("Tipo de comida"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDTYPE_FXML));
                fxmlLoader.setController(this);
                Parent addtype = fxmlLoader.load();

                bpPaneAdd.setCenter(addtype);
            break;
        }
    }

    @FXML
    public void actAddClientAddClient(ActionEvent event) {
        String firstName = tfFirstNameAddClient.getText();
        String lastName = tfLastNameAddClient.getText();
        String id = tfIdAddClient.getText();
        String address = tfAddressAddClient.getText();
        String tel = tfTelAddClient.getText();
        String observations = taObservationsAddClient.getText();
        manager.addClient(firstName, lastName, id, address, tel, observations);
        setupClientsAddClientsScreen();
        tvClientsAddClient.refresh();
    }

    @FXML
    public void actAddEmployeeAddEmployee(ActionEvent event) {
        String firstName = tfFirstNameAddEmployee.getText();
        String lastName = tfLastNameAddEmployee.getText();
        String id = tfIdAddEmployee.getText();
        manager.addEmployee(firstName, lastName, id);
    }

    @FXML
    public void actAddIngredientAddIngredient(ActionEvent event) {
        String name = tfNameAddIngredient.getText();
        manager.addIngredient(name);
    }

    @FXML
    public void actAddTypeAddType(ActionEvent event) {
        String name = tfNameAddType.getText();
        manager.addFoodType(name);
    }

    private void setupAddProductScene(){
        for(int a = 0; a < manager.getFoodTypes().size(); a++){
            cbTypeAddProduct.getItems().add(manager.getFoodTypes().get(a).getName());
        }
        for(int b = 0; b < manager.getIngredients().size(); b++){
            cbIngredientsAddProduct.getItems().add(manager.getIngredients().get(b).getName());
        }
        tempIngredients = FXCollections.observableArrayList();
        tcIngredientsAddProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        tempSizes = FXCollections.observableArrayList();
        tcSizeAddProduct.setCellValueFactory(new PropertyValueFactory<>("size"));
        tcPriceAddProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    public void actAddIngredientAddProduct(ActionEvent event) {
        tempIngredients.add(manager.searchIngredient(cbIngredientsAddProduct.getSelectionModel().getSelectedItem().toString()));
        tvIngredientsAddProduct.setItems(tempIngredients);
        tvIngredientsAddProduct.refresh();
    }

    @FXML
    public void actAddProductAddProduct(ActionEvent event) {
        String productName = tfNameAddProduct.getText();
        String foodType = cbTypeAddProduct.getSelectionModel().getSelectedItem();
        List<Ingredients> ingredients = tvIngredientsAddProduct.getItems();
        List<Size> sizesList = tvSizeAddProduct.getItems();

        if(!(productName.equals(""))&&!(foodType.equals(""))&&(!ingredients.isEmpty()) && (!sizesList.isEmpty())){
            manager.addProduct(productName, foodType, ingredients, sizesList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Producto añadido con exito");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Revise todos los campos antes de crear un producto");
            alert.showAndWait();
        }
    }

    @FXML
    public void actAddSizeAddProduct(ActionEvent event) {
        tempSizes.add(manager.newSize(tfSizeAddProduct.getText(), Double.parseDouble(tfPriceAddProduct.getText())));
        tvSizeAddProduct.setItems(tempSizes);
        tvSizeAddProduct.refresh();
    }

    @FXML
    public void actDisplaySizesOrder(ActionEvent event) {
        cbSizeOrder.getItems().clear();
        String productName = cbProductOrder.getSelectionModel().getSelectedItem();
        for(int i = 0; i < manager.findProduct(productName).getSizes().size(); i++){
            cbSizeOrder.getItems().add(manager.findProduct(productName).getSizes().get(i).getSize());
        }
    }

    @FXML
    public void actDisplayUPriceOrder(ActionEvent event) {
        String productName = cbProductOrder.getSelectionModel().getSelectedItem();
        String sizes = cbSizeOrder.getSelectionModel().getSelectedItem();
        for(int i = 0; i < manager.findProduct(productName).getSizes().size(); i++){
            if (manager.findProduct(productName).getSizes().get(i).getSize().equals(sizes)) {
                double value = manager.findProduct(productName).getSizes().get(i).getPrice();
                tfUPriceOrder.setText(String.valueOf(value));
            }
        }
    }
    @FXML
    public void actDisplayTPriceOrder(KeyEvent event) {
        if (!tfAmountOrder.getText().equals("")){
            int amount = Integer.parseInt(tfAmountOrder.getText());
            double unitPrice = Double.parseDouble(tfUPriceOrder.getText());
            String value = String.valueOf(amount*unitPrice);
            tfTPriceOrder.setText(value);
        }
    }

    //Todo: add import data method and connect it with restaurant manager
    //Todo: add export data methods and connect them with restaurant manager


}
