package com.epam.dao;

import java.util.List;

/**
 * Created by Администратор on 23.05.2017.
 */
public interface Dao<T, TKey> {
    T IdFind(TKey id);
    void idDelete(TKey id);
    List<T>findAll();
}
