package model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    private List<Ingredients> ingredients;
    private List<Product> products;
    private List<Order> orders;
    private List<Client> clients;
    private List<FoodType> foodTypes;
    private List<User> users;
    //Active user
    private User activeUser;


    public RestaurantManager(){
        ingredients = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        clients = new ArrayList<>();
        foodTypes = new ArrayList<>();
        users = new ArrayList<>();
    }

    public boolean activeUSer(String username, String password){
        boolean ret = true;
        for(int i = 0; i < users.size() && ret; i++){
            if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)){
                activeUser = users.get(i);
                ret = false;
            }
        }
        return ret;
    }
    //Add methods
    public boolean addIngredient(String ingredientName){
        Ingredients ingredient = new Ingredients(ingredientName);
        boolean ret = true; //if cant added return false
        for(int i = 0; i < ingredients.size() && ret; i++){
            if(ingredients.get(i).getName().equals(ingredientName)){
                ret = false;
            }
        }
        if(!ret){
            ingredient.setCreator(activeUser);
            ingredient.setModifier(activeUser);
            ingredients.add(ingredient);
        }
        return ret;
    }
    public boolean addClient(String firstName, String lastName, String id, String address, String tel, String observations){
        boolean ret = true;
        Client client = new Client(firstName, lastName, id, address, tel, observations);
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getId().equals(id)){
                ret = false;
            }
        }
        if(!ret){
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

    public boolean addProduct(){

        boolean ret = true;
        return ret;
    }

    // Delete methods
    public boolean deleteProduct(){
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
}
