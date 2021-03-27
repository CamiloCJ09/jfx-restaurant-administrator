package model;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.*;

/**
 * The type Restaurant manager.
 */
public class RestaurantManager {

    public final static String EMPLOYEES_PATH = "data/employees.cd";
    /**
     * The constant INGREDIENTS_PATH.
     */
    public final static String INGREDIENTS_PATH = "data/ingredients.cd";
    /**
     * The constant PRODUCTS_PATH.
     */
    public final static String PRODUCTS_PATH = "data/products.cd";
    /**
     * The constant ORDERS_PATH.
     */
    public final static String ORDERS_PATH = "data/orders.cd";
    /**
     * The constant CLIENTS_PATH.
     */
    public final static String CLIENTS_PATH = "data/clients.cd";
    /**
     * The constant FOODTYPES_PATH.
     */
    public final static String FOODTYPES_PATH = "data/foodTypes.cd";
    /**
     * The constant USERS_PATH.
     */
    public final static String USERS_PATH = "data/users.cd";

    private ObjectOutputStream oss;
    /**
     * The Ois.
     */
    private ObjectInputStream ois;
    /**
     * The File.
     */
    private File file;

    private List<Ingredients> ingredients;
    private List<Product> products;
    private List<Order> orders;
    private List<Client> clients;
    private List<FoodType> foodTypes;
    private List<User> users;
    private List<Employee> employees;
    //Active user
    private User activeUser;

    private Date time;

    /**
     * Instantiates a new Restaurant manager.
     */
    public RestaurantManager(){
        ingredients = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        clients = new ArrayList<>();
        foodTypes = new ArrayList<>();
        users = new ArrayList<>();
        employees = new ArrayList<>();
    }



    public void exportEmployeesData(String fileName, String delimeterChar) throws FileNotFoundException {

    }
    public void exportProductsData(String fileName, String delimeterChar) throws FileNotFoundException {

    }
    public void exportOrderData(String fileName, String delimeterChar) throws FileNotFoundException {

    }

    public void importClientsData(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine(); //Clean first line
        line = br.readLine();
        while(line != null){
            String[] parts = line.split(","); //CHANGE THE SPLIT CHARACTER
            String firstName = parts[0];
            String lastName = parts[1];
            String id = parts[2];
            String address = parts[3];
            String tel = parts[4];
            String observations = "";

            addClient(firstName, lastName, id, address, tel, observations);
            line = br.readLine();
        }
    }

    public void importProductsData(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        //Add cleaning line
        while(line != null){
            String[] parts = line.split(";");
            String name = parts[0];
            String type = parts[1];
            String[] ingredients = parts[2].split("\\|");
            //Todo: Complete
            line = br.readLine();
        }

    }

