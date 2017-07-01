package com.epam.dao;

import java.util.List;

public interface Dao<T, TKey> {
    T idFind(TKey id);
    void idDelete(TKey id);
    List<T>findAll();
}
