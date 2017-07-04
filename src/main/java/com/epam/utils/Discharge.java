package com.epam.utils;

import com.epam.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Discharge {
    /**
     * list of discharged patients
     */
    private static ArrayList<User> dischargeList = new ArrayList();

    /**
     * add to list
     *
     * @param user user
     */
    public static void addUser(User user) {
        dischargeList.add(user);
    }

    /**
     * find user in list
     *
     * @param user user
     * @return true if user has been found
     */
    public static boolean checkUser(User user) {
        for (User aDischargeList : dischargeList) {
            if (user.getId() == aDischargeList.getId())
                return true;
        }
        return false;
    }

    /**
     * delete user from discharged list
     *
     * @param user
     *          user
     */
    public static void deleteUser(User user) {
        for (int i = 0; i < dischargeList.size(); i++) {
            if (user.getId() == dischargeList.get(i).getId())
                dischargeList.remove(i);
        }
    }

    /**
     * choose message
     *
     * @param locale locale from page
     * @return message
     */
    public static String chooseMessage(String locale) {
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
