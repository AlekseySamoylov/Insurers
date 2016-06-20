package com.alekseysamoylov.insurers.specification;

import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import org.springframework.stereotype.Component;

/**
 * Created by alekseysamoylov on 6/19/16.
 * get Concrete indexes if it was in fourth quarter.
 */
@Component
public class ConcreteForFourthQuarter  implements EntrySpecification<ConcreteIndex> {

    @Override
    public boolean specified(ConcreteIndex entry) {
        int quarter = (entry.getReportingPeriod().getStartPeriod().getMonth() / 3) + 1;
        if (quarter == 4) return true;
        return false;
    }
}
