package com.alekseysamoylov.insurers.services;

import com.alekseysamoylov.insurers.data.entities.Index;
import com.alekseysamoylov.insurers.data.entities.Insurer;

/**
 * Created by alekseysamoylov on 6/19/16.
 * FIX IT
 * I have made this class, becouse I don't
 * have time to produce better code.
 * It works... And mo more.
 *
 * Class contains parameters for searching and sorting
 * concrete indexes in second and last pages on the site.
 */
public class InsurerPlusYearPlusIndex {
    private Insurer insurer = null;
    private String year = null;
    private Integer quarter = null;
    private Index index = null;


    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Index getIndex() {
        return index;
    }

    public InsurerPlusYearPlusIndex(Insurer insurer, Index index) {
        this.insurer = insurer;
        this.index = index;
    }
    public InsurerPlusYearPlusIndex() {

    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public InsurerPlusYearPlusIndex(Insurer insurer, String year) {
        this.insurer = insurer;
        this.year = year;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "InsurerPlusYearPlusIndex{" +
                "insurer=" + insurer +
                ", year='" + year + '\'' +
                ", quarter=" + quarter +
                ", index=" + index +
                '}';
    }
}
