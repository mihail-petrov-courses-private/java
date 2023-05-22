package model;

import framework.db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product {

    private int id;
    private String title;
    private String description;
    private int price;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Product(int id, String title, String description, int price) {

        this.id             = id;
        this.title          = title;
        this.description    = description;
        this.price          = price;
    }

    public static ArrayList<Product> listAllProduct(int pageIndex, int pageLimit) {

        try {

            int pageOffset  = (pageIndex - 1) * pageLimit;
            ArrayList<Product> resultCollection = new ArrayList<>();
            ResultSet collection = Database.getInstance().select("products").limit(pageLimit, pageOffset).fetch();
            while(collection.next()) {
                resultCollection.add(new Product(   collection.getInt("id"              ),
                                                    collection.getString("title"        ),
                                                    collection.getString("description"  ),
                                                    collection.getInt("price"           )
                                      ));
            }

            return resultCollection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
