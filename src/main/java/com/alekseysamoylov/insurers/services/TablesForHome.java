package com.alekseysamoylov.insurers.services;

import com.alekseysamoylov.insurers.data.entities.Insurer;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 6/19/16.
 * Get list of Insurers for home page.
 */
@Service
public class TablesForHome {

    @Qualifier("insurerRepository")
    @Autowired
    private EntryRepository<Insurer, SearchFields> entryRepository;


    @Qualifier("getAllSpecification")
    @Autowired
    private EntrySpecification<Object> entrySpecification;

    /**
     * Get all Insurers.
     * @return Insurers list
     */
    public List<Insurer> getInsurers() {
        return entryRepository.getEntryList(entrySpecification, new SearchFields());
    }

    /**
     * Get Insurers with searching parameter.
     * @param searchFields name & INN.
     * @return Insurers list
     */
    public List<Insurer> getInsurers(SearchFields searchFields) {
        return entryRepository.getEntryList(entrySpecification, searchFields);
    }
}
