package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

/**
 * The type Restaurant manager.
 */
public class RestaurantManager implements Serializable{

    public final static long serialVersionUID = 1;



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
        PrintWriter pw = new PrintWriter(fileName);

        for(int i = 0; i < employees.size(); i++){
            Employee employee = employees.get(i);
            double totalAmount = 0;
            for(int j = 0; j < orders.size(); j++){
                if(orders.get(j).getDeliverer().getId().equalsIgnoreCase(employee.getId())){
                    totalAmount += Double.parseDouble(orders.get(j).gettPrice());
                }
            }
            pw.println(employee.getFirstName()+delimeterChar+employee.getLastName()+delimeterChar+
                    employee.getId()+delimeterChar+employee.getReferences()+delimeterChar+totalAmount);
        }
        pw.close();
    }
    public void exportProductsData(String fileName, String delimeterChar, ArrayList<ArrayList> arraylist) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);

        ArrayList<String> arr = arraylist.get(0);
        ArrayList<String> arr2 = arraylist.get(1);
        ArrayList<Double> arr3 = arraylist.get(2);
        ArrayList<Double> arr4 = arraylist.get(3);

        for(int i = 0; i < arr.size(); i++){
            double var = (arr3.get(i)*arr4.get(i));
            pw.println(arr.get(i)+delimeterChar+arr2.get(i)+delimeterChar+arr3.get(i)+delimeterChar+var);
        }

        pw.close();
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
        line = br.readLine();
        //Add cleaning line
        while(line != null){
            line.replaceAll("\\s+", "");
            String[] parts = line.split(";");
            String name = parts[0];

            String type = parts[1];
            addFoodType(type);

            String[] ingredients1 = parts[2].split(",");
            ArrayList<Ingredients> productIngredients = new ArrayList<>();

            for(int i = 0; i < ingredients1.length; i++){
                //Ingredients ingredient = new Ingredients(activeUser, activeUser, ingredients[i].replace(" ",""));
                System.out.println(ingredients1[i]);
                addIngredient(ingredients1[i].replace(" ", ""));
                productIngredients.add(findIngredientByName(ingredients1[i].replace(" ","")));
            }

            String[] sizes = parts[3].split(",");
            String[] pricesForEachSize = parts[4].split(",");
            ArrayList<Size> productSizes = new ArrayList<>();
            for(int i = 0; i < sizes.length; i++){
                Size size = new Size(activeUser, activeUser, sizes[i].replace(" ", ""), Double.parseDouble(pricesForEachSize[i].replace(" ","")));
                productSizes.add(size);
            }

            addProduct(name, type, FXCollections.observableArrayList(productIngredients),FXCollections.observableArrayList(productSizes));
            line = br.readLine();
        }

    }
    public String productCode(){
        Instant time = Instant.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String timeWFormat = simpleDateFormat.format(Date.from(time));
        String code = (String.valueOf(timeWFormat.charAt(8))).concat(String.valueOf(timeWFormat.charAt(9))).concat(String.valueOf(timeWFormat.charAt(3))).
                concat(String.valueOf(timeWFormat.charAt(4))).concat(String.valueOf(timeWFormat.charAt(0))).concat(String.valueOf(timeWFormat.charAt(1))).
                concat(String.valueOf(orders.size()));
        return code;
    }


    public void importOrdersData(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        //ArrayList<Order> orders2 = new ArrayList<>();
        String line = br.readLine();
        line = br.readLine();
        while(line != null){
            String[] parts = line.split(",");

            Date aDate = new Date(parts[0]);
            Status aStatus = Status.valueOf(parts[1]);

            addEmployee(parts[2], parts[3], parts[4]);
            Employee aEmployee = new Employee(activeUser, activeUser, parts[2], parts[3], parts[4]);


            addClient(parts[5], parts[6], parts[7], parts[8], parts[9],"");
            Client aClient = findClientById(Integer.parseInt(parts[7]));

            String productName = parts[10];
            String type = parts[11];
            boolean foodTypeAdded = addFoodType(type);
            FoodType fType = null;
            if(foodTypeAdded){
                 fType = findTypeByName(type);
            }



            String[] ingredients = parts[15].split("\\|");
            ArrayList<Ingredients> productIngredients = new ArrayList<>();
            for(int i = 0; i < ingredients.length; i++){
                Ingredients aIngredient = new Ingredients(activeUser, activeUser, ingredients[i]);
                boolean ingredientCreated = addIngredient(ingredients[i]);
                if(ingredientCreated){
                    productIngredients.add(aIngredient);
                }else{
                    aIngredient = findIngredientByName(ingredients[i]);
                    productIngredients.add(aIngredient);
                }
            }

            String[] sizes = parts[16].split("\\|");
            String[] prices = parts[17].split("\\|");
            ArrayList<Size> productSizes = new ArrayList<>();
            for(int i = 0; i < sizes.length; i++){
                Size aSize = new Size(activeUser, activeUser, sizes[i], Double.parseDouble(prices[i]));
                productSizes.add(aSize);
            }

            String code = productCode();

            Product aProduct = new Product(activeUser, activeUser,productName,fType,
                    FXCollections.observableArrayList(productIngredients), FXCollections.observableArrayList(productSizes));
            addProduct(productName,type,
                    FXCollections.observableArrayList(productIngredients), FXCollections.observableArrayList(productSizes));
            ArrayList<OrderMenuItem> orderMenuItems = new ArrayList<>();
            for(int i = 0; i < productSizes.size(); i++){
                OrderMenuItem orderMenuItem = new OrderMenuItem(activeUser, activeUser, aProduct, productSizes.get(i), Double.parseDouble(parts[18]));
                orderMenuItems.add(orderMenuItem);
            }

            addOrder(code, orderMenuItems,aDate, "", aEmployee, aClient);
            orders.get(orders.size()-1).setStatus(aStatus);

            Instant time = Instant.now();
            Date date = Date.from(time);
            line = br.readLine();

        }
        br.close();
    }


