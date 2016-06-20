package com.alekseysamoylov.insurers.repository;

/**
 * Created by alekseysamoylov on 6/17/16.
 * Interface to check different objects in list from Data Base
 * with our static different parameters.
 * For better changing and growing the project in future.
 */
public interface EntrySpecification <T> {
    boolean specified(T entry);
}
