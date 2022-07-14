package com.mihailpetrov.contract;

import java.util.ArrayList;

public interface RepositoryInterface<T> {

    public ArrayList<T> fetchAll();

    public void updateEntity(T entity);

    public void removeEntity(T entity);

    public void createEntity(T entity);
}
