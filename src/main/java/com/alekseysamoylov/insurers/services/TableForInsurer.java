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
 * To get list of Concrete Indexes in one quarter.
 * Used in Home Controller.
 */
@Service
public class TableForInsurer {

    @Qualifier("concreteRepository")
    @Autowired
    private EntryRepository<ConcreteIndex, InsurerPlusYearPlusIndex> entryRepository;

    @Qualifier("concreteForFirstQuarter")
    @Autowired
    private EntrySpecification<ConcreteIndex> firstQuarter;

    @Qualifier("concreteForSecondQuarter")
    @Autowired
    private EntrySpecification<ConcreteIndex> secondQuarter;

    @Qualifier("concreteForThirdQuarter")
    @Autowired
    private EntrySpecification<ConcreteIndex> thirdQuarter;

    @Qualifier("concreteForFourthQuarter")
    @Autowired
    private EntrySpecification<ConcreteIndex> forthQuarter;

    /**
     * Search all indexes of one Insurer of one quarter.
     * @param insurerPlusYearPlusIndex contain insurer(insurerId), year and quarter.
     * @return list Concrete Indexes
     */
    public List<ConcreteIndex> getTableQuarter(InsurerPlusYearPlusIndex insurerPlusYearPlusIndex) {
        switch (insurerPlusYearPlusIndex.getQuarter()) {
            case 1:
                return entryRepository.getEntryList(firstQuarter, insurerPlusYearPlusIndex);
            case 2:
                return entryRepository.getEntryList(secondQuarter, insurerPlusYearPlusIndex);
            case 3:
                return entryRepository.getEntryList(thirdQuarter, insurerPlusYearPlusIndex);
            case 4:
                return entryRepository.getEntryList(forthQuarter, insurerPlusYearPlusIndex);
            default:
                throw new IllegalArgumentException("Wrong Quarter");
        }
    }


}
