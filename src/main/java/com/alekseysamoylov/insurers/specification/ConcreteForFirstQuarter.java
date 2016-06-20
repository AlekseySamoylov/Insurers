package com.alekseysamoylov.insurers.specification;

import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import org.springframework.stereotype.Component;


/**
 * Created by alekseysamoylov on 6/18/16.
 * get Concrete indexes if it was in first quarter.
 */
@Component
public class ConcreteForFirstQuarter implements EntrySpecification<ConcreteIndex> {

    @Override
    public boolean specified(ConcreteIndex entry) {
        int quarter = (entry.getReportingPeriod().getStartPeriod().getMonth() / 3) + 1;
        if (quarter == 1) return true;
        return false;
    }
}
