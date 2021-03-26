package ui;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantAdministratorGUI {

    private Clock clock;


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

    public final static String TABLEPRODUCT_FXML = "tableproduct.fxml";

    public final static String TABLEORDER_FXML = "tableorder.fxml";

    private ObservableList<Ingredients> tempIngredients;

    private ObservableList<Size> tempSizes;

    private ObservableList<OrderMenuItem> orderItems;

    private ObservableList<Client> clients;

    private ObservableList<Employee> employees;

    private ObservableList<Ingredients> ingredients;

    private ObservableList<FoodType> types;

    private ObservableList<ProductItem> productItems;

    private ObservableList<Ingredients> windowTempIngredients;

    private ObservableList<ObservableOrder> orders;

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

    @FXML
    private TableView<Employee> tvEmployeesAddEmployee;

    @FXML
    private TableColumn<Employee, String> tcFirstNameAddEmployee;

    @FXML
    private TableColumn<Employee, String> tcLastNameAddEmployee;

    @FXML
    private TableColumn<Employee, String> tcIdAddEmployee;

    @FXML
    private TableView<Ingredients> tvIngredientsAddIngredient;

    @FXML
    private TableColumn<Ingredients, String> tcNameAddIngredient;

    @FXML
    private TableView<FoodType> tvTypesAddType;

    @FXML
    private TableColumn<FoodType, String> tcNameAddType;

    @FXML
    private JFXButton btnAddClientAddClient;

    @FXML
    private JFXButton btnAddIngredientAddIngredient;

    @FXML
    private JFXButton btnAddEmployeeAddEmployee;

    @FXML
    private JFXButton btnAddTypeAddType;

    @FXML
    private TableView<ProductItem> tvProductsTProduct;

    @FXML
    private TableColumn<ProductItem, String> tcProductTProduct;

    @FXML
    private TableColumn<ProductItem, String> tcTypeTProduct;

    @FXML
    private TableColumn<ProductItem, Void> tcIngredientsTProduct;

    @FXML
    private TableColumn<ProductItem, String> tcSizeTProduct;

    @FXML
    private TableColumn<ProductItem, String> tcPriceTProduct;

    @FXML
    private TableView<Ingredients> tvIngredientsWindowIngredients;

    @FXML
    private TableColumn<Ingredients, String> tcIngredientsWindowIngredients;

    @FXML
    private TableView<ObservableOrder> tvOrdersTOrder;

    @FXML
    private TableColumn<ObservableOrder, String> tcCodeTOrder;

    @FXML
    private TableColumn<ObservableOrder, String> tcDateTOrder;

    @FXML
    private TableColumn<Order, String> tcEmployeeTOrder;

    @FXML
    private TableColumn<ObservableOrder, String> tcClientTOrder;

    @FXML
    private TableColumn<ObservableOrder, String> tcTPriceTOrder;

    @FXML
    private TableColumn<ObservableOrder, String> tcObservationsTOrder;

    @FXML
    private TableColumn<?, ?> tcProductsTOrder;

    @FXML
    private JFXTextArea taObservationsAddOrder;

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
                tempIngredients = FXCollections.observableArrayList(manager.getIngredients());

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
            manager.saveEmployeesData();
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
        manager.loadClientsData();
        manager.loadEmployeeData();
        manager.loadIngredientsData();
        manager.loadFoodTypeData();
        manager.loadProductData();
    }

    public void setupClientsAddClientsScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDCLIENT_FXML));
        fxmlLoader.setController(this);
        Parent addclient = fxmlLoader.load();

        bpPaneAdd.setCenter(addclient);

        clients = FXCollections.observableArrayList(manager.getClients());
        tcFirstNameAddClient.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastNameAddClient.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcIDAddClient.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcAddressAddClient.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcTelAddClient.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tvClientsAddClient.setItems(clients);
    }

    public void setupOrderScreen(){
        for (int a = 0; a < manager.getEmployees().size(); a++) {
            cbEmployeeOrder.getItems().add(manager.getEmployees().get(a).getFirstName() + " " + manager.getEmployees().get(a).getLastName());
        }
        for (int b = 0; b < manager.getClients().size(); b++) {
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
        tvOrdersOrder.setEditable(true);
        tcAmountOrder.setCellFactory(TextFieldTableCell.forTableColumn());
        //Clean this
        Instant time = Instant.now();
        String[] dateFields =time.toString().split("T");
        String[] timeFields = dateFields[1].split("\\.");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String timeWFormat = simpleDateFormat.format(Date.from(time));//We use it in the code for the order
        Date date = Date.from(time); // Use it for the order attribute
        manager.setTime(date);
        String finalTime = simpleDateFormat.format(Date.from(time));
        tfDateOrder.setText(finalTime.replace(" ", "/"));

        //Auto-generated code

        String code = (String.valueOf(timeWFormat.charAt(8))).concat(String.valueOf(timeWFormat.charAt(9))).concat(String.valueOf(timeWFormat.charAt(3))).
                concat(String.valueOf(timeWFormat.charAt(4))).concat(String.valueOf(timeWFormat.charAt(0))).concat(String.valueOf(timeWFormat.charAt(1))).
                concat(String.valueOf(manager.getOrders().size()));
        //code.concat()
        tfCodeOrder.setText(code);
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
    public void actAddOrderItemOrder(ActionEvent event) {
        boolean alreadyIs = false;
        for(int i = 0; i<orderItems.size(); i++){
            if(orderItems.get(i).getProductName().equals(cbProductOrder.getSelectionModel().getSelectedItem())){
                if(orderItems.get(i).getSize().equals(cbSizeOrder.getSelectionModel().getSelectedItem())){
                    alreadyIs = true;
                }
            }
        }
        if(!alreadyIs){
            orderItems.add(manager.newOrderMenuItem(
                    manager.findProduct(cbProductOrder.getSelectionModel().getSelectedItem().toString()),
                    manager.findSize(manager.findProduct(cbProductOrder.getSelectionModel().getSelectedItem().toString()), cbSizeOrder.getSelectionModel().getSelectedItem().toString()),
                    Double.parseDouble(tfAmountOrder.getText())
            ));
            tvOrdersOrder.setItems(orderItems);
            tvOrdersOrder.refresh();
        }
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
                setupAddEmployeeScreen();
            break;
            case("Cliente"):
                setupClientsAddClientsScreen();
            break;
            case("Producto"):
                fxmlLoader = new FXMLLoader(getClass().getResource(ADDPRODUCT_FXML));
                fxmlLoader.setController(this);
                Parent addproduct = fxmlLoader.load();

                bpPaneAdd.setCenter(addproduct);
                setupAddProductScene();
            break;
            case("Ingrediente"):
                setupAddIngredientScreen();
            break;
            case("Tipo de comida"):
                setupAddTypeScreen();
            break;
        }
    }

    @FXML
    public void actAddClientAddClient(ActionEvent event) throws IOException {
        String firstName = tfFirstNameAddClient.getText();
        String lastName = tfLastNameAddClient.getText();
        String id = tfIdAddClient.getText();
        String address = tfAddressAddClient.getText();
        String tel = tfTelAddClient.getText();
        String observations = taObservationsAddClient.getText();
        if(!(firstName.equals("")) && !(lastName.equals("")) && !(id.equals(""))){
            if(btnAddClientAddClient.getText().equals("Agregar")){
                manager.addClient(firstName, lastName, id, address, tel, observations);
                setupClientsAddClientsScreen();
            } else{
                manager.editClient(tvClientsAddClient.getSelectionModel().getSelectedIndex(), firstName, lastName, id, address, tel, observations);
                btnAddClientAddClient.setText("Agregar");
            }
            tvClientsAddClient.refresh();
        }else{
            System.out.println("Que dijiste pues pri");
        }

        manager.saveClientsData();
        tvClientsAddClient.refresh();
        tfFirstNameAddClient.clear();
        tfLastNameAddClient.clear();
        tfIdAddClient.clear();
        tfAddressAddClient.clear();
        tfTelAddClient.clear();
        taObservationsAddClient.clear();
    }

    @FXML
    public void actAddEmployeeAddEmployee(ActionEvent event) throws IOException {
        String firstName = tfFirstNameAddEmployee.getText();
        String lastName = tfLastNameAddEmployee.getText();
        String id = tfIdAddEmployee.getText();
        if(btnAddEmployeeAddEmployee.getText().equals("Agregar")){
            manager.addEmployee(firstName, lastName, id);
            setupAddEmployeeScreen();
        } else{
            manager.editEmployee(tvEmployeesAddEmployee.getSelectionModel().getSelectedIndex(), firstName, lastName, id);
            btnAddEmployeeAddEmployee.setText("Agregar");
        }
        manager.saveEmployeesData();
        tvEmployeesAddEmployee.refresh();
        tfFirstNameAddEmployee.clear();
        tfLastNameAddEmployee.clear();
        tfIdAddEmployee.clear();
    }

    @FXML
    public void actAddIngredientAddIngredient(ActionEvent event) throws IOException {
        String name = tfNameAddIngredient.getText();
        if(btnAddIngredientAddIngredient.getText().equals("Agregar")){
            manager.addIngredient(name);
            setupAddIngredientScreen();
        } else{
            manager.editIngredient(tvIngredientsAddIngredient.getSelectionModel().getSelectedIndex(), name);

            btnAddIngredientAddIngredient.setText("Agregar");
        }
        manager.saveProductData();
        manager.saveIngredientsData();
        tvIngredientsAddIngredient.refresh();
        tfNameAddIngredient.clear();
    }

    @FXML
    public void actAddTypeAddType(ActionEvent event) throws IOException {
        String name = tfNameAddType.getText();
        if(btnAddTypeAddType.getText().equals("Agregar")){
            manager.addFoodType(name);
            setupAddTypeScreen();
        } else{
            manager.editType(tvTypesAddType.getSelectionModel().getSelectedIndex(), name);
            btnAddTypeAddType.setText("Agregar");
        }
        manager.saveFoodTypesData();
        tvTypesAddType.refresh();
        tfNameAddType.clear();
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
        boolean alreadyIs = false;
        for(int i = 0; i<tempIngredients.size(); i++){
            if(tempIngredients.get(i).getName().equals(cbIngredientsAddProduct.getSelectionModel().getSelectedItem())){
                alreadyIs = true;
            }
        }
        if(!alreadyIs){
            tempIngredients.add(manager.searchIngredient(cbIngredientsAddProduct.getSelectionModel().getSelectedItem().toString()));
            tvIngredientsAddProduct.setItems(tempIngredients);
            tvIngredientsAddProduct.refresh();
        }
    }

    @FXML
    public void actAddProductAddProduct(ActionEvent event) throws IOException {
        String productName = tfNameAddProduct.getText();
        String foodType = cbTypeAddProduct.getSelectionModel().getSelectedItem();
        ObservableList<Ingredients> ingredients = tvIngredientsAddProduct.getItems();
        ObservableList<Size> sizesList = tvSizeAddProduct.getItems();

        if(!(productName.equals(""))&&!(foodType.equals(""))&&(!ingredients.isEmpty()) && (!sizesList.isEmpty())){
            manager.addProduct(productName, foodType, ingredients, sizesList);
            manager.saveProductData();
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
        boolean alreadyIs = false;
        for(int i = 0; i<tempSizes.size(); i++){
            if(tempSizes.get(i).getSize().equalsIgnoreCase(tfSizeAddProduct.getText())){
                alreadyIs = true;
            }
        }
        if(!alreadyIs){
            tempSizes.add(manager.newSize(tfSizeAddProduct.getText(), Double.parseDouble(tfPriceAddProduct.getText())));
            tvSizeAddProduct.setItems(tempSizes);
            tvSizeAddProduct.refresh();
        }
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

    @FXML
    public void actImportUsersData(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona el archivo");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Csv files", "*.csv"));
        Stage primaryStage = (Stage)bpPaneMain.getScene().getWindow();
        File fileToSave = fileChooser.showOpenDialog(primaryStage);
        if(fileToSave != null){
            String url = fileToSave.toPath().toString();
            manager.importClientsData(url);
            manager.saveClientsData();
        }else{
            System.out.println("No funciona rey");
        }
        setupClientsAddClientsScreen();
    }

    public void setupAddEmployeeScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDEMPLOYEE_FXML));
        fxmlLoader.setController(this);
        Parent addemployee = fxmlLoader.load();

        bpPaneAdd.setCenter(addemployee);

        employees = FXCollections.observableArrayList(manager.getEmployees());
        tcFirstNameAddEmployee.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastNameAddEmployee.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcIdAddEmployee.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvEmployeesAddEmployee.setItems(employees);
    }

    public void setupAddIngredientScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDINGREDIENT_FXML));
        fxmlLoader.setController(this);
        Parent addingredient = fxmlLoader.load();

        bpPaneAdd.setCenter(addingredient);

        ingredients = FXCollections.observableArrayList(manager.getIngredients());
        tcNameAddIngredient.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvIngredientsAddIngredient.setItems(ingredients);
    }

    public void setupAddTypeScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADDTYPE_FXML));
        fxmlLoader.setController(this);
        Parent addtype = fxmlLoader.load();

        bpPaneAdd.setCenter(addtype);

        types = FXCollections.observableArrayList(manager.getFoodTypes());
        tcNameAddType.setCellValueFactory(new PropertyValueFactory<>("name"));
        tvTypesAddType.setItems(types);
    }

    @FXML
    public void actEditAddClient(MouseEvent event) {
        if(event.getClickCount() == 2){
            tfFirstNameAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getFirstName());
            tfLastNameAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getLastName());
            tfIdAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getId());
            tfAddressAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getAddress());
            tfTelAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getTel());
            taObservationsAddClient.setText(tvClientsAddClient.getSelectionModel().getSelectedItem().getObservations());

            btnAddClientAddClient.setText("Editar");
        }
    }

    @FXML
    public void actImportEmployeesAddEmployees(ActionEvent event) {

    }

    @FXML
    public void actEditIngredientAddIngredient(MouseEvent event) {
        if(event.getClickCount() == 2){
            tfNameAddIngredient.setText(tvIngredientsAddIngredient.getSelectionModel().getSelectedItem().getName());

            btnAddIngredientAddIngredient.setText("Editar");
        }
    }

    @FXML
    public void actEditEmployeeAddEmployee(MouseEvent event) {
        if(event.getClickCount() == 2){
            tfFirstNameAddEmployee.setText(tvEmployeesAddEmployee.getSelectionModel().getSelectedItem().getFirstName());
            tfLastNameAddEmployee.setText(tvEmployeesAddEmployee.getSelectionModel().getSelectedItem().getLastName());
            tfIdAddEmployee.setText(tvEmployeesAddEmployee.getSelectionModel().getSelectedItem().getId());

            btnAddEmployeeAddEmployee.setText("Editar");
        }
    }

    @FXML
    void actEditTypeAddType(MouseEvent event) {
        if(event.getClickCount() == 2){
            tfNameAddType.setText(tvTypesAddType.getSelectionModel().getSelectedItem().getName());

            btnAddTypeAddType.setText("Editar");
        }
    }

    @FXML
    void miOrderTableMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TABLEORDER_FXML));
        fxmlLoader.setController(this);
        Parent tableorder = fxmlLoader.load();

        bpPaneMain.setCenter(tableorder);
        //System.out.println(manager.getOrders().get(0));
        setupTableOrder();
    }

    @FXML
    void miProductTableMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TABLEPRODUCT_FXML));
        fxmlLoader.setController(this);
        Parent tableproduct = fxmlLoader.load();

        bpPaneMain.setCenter(tableproduct);
        setupTableProduct();
    }

    public void setupTableProduct() throws IOException {
        productItems = FXCollections.observableArrayList(manager.productToProductItem(manager.getProducts()));

        tvProductsTProduct.setItems(productItems);


        //System.out.println(manager.productToProductItem(manager.getProducts()).get(3));
        //System.out.println(productItems.get(5).getIngredients().get(3));


        tcProductTProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcTypeTProduct.setCellValueFactory(new PropertyValueFactory<>("foodType"));
        tcSizeTProduct.setCellValueFactory(new PropertyValueFactory<>("size"));
        tcPriceTProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
        setupButtonToTableProduct();
    }

    public void setupButtonToTableProduct() throws IOException{
        Callback<TableColumn<ProductItem, Void>, TableCell<ProductItem, Void>> cellFactory = new Callback<TableColumn<ProductItem, Void>, TableCell<ProductItem, Void>>() {
            @Override
            public TableCell<ProductItem, Void> call(final TableColumn<ProductItem, Void> param) {
                final TableCell<ProductItem, Void> cell = new TableCell<ProductItem, Void>() {

                    private final Button btn = new Button("Ver");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            try {
                                productItems = FXCollections.observableArrayList(manager.actualizeProductItemIngredientsList(productItems));
                                //TODO: CHECK THIS OUT
                                showEmergentIngredients();
                                setupTableViewWindowIngredients(getTableView().getItems().get(getIndex()).getIngredients());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setGraphic(null);
                        } else{
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        tcIngredientsTProduct.setCellFactory(cellFactory);
    }

    public void showEmergentIngredients() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("windowIngredients.fxml"));
        fxmlLoader.setController(this);
        Parent window = fxmlLoader.load();

        Scene scene = new Scene(window);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Ingredientes");
        stage.show();
    }

    public void setupTableViewWindowIngredients(List<Ingredients> ingredients){
        windowTempIngredients = FXCollections.observableArrayList(ingredients);
        tvIngredientsWindowIngredients.setItems(windowTempIngredients);
        tcIngredientsWindowIngredients.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @FXML
    public void actAddOrderOrder(ActionEvent event) {
        String code = tfCodeOrder.getText();
        List<OrderMenuItem> items = tvOrdersOrder.getItems();
        Date time = manager.getTime();
        String observations = taObservationsAddOrder.getText();
        manager.addOrder(code, items, time, observations, manager.findEmployee(cbEmployeeOrder.getSelectionModel().getSelectedItem()), manager.findClient(cbClientOrder.getSelectionModel().getSelectedItem()));
    }

    @FXML
    public void actEditAmountAddOrder(TableColumn.CellEditEvent<OrderMenuItem, String> amountEdit) {
        orderItems.get(tvOrdersOrder.getSelectionModel().getSelectedIndex()).setAmount(amountEdit.getNewValue());
        Double uPrice = Double.parseDouble(orderItems.get(tvOrdersOrder.getSelectionModel().getSelectedIndex()).getPriceU());
        Double amount = Double.parseDouble(amountEdit.getNewValue());
        Double tPrice = uPrice*amount;
        orderItems.get(tvOrdersOrder.getSelectionModel().getSelectedIndex()).setPriceT(tPrice.toString());
        tvOrdersOrder.refresh();
    }

    public void setupTableOrder(){
        orders = FXCollections.observableArrayList();
        for(int i = 0; i < manager.getOrders().size(); i++){
            orders.add(manager.newObservableProduct(manager.getOrders().get(i).getCode(),
                    manager.getOrders().get(i).getItems(),
                    manager.getOrders().get(i).getTime(),
                    manager.getOrders().get(i).getObservations(),
                    manager.getOrders().get(i).getStatus(),
                    manager.getOrders().get(i).getDeliverer(),
                    manager.getOrders().get(i).getClient(),
                    manager.getOrders().get(i).gettPrice()));
        }
        tvOrdersTOrder.getItems().addAll(orders);
        tcCodeTOrder.setCellValueFactory(new PropertyValueFactory<>("code"));
        tcDateTOrder.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcEmployeeTOrder.setCellValueFactory(new PropertyValueFactory<>("employee"));
        tcClientTOrder.setCellValueFactory(new PropertyValueFactory<>("client"));
        tcTPriceTOrder.setCellValueFactory(new PropertyValueFactory<>("priceT"));
    }

    @FXML
    void actOrderAlphabeticalAddIngredient(ActionEvent event) throws IOException {
        manager.orderIngredientsByAlphabeticalOrder();
        setupAddIngredientScreen();

    }

}
