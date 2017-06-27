package com.epam.utils;

import com.epam.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Администратор on 13.06.2017.
 */
public class Discharge {
    public static List<User> dischargeList = new ArrayList();

    public static void addUser(User user){
        dischargeList.add(user);
    }

    public static boolean checkUser(User user){
        for (int i = 0; i < dischargeList.size(); i++) {
            if (user.getId()==dischargeList.get(i).getId())
                return true;
        }
        return false;
    }

    public static void deleteUser(User user){
        for (int i = 0; i < dischargeList.size(); i++) {
            if (user.getId()==dischargeList.get(i).getId())
                dischargeList.remove(i);
        }
    }

    public static String chooseMessage(String locale){
        ResourceBundle properties;
        if (locale.equals("en_EN")) {
            properties = ResourceBundle.getBundle("messages_en_EN");
            return properties.getString("discharged");
        } else {
            properties = ResourceBundle.getBundle("messages_ru_RU");
            return properties.getString("discharged");
        }
    }

}