//Serializable

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

        if(ingredients.isEmpty()){
            ingredient.setCreator(activeUser);
            ingredient.setModifier(activeUser);
            ingredients.add(ingredient);
        }else{
            boolean ret = false; //if cant added return false
            for(int i = 0; i < ingredients.size() && !ret; i++){
                if(ingredients.get(i).getName().equalsIgnoreCase(ingredientName) && !ingredientName.equals("")){
                    ret = true;
                }
            }
            if(!ret){
                ingredient.setCreator(activeUser);
                ingredient.setModifier(activeUser);
                ingredients.add(ingredient);
            }
        }


        return true;
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
            clients.get(findClientByIdIndex(Integer.parseInt(client.getId()))).setReferences(clients.get(findClientByIdIndex(Integer.parseInt(client.getId()))).getReferences() + 1);
            employees.get(findEmployeeIndex(deliverer.getFirstName() + " " + deliverer.getLastName())).setReferences(employees.get(findEmployeeIndex(deliverer.getFirstName() + " " + deliverer.getLastName())).getReferences() + 1);
            for(int i = 0; i<items.size(); i++){
                products.get(findProductIndex(items.get(i).getProductName())).setReferences(products.get(findProductIndex(items.get(i).getProductName())).getReferences() + 1);
            }
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

    public FoodType findTypeByName(String name){
        for(int i = 0; i < foodTypes.size(); i++){
            if(foodTypes.get(i).getName().equals(name)){
                return foodTypes.get(i);
            }
        }
        return null;
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

    public int findEmployeeIndex(String name){
        int index = 0;
        boolean found = false;
        String eName = "";
        for(int i = 0; i<employees.size() && !found; i++){
            eName = employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
            if(eName.equals(name)){
                found = true;
                index = i;
            }
        }
        return index;
    }
    public Ingredients findIngredientByName(String name){
        for(int i = 0; i < ingredients.size(); i++){
            if(ingredients.get(i).getName().equals(name)){
                return ingredients.get(i);
            }
        }
        return null;
    }

    public int findIngredientIndexByName(String name){
        for(int i = 0; i < ingredients.size(); i++){
            if(ingredients.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
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

    public int findIndexType(String typeName){
        int index = 0;
        boolean found = false;
        for(int i = 0; i<foodTypes.size() && !found; i++){
            if(foodTypes.get(i).getName().equals(typeName)){
                index = i;
                found = true;
            }
        }
        return index;
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
            for(int i = 0; i<ingredients.size(); i++){
                findIngredientByName(ingredients.get(i).getName()).setReferences(findIngredientByName(ingredients.get(i).getName()).getReferences() + 1);
            }
            findTypeByName(foodType.getName()).setReferences(findTypeByName(foodType.getName()).getReferences() + 1);
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

        boolean out = true;
        for(int i = 0; i < ingredients.size(); i++){
            if(index != i && ingredients.get(i).getName().equalsIgnoreCase(newName)){
                out = false;
            }
        }
        if(out){
            ingredients.get(index).setModifier(activeUser);
            ingredients.get(index).setName(newName);
        }
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

    public void editProduct(int index, String productName, String foodType, ObservableList<Ingredients> ingredients, ObservableList<Size> sizes){
        boolean found = false;
        FoodType type = null;
        for(int i = 0; i<foodTypes.size() && !found; i++){
            if(foodTypes.get(i).getName().equals(foodType)){
                type = foodTypes.get(i);
                found = true;
            }
        }
        Product product = products.get(index);
        product.setName(productName);
        if(!product.getType().getName().toString().equals(type.getName().toString())){
            findTypeByName(product.getType().getName()).setReferences(findTypeByName(product.getType().getName()).getReferences() - 1);
            product.setType(findTypeByName(product.getType().getName()));
        }
        for(int i = 0; i<product.getIngredients().size(); i++){
            findIngredientByName(product.getIngredients().get(i).getName()).setReferences(findIngredientByName(product.getIngredients().get(i).getName()).getReferences() - 1);
        }
        product.setIngredients(new ArrayList<>(ingredients));
        for(int i = 0; i<ingredients.size(); i++){
            findIngredientByName(ingredients.get(i).getName()).setReferences(findIngredientByName(ingredients.get(i).getName()).getReferences() + 1);
        }
        for(int i = 0; i< product.getSizes().size(); i++){
            findSize(findProduct(product.getName()),product.getSizes().get(i).getSize()).setReferences(findSize(findProduct(product.getName()),product.getSizes().get(i).getSize()).getReferences() - 1);
        }
        product.setSizes(new ArrayList<Size>(sizes));
        for(int i = 0; i<sizes.size(); i++){
            findSize(findProduct(product.getName()), sizes.get(i).getSize()).setReferences(findSize(findProduct(product.getName()), sizes.get(i).getSize()).getReferences() + 1);
        }
        products.set(index, product);
        System.out.println("si funciono menor");
    }

    public void editOrder(int index, List<OrderMenuItem> items, Date time, String observations, Employee deliverer, Client client){
        Order order = orders.get(index);
        order.setItems(new ArrayList<>(items));
        order.setTime(time);
        order.setObservations(observations);
        order.setDeliverer(deliverer);
        order.setClient(client);
        orders.set(index, order);
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

    public int findOrderIndex(String code){
        boolean found = false;
        int index = 0;
        for(int i = 0; i<orders.size() && !found; i++){
            if(orders.get(i).getCode().equals(code)){
                index = i;
                found = true;
            }
        }
        return index;
    }

    public Order findOrder(String code){
        boolean found = false;
        Order order = null;
        for(int i = 0; i<orders.size() && !found; i++){
            if(orders.get(i).getCode().equals(code)){
                order = orders.get(i);
                found = true;
            }
        }
        return order;
    }

    public void orderIngredientsByAlphabeticalOrder(){
        Comparator<Ingredients> ingredientsOrder = (aIngredient, bIngredient) -> aIngredient.getName().compareToIgnoreCase(bIngredient.getName());
        ingredients.sort(ingredientsOrder);
    }

    public List<ProductItem> sortedListOfProductsByPrice(ObservableList<ProductItem> products){
        Comparator<ProductItem> productsOrder = (aProduct, bProduct) -> (int)(Double.parseDouble(aProduct.getPrice())-Double.parseDouble(bProduct.getPrice()));
        products.sort(productsOrder);
        return products;
    }

    public Client findClientById(int clientId){
        //Implement binary search
        Comparator<Client> clientOrder = (aClient, bClient) -> (int) (Long.parseLong(aClient.getId())-Long.parseLong(bClient.getId()));
        List<Client> clientsCopy = clients;

        //Selection sort by id
        for(int i = 0; i < clientsCopy.size(); i++){
            Client min = clientsCopy.get(i);
            for(int j = i+1; j < clientsCopy.size(); j++){
                if(clientOrder.compare(clientsCopy.get(j),min) < 0){
                    Client temp = clientsCopy.get(j);
                    clientsCopy.set(j,min);
                    min = temp;
                }
            }
            clientsCopy.set(i, min);
        }

        int id = clientId;
        int k = 0;
        int h = clients.size()-1;
        int pos = -1;

        while(k <= h && pos<0){
            int m = (k+h)/2;
            if(Integer.parseInt(clientsCopy.get(m).getId()) == id){
                pos = m;

            }else if(Integer.parseInt(clientsCopy.get(m).getId()) < id){
                k = m + 1;
            }else{
                h = m - 1;
            }
        }

        if(pos == -1){
            return null;
        }else{
            return clientsCopy.get(pos);
        }
    }

    public int findClientByIdIndex(int clientId){
        boolean found = false;
        int index = 0;
        for(int i = 0; i<clients.size() && !found; i++){
            if(Integer.parseInt(clients.get(i).getId()) == clientId){
                index = i;
                found = true;
            }
        }
        return index;
    }

    public ArrayList<String> clientsAtributes(Client aClient){
        ArrayList<String> clientParts = new ArrayList<>();
        System.out.println(aClient.getFirstName());
        if(aClient != null){
            clientParts.add(aClient.getFirstName());
            clientParts.add(aClient.getLastName());
            clientParts.add(aClient.getAddress());
            clientParts.add(aClient.getTel());
            clientParts.add(aClient.getObservations());
        }
        return clientParts;
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
