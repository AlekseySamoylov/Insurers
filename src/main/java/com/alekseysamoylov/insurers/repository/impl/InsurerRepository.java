package com.alekseysamoylov.insurers.repository.impl;

import com.alekseysamoylov.insurers.data.entities.Insurer;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import com.alekseysamoylov.insurers.services.SearchFields;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/17/16.
 * Class provide access to get Insurers.
 * Pattern Repository and Pattern Specification.
 */
@Component
public class InsurerRepository implements EntryRepository<Insurer, SearchFields> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEntry(Insurer entry) {
        //Add Insurer in DATA BASE
    }

    @Override
    public void removeEntry(Insurer entry) {
        //Remove Insurer from DATA BASE

    }

    @Override
    public void updateEntry(Insurer entry) {
        //Update Insurer in DATA BASE
    }

    /**
     * Get Insurer list using sort and search parameters.
     * We use this method in searching and showing Insurers on home page.
     * @param specification It is Interface.
     *                      Specification for selecting proper Insurers with
     *                      extra parameters.
     * @param searchFields Parameter is object includes two fields: name and inn
     *                     You must use full inn to success.
     *                     Name field may has a few characters.
     * @return list of insurers.
     */
    @Override
    public List<Insurer> getEntryList(EntrySpecification specification, SearchFields searchFields) {
        List insurers;
        Session session = sessionFactory.openSession();
        try {
            if (searchFields.getName().trim().equals("") && searchFields.getInn() == null) {
                insurers = session.createCriteria(Insurer.class)
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
            } else if (!searchFields.getName().trim().equals("") && searchFields.getInn() == null) {
                insurers = session.createCriteria(Insurer.class)
                        .add(Restrictions.like("name", "%" + searchFields.getName() + "%").ignoreCase())
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
            } else if (searchFields.getName().trim().equals("") && searchFields.getInn() != null) {
                insurers = session.createCriteria(Insurer.class)
                        .add(Restrictions.eq("inn", searchFields.getInn()))
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
            } else {
                insurers = session.createCriteria(Insurer.class)
                        .add(Restrictions.like("name", "%" + searchFields.getName() + "%").ignoreCase())
                        .add(Restrictions.eq("inn", searchFields.getInn()))
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
            }
        } finally {
            session.close();
        }

        Iterator<Insurer> i = insurers.iterator();
        while (i.hasNext()) {
            if (!specification.specified(i.next())) i.remove();
        }


        return insurers;
    }


}
