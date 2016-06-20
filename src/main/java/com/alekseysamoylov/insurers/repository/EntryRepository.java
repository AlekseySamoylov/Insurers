package com.alekseysamoylov.insurers.repository;

import java.util.List;

/**
 * Created by alekseysamoylov on 6/17/16.
 * For Realisation Access to our Data Structures.
 * I used two Generics to better and easier change in future.
 * Adding new functions, classes, objects, and other is easy thing with
 * this class.
 */
public interface EntryRepository<K, V> {

    void addEntry(K entry);
    void removeEntry(K entry);
    void updateEntry(K entry);

    /**
     * In our application the main function is showing lists of data structure,
     * therefore I create getList method with extra parameters.
     * @param specification It is Interface.
     *                      Specification for selecting proper Entries with
     *                      extra parameters.
     * @param object it may be text, List, object with different parameters
     *               for search or sorting.
     * @return List of Data Structure, which you want.
     */
    List<K> getEntryList(EntrySpecification specification, V object);


}