    /**
     * Save ingredients data.
     *
     * @throws IOException the io exception
     */
//Serializable
    public void saveIngredientsData() throws IOException {
        oss = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_PATH));
        oss.writeObject(ingredients);
        oss.close();
    }

    /**
     * Save product data.
     *
     * @throws IOException the io exception
     */
    public void saveProductData() throws IOException {
        oss = new ObjectOutputStream(new FileOutputStream(PRODUCTS_PATH));
        oss.writeObject(products);
        oss.close();
    }

    /**
     * Save orders data.
     *
     * @throws IOException the io exception
     */
    public void saveOrdersData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(ORDERS_PATH));
        oss.writeObject(orders);
        oss.close();
    }

    /**
     * Save clients data.
     *
     * @throws IOException the io exception
     */
    public void saveClientsData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(CLIENTS_PATH));
        oss.writeObject(clients);
        oss.close();
    }

    /**
     * Save food types data.
     *
     * @throws IOException the io exception
     */
    public void saveFoodTypesData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(FOODTYPES_PATH));
        oss.writeObject(foodTypes);
        oss.close();
    }

    /**
     * Save users data.
     *
     * @throws IOException the io exception
     */
    public void saveUsersData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(USERS_PATH));
        oss.writeObject(users);
        oss.close();
    }
    public void saveEmployeesData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(EMPLOYEES_PATH));
        oss.writeObject(employees);
        oss.close();
    }

    public void loadUsersData() throws IOException, ClassNotFoundException {
        file = new File(USERS_PATH);
        //boolean loaded = false;
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            users = (List)ois.readObject();
            ois.close();
            //loaded = true;
        }
        //return loaded;
    }

    /**
     * Load ingredients data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
//Load data
    public void loadIngredientsData() throws IOException, ClassNotFoundException {
        file = new File(INGREDIENTS_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            ingredients = (List)ois.readObject();
            ois.close();
        }
    }

    /**
     * Load product data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadProductData() throws IOException, ClassNotFoundException {
        file = new File(PRODUCTS_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            products = (List)ois.readObject();
            ois.close();
        }
    }

    /**
     * Load orders data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadOrdersData() throws IOException, ClassNotFoundException {
        file = new File(ORDERS_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            orders = (List)ois.readObject();
            ois.close();
        }
    }

    /**
     * Load clients data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void loadClientsData() throws IOException, ClassNotFoundException{
        file = new File(CLIENTS_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            clients = (List)ois.readObject();
            ois.close();
        }
    }

    public void loadEmployeeData() throws IOException, ClassNotFoundException{
        file = new File(EMPLOYEES_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            employees = (List)ois.readObject();
            ois.close();
        }
    }

    public void loadFoodTypeData() throws IOException, ClassNotFoundException{
        file = new File(FOODTYPES_PATH);
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            foodTypes = (List)ois.readObject();
            ois.close();
        }
    }

    /**
     * Active u ser boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public boolean activeUser(String username, String password){
        boolean ret = false;
        for(int i = 0; i < users.size() && !ret; i++){
            if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)){
                activeUser = users.get(i);
                ret = true;
            }
        }
        return ret;
    }

    //Add methods

    /**
     * Add user boolean.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param id        the id
     * @param userName  the user name
     * @param password  the password
     * @return the boolean
     */
    public boolean addUser(String firstName, String lastName, String id, String userName, String password){
        boolean ret = true;
        User user = new User(activeUser, activeUser, firstName, lastName, id, userName, password);
        for(int i = 0; i < employees.size() && ret; i++){
            if(employees.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(ret && (!firstName.equals("")&&!lastName.equals("")&&!id.equals("")
                &&!userName.equals("")&&!password.equals(""))){
            employees.add(user);
            users.add(user);
        }
        return ret;
    }

    /**
     * Add ingredient boolean.
     *
     * @param ingredientName the ingredient name
     * @return the boolean
     */
    public boolean addIngredient(String ingredientName){
        Ingredients ingredient = new Ingredients(activeUser, activeUser, ingredientName);
        boolean ret = false; //if cant added return false
        for(int i = 0; i < ingredients.size() && !ret; i++){
            if(ingredients.get(i).getName().equalsIgnoreCase(ingredientName) && !ingredientName.equals("")){
                ret = true;
            }
        }
        if(ret){
            ingredient.setCreator(activeUser);
            ingredient.setModifier(activeUser);
            ingredients.add(ingredient);
        }
        return ret;
    }

    /**
     * Add food type boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean addFoodType(String name){
        boolean ret = true;
        FoodType foodType = new FoodType(activeUser, activeUser, name);
        for(int i = 0; i < foodTypes.size(); i++){
            if(foodTypes.get(i).getName().equals(name)){
                ret = false;
            }
        }
        if(ret){
            foodTypes.add(foodType);
        }
        return ret;
    }

    /**
     * Add client boolean.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param id           the id
     * @param address      the address
     * @param tel          the tel
     * @param observations the observations
     * @return the boolean
     */
    public boolean addClient(String firstName, String lastName, String id, String address, String tel, String observations){
        boolean ret = true;
        Client client = new Client(activeUser, activeUser, firstName, lastName, id, address, tel, observations);
        for(int i = 0; i < clients.size() && ret; i++){
            if(clients.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(ret){
            if(clients.isEmpty()){
                clients.add(client);
            }else{
                int i = 0;
                while(i < clients.size() && client.compareTo(clients.get(i))>0){
                    i++;
                }
                clients.add(i, client);
            }

        }
        return ret;
    }

    /**
     * Add employee boolean.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param id        the id
     * @return the boolean
     */
    public boolean addEmployee(String firstName, String lastName, String id){
        boolean ret = true;
        Employee employee = new Employee(activeUser, activeUser, firstName,lastName, id);
        for(int i = 0; i < employees.size() && ret; i++){
            if(employees.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(ret){
            employees.add(employee);
        }
        return ret;
    }

    /**
     * Add order boolean.
     *
     * @param code         the code
     * @param time         the time
     * @param observations the observations
     * @param deliverer    the deliverer
     * @param client       the client
     * @return the boolean
     */
    public boolean addOrder(String code, List<OrderMenuItem> items, Date time, String observations, Employee deliverer, Client client){
        boolean ret = true;
        Order order = new Order(activeUser, activeUser, code, items, time, observations, deliverer, client);
        for(int i = 0; i < orders.size() && ret; i++){
            if(orders.get(i).getCode().equals(code)){
                ret = false;
            }
        }
        if(ret){
            orders.add(order);
            System.out.println("creadita papa");
        }
        return ret;
    }

    public OrderMenuItem newOrderMenuItem(Product product, Size size, double amount){
        OrderMenuItem item = new OrderMenuItem(activeUser, activeUser, product, size, amount);
        return item;
    }

    public ObservableOrder newObservableProduct(String code, List<OrderMenuItem> items, Date date, String observations, Status status, Employee employee, Client client, String tPrice){
        ObservableOrder product = new ObservableOrder(activeUser, activeUser, code, items, date, observations, status, employee, client, tPrice);
        return product;
    }

    public Size findSize(Product product, String size){
        return product.findSize(size);
    }

    public Employee findEmployee(String name){
        Employee employee = null;
        boolean found = false;
        String eName = "";
        for(int i = 0; i<employees.size() && !found; i++){
            eName = employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
            if(eName.equals(name)){
                found = true;
                employee = employees.get(i);
            }
        }
        return employee;
    }

    public Client findClient(String name){
        Client client = null;
        boolean found = false;
        String cName = "";
        for(int i = 0; i<clients.size() && !found; i++){
            cName = clients.get(i).getFirstName() + " " + clients.get(i).getLastName();
            if(cName.equals(name)){
                found = true;
                client = clients.get(i);
            }
        }
        return client;
    }

    /**
     * Add product boolean.
     *
     * @param name        the name
     * @param type        the type
     * @param ingredients the ingredients
     * @param size        the size
     * @return the boolean
     */
    public boolean addProduct(String name, String type, ObservableList<Ingredients> ingredients, ObservableList<Size> size){
        boolean ret = true;
        FoodType foodType = null;
        for(int i = 0; i < foodTypes.size(); i++){
            if(type.equals(foodTypes.get(i).getName())){
                foodType = foodTypes.get(i);
            }
        }
        Product product = new Product(activeUser, activeUser, name, foodType, ingredients, size);
        for(int i = 0; i < products.size() && ret; i++){
            if(products.get(i).getName().equals(name)){
                ret = false;
            }
        }
        if(ret){
            products.add(product);
        }
        return ret;
    }

    public ArrayList<ProductItem> castToProductItem(Product product){
        ArrayList<ProductItem> items = new ArrayList<>();
        for(int i = 0; i < product.getSizes().size(); i++){
            items.add(new ProductItem(product.getCreator(), product.getModifier(), product, i));
        }
        return items;
    }

    public ArrayList<ProductItem> productToProductItem(List<Product> products){
        ArrayList<ProductItem> items = new ArrayList<>();
        for(int i = 0; i < products.size(); i++){
            ArrayList<ProductItem> tempItems = castToProductItem(products.get(i));
            for(int b = 0; b < tempItems.size(); b++){
                items.add(tempItems.get(b));
            }
        }
        return items;
    }

    public ObservableList<ProductItem> actualizeProductItemIngredientsList(ObservableList<ProductItem> listOfProductItems){
        for(int i = 0; i <  products.size(); i++){
            for(int j = 0; j < listOfProductItems.size(); j++){
                if(products.get(i).getName().equals(listOfProductItems.get(j).getName())){
                    listOfProductItems.get(j).setIngredients(products.get(i).getIngredients());
                }
            }
        }
        return listOfProductItems;
    }

    /**
     * Delete product boolean.
     *
     * @return the boolean
     */
// Delete methods
    public boolean deleteProduct(){
        boolean ret = true;

        return ret;
    }

    /**
     * Delete client boolean.
     *
     * @return the boolean
     */
    public boolean deleteClient(){
        boolean ret = true;

        return ret;
    }

    /**
     * Edit ingredient boolean.
     *
     * @param index the index
     * @param newName the new name
     * @return the boolean
     */
//Edit methods
    public void editIngredient(int index, String newName){
        for(int i = 0; i < products.size(); i++){
            for(int j = 0; j < products.get(i).getIngredients().size(); j++){
                if(products.get(i).getIngredients().get(j).getName().equals(ingredients.get(index).getName())){
                    products.get(i).getIngredients().set(j, ingredients.get(index));
                }
            }
        }
        ingredients.get(index).setModifier(activeUser);
        ingredients.get(index).setName(newName);
    }

    public void editClient(int index, String firstName, String lastName, String id, String address, String tel, String observations){
        Client client = clients.get(index);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setId(id);
        client.setAddress(address);
        client.setTel(tel);
        client.setObservations(observations);
        client.setModifier(activeUser);
        clients.set(index, client);
    }

    public void editEmployee(int index, String firstName, String lastName, String id){
        Employee employee = employees.get(index);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setId(id);
        employee.setModifier(activeUser);
        employees.set(index, employee);
    }

    public void editType(int index, String name){
        FoodType type = foodTypes.get(index);
        type.setName(name);
        type.setModifier(activeUser);
        foodTypes.set(index, type);
    }

    /**
     * New size size.
     *
     * @param size  the size
     * @param price the price
     * @return the size
     */
    public Size newSize(String size, double price){
        return new Size(activeUser, activeUser,size, price);
    }

    //Other methods
    public Product findProduct(String productName){
        Product tempProduct = null;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(productName)){
                tempProduct = products.get(i);
            }
        }
        return tempProduct;
    }

    public int findProductIndex(String productName){
        int index = 0;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().equals(productName)){
                index = i;
            }
        }
        return index;
    }


    public void orderIngredientsByAlphabeticalOrder(){
        Comparator<Ingredients> ingredientsOrder = (aIngredient, bIngredient) -> aIngredient.getName().compareToIgnoreCase(bIngredient.getName());
        ingredients.sort(ingredientsOrder);
    }

    public Client findClientById(int clientId){
        //Implement binary search
        int id = clientId;
        int k = 0;
        int h = clients.size();
        int pos = -1;

        while(k <= h && pos<0){
            int m = k + (h-1)/2;

            if(Integer.parseInt(clients.get(m).getId()) == id){
                pos = m;
            }else if(Integer.parseInt(clients.get(m).getId()) < id){
                k = m + 1;
            }else{
                h = m - 1;
            }
        }

        if(pos == -1){
            return null;
        }else{
            return clients.get(pos);
        }
    }






    /////////////////// SETTERS AND GETTERS ///////////////////////////


    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Gets food types.
     *
     * @return the food types
     */
    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }

    /**
     * Sets food types.
     *
     * @param foodTypes the food types
     */
    public void setFoodTypes(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Gets active user.
     *
     * @return the active user
     */
    public User getActiveUser() {
        return activeUser;
    }

    /**
     * Sets active user.
     *
     * @param activeUser the active user
     */
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets employees.
     *
     * @param employees the employees
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Search ingredient ingredients.
     *
     * @param name the name
     * @return the ingredients
     */
    public Ingredients searchIngredient(String name){
        boolean found = false;
        Ingredients ingredient = null;
        for(int i = 0; i < ingredients.size() && !found; i++){
            if(ingredients.get(i).getName().equals(name)){
                ingredient = ingredients.get(i);
                found = true;
            }
        }
        return ingredient;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
