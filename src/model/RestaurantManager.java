package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Restaurant manager.
 */
public class RestaurantManager {

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
    public boolean loadIngredientsData() throws IOException, ClassNotFoundException {
        file = new File(INGREDIENTS_PATH);
        boolean loaded = false;
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            ingredients = (List)ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
    }

    /**
     * Load product data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public boolean loadProductData() throws IOException, ClassNotFoundException {
        file = new File(PRODUCTS_PATH);
        boolean loaded = false;
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            products = (List)ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
    }

    /**
     * Load orders data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public boolean loadOrdersData() throws IOException, ClassNotFoundException {
        file = new File(ORDERS_PATH);
        boolean loaded = false;
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            orders = (List)ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
    }

    /**
     * Load clients data boolean.
     *
     * @return the boolean
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
    public boolean loadClientsData() throws IOException, ClassNotFoundException{
        file = new File(CLIENTS_PATH);
        boolean loaded = false;
        if(file.exists()){
            ois = new ObjectInputStream(new FileInputStream(file));
            clients = (List)ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
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
        if(ret){
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
        boolean ret = true; //if cant added return false
        for(int i = 0; i < ingredients.size() && ret; i++){
            if(ingredients.get(i).getName().equalsIgnoreCase(ingredientName)){
                ret = false;
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
        }
        return ret;
    }

    public OrderMenuItem newOrderMenuItem(Product product, Size size, double amount){
        OrderMenuItem item = new OrderMenuItem(activeUser, activeUser, product, size, amount);
        return item;
    }

    public Size findSize(Product product, String size){
        return product.findSize(size);
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
    public boolean addProduct(String name, String type, List<Ingredients> ingredients, List<Size> size){
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
     * @param oldName the old name
     * @param newName the new name
     * @return the boolean
     */
//Edit methods
    public boolean editIngredient(String oldName, String newName){
        boolean ret = false;
        for(int i = 0; i < ingredients.size() && !ret; i++){
            if(ingredients.get(i).getName().equals(newName)){
                ingredients.get(i).setName(newName);
                ret = true;
            }
        }
        return ret;
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
}
