package com.alekseysamoylov.insurers.specification;

import com.alekseysamoylov.insurers.repository.EntrySpecification;
import org.springframework.stereotype.Component;

/**
 * Created by alekseysamoylov on 6/17/16.
 * Get all. Without filters.
 */
@Component
public class GetAllSpecification implements EntrySpecification<Object> {

    /**
     * Show all Insurers without filters
     * @param entry no matter.
     * @return all.
     */
    @Override
        public boolean specified(Object entry) {
            return true;
    }
}
