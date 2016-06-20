package com.alekseysamoylov.insurers.services;

import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alekseysamoylov on 6/19/16.
 * This class get List of concrete indexes of
 * concrete Insurer of concrete one parameter.
 * HomeController uses this class to show table, graph and sending JSON
 */
@Service
public class TableForGraph {

    @Qualifier("concreteRepository")
    @Autowired
    private EntryRepository<ConcreteIndex, InsurerPlusYearPlusIndex> entryRepository;

    @Qualifier("getAllSpecification")
    @Autowired
    private EntrySpecification<Object> entrySpecification;

    public List<ConcreteIndex> getTableGraph(InsurerPlusYearPlusIndex insurerPlusYearPlusIndex) {
        return entryRepository.getEntryList(entrySpecification, insurerPlusYearPlusIndex);
    }
}
