package com.mihailpetrov.repository;

import com.mihailpetrov.Database;
import com.mihailpetrov.contract.RepositoryInterface;
import com.mihailpetrov.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository implements RepositoryInterface<User> {

    private String table = "td_users";

    public ArrayList<User> fetchAll() {

        ArrayList<User> resultCollection = new ArrayList<>();

        ResultSet collection =  Database.getInstance().from(this.table)
                .select();

        try {

            while (collection.next()) {
                resultCollection.add(new User(
                        collection.getInt("id"),
                        collection.getString("username")
                ));
            }

            return resultCollection;
        }
        catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateEntity(User entity) {
        Database.getInstance()
                .set("username", entity.getUsername())
                .where("id", entity.getId())
                .update(this.table);
    }

    @Override
    public void removeEntity(User entity) {
        Database.getInstance()
                .where("id", entity.getId())
                .delete(this.table);
    }

    @Override
    public void createEntity(User entity) {
        Database.getInstance()
                .insert("id", entity.getId())
                .insert("username", entity.getUsername())
                .into(this.table);
    }
}
