package com.mihailpetrov;

import com.mihailpetrov.model.User;
import com.mihailpetrov.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        // Query Builder - еквивалент
        // Database.getInstance().query("INSERT INTO td_users(id, username) VALUES(8, 'SPECIAL')");

        // CREATE
        // INSERT INTO td_users(id, username) VALUES(8, 'SPECIAL')
        Database.getInstance()
                .insert("id", 9)
                .insert("username", "NEW_DATA")
                .into("td_users");

        // READss
        // SELECT * FROM td_users -> .from("td_users").select();
        // SELECT c1, c2, c3 FROM td_users -> .from("td_users").select("c1", "c2", "c3");
        // SELECT c1, c2, c3 FROM td_users WHERE c1 = 10 -> .from("td_users").where("c1", 10).select("c1", "c2", "c3");
        ArrayList<User> collection = UserRepository.fetchAll();
        for(User element : collection) {
            System.out.println(element.getId() + " " + element.getUsername());
        }

        // UPDATE
        // UPDATE td_users SET username = 'SAMPLE_DATA' WHERE id = 9
//        Database.getInstance()
//                .set("username", "SAMPLE_DATA")
//                .where("id", "9")
//                .update("td_users");

        // DELETE
        // DELETE FROM td_users WHERE id = 9
//        Database.getInstance()
//                .where("id", 9)
//                .delete("td_users");
    }
}


















