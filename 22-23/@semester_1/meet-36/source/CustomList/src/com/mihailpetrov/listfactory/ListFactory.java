package com.mihailpetrov.listfactory;

import com.mihailpetrov.contracts.List;
import com.mihailpetrov.lists.CustomArrayList;
import com.mihailpetrov.lists.CustomLinkedList;

public class ListFactory {

    public static List getNewList() {
        // return new CustomArrayList();
        return new CustomLinkedList();
    }


}
