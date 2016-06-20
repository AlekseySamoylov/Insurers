package com.alekseysamoylov.insurers.services;

import org.springframework.context.annotation.Bean;

/**
 * Created by alekseysamoylov on 6/19/16.
 * Class contains name of Insurer and INN
 * I use the class to search on Home page.
 */

public class SearchFields {

    private String name = "";
    private Long inn = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }
}
