package com.alekseysamoylov.insurers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alekseysamoylov on 6/18/16.
 * Create SQL statement to create example table.
 */
public class CreateTable {
    @Test
    public void generateTable() {
        int counter = 1;
        StringBuilder string = new StringBuilder();

        for (int insurerCounter = 1; insurerCounter < 11; insurerCounter++) {
            for (int indexCounter = 1; indexCounter < 12; indexCounter++) {
                for (int periodCounter = 1; periodCounter < 9; periodCounter++) {
                    double value = Math.random() * 10 - 5;
                    String formattedDouble = String.format("%.2f", value);

                    string.append("INSERT INTO CONCRETE_INDEX (CONCRETE_ID, INSURER_ID , INDEX_ID , PERIOD_ID , VALUE) VALUES (")
                            .append(counter++).append(", ")
                            .append(insurerCounter).append(", ")
                            .append(indexCounter).append(", ")
                            .append(periodCounter).append(", ")
                            .append(formattedDouble).append(");\n");

                }
            }
        }
        System.out.println(string);
    }


}
