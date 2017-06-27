package com.epam.models;

/**
 * Created by Администратор on 26.05.2017.
 */
public enum  Position {
    DOC(1), NURSE(2), PATIENT(3);

    private int position;

    Position(int position) {
        this.position = position;
    }

    public static Position takePosition (Integer position){
        for(Position positions : Position.values()){
            if(positions.position == position) {
                return positions;
            }
        }
        throw new IllegalArgumentException();
    }

}
