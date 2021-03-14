package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    public final static String INGREDIENTS_PATH = "data/ingredients.cd";
    public final static String PRODUCTS_PATH = "data/products.cd";
    public final static String ORDERS_PATH = "data/orders.cd";
    public final static String CLIENTS_PATH = "data/clients.cd";
    public final static String FOODTYPES_PATH = "data/foodTypes.cd";
    public final static String USERS_PATH = "data/users.cd";

    private ObjectOutputStream oss;
    ObjectInputStream ois;
    File file;

    private List<Ingredients> ingredients;
    private List<Product> products;
    private List<Order> orders;
    private List<Client> clients;
    private List<FoodType> foodTypes;
    private List<User> users;
    private List<Employee> employees;
    //Active user
    private User activeUser;

    public RestaurantManager(){
        ingredients = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        clients = new ArrayList<>();
        foodTypes = new ArrayList<>();
        users = new ArrayList<>();
        employees = new ArrayList<>();
    }

    //Serializable
    public void saveIngredientsData() throws IOException {
        oss = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_PATH));
        oss.writeObject(ingredients);
        oss.close();
    }
    public void saveProductData() throws IOException {
        oss = new ObjectOutputStream(new FileOutputStream(PRODUCTS_PATH));
        oss.writeObject(products);
        oss.close();
    }
    public void saveOrdersData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(ORDERS_PATH));
        oss.writeObject(orders);
        oss.close();
    }
    public void saveClientsData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(CLIENTS_PATH));
        oss.writeObject(clients);
        oss.close();
    }
    public void saveFoodTypesData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(FOODTYPES_PATH));
        oss.writeObject(foodTypes);
        oss.close();
    }
    public void saveUsersData() throws IOException{
        oss = new ObjectOutputStream(new FileOutputStream(USERS_PATH));
        oss.writeObject(users);
        oss.close();
    }

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
    public boolean laodOrdersData() throws IOException, ClassNotFoundException {
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
    public boolean activeUSer(String username, String password){
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

    public boolean addUser(String firstName, String lastName, String id, String userName, String password){
        boolean ret = true;
        User user = new User(firstName, lastName, id, userName, password);
        for(int i = 0; i < employees.size() && ret; i++){
            if(employees.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(ret){
            user.setCreator(user);
            employees.add(user);
            users.add(user);
        }
        return ret;
    }
    public boolean addIngredient(String ingredientName){
        Ingredients ingredient = new Ingredients(ingredientName);
        boolean ret = true; //if cant added return false
        for(int i = 0; i < ingredients.size() && ret; i++){
            if(ingredients.get(i).getName().equals(ingredientName)){
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
    //Todo: Add the sortde added method
    public boolean addClient(String firstName, String lastName, String id, String address, String tel, String observations){
        boolean ret = true;
        Client client = new Client(firstName, lastName, id, address, tel, observations);
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(ret){
            client.setCreator(activeUser);
            client.setModifier(activeUser);
            clients.add(client);
        }
        return ret;
    }
    public boolean addOrder(){
        boolean ret = true;

        return ret;
    }
//String name, FoodType type, ArrayList<Ingredients> ingredients, ArrayList<String> size
//ArrayList<Double> price
    public boolean addProduct(String name, String type, ArrayList<String> ingredients, ArrayList<String> size,
    ArrayList<Double> price){
        boolean ret = true;
        FoodType foodType;
        for(int i = 0; i < foodTypes.size(); i++){
            if(foodTypes.get(i).getName().equals(type)){
                foodType = foodTypes.get(i);
            }
        }

        //for(int i = 0; i < )
        return ret;
    }

    // Delete methods
    public boolean deleteProduct(){
        boolean ret = true;

        return ret;
    }
    public boolean deleteClient(){
        boolean ret = true;

        return ret;
    }
    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
