package com.mihailpetrov;

import com.mihailpetrov.contracts.List;
import com.mihailpetrov.listfactory.ListFactory;
import com.mihailpetrov.lists.CustomArrayList;
import com.mihailpetrov.model.User;

public class Application {

    public static void main(String[] args) {

        List<User> collection = new CustomArrayList();
        collection.add(new User("mihail", 30, "mihail@mail.bg"));
        collection.add(new User("todor", 40, "todor@mail.bg"));
        collection.add(new User("petar", 50, "petar@mail.bg"));

        User element = collection.get(0);
        System.out.println(element.getUsername());

    }
}
