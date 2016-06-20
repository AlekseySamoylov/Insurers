package com.alekseysamoylov.insurers.repository.impl;

import com.alekseysamoylov.insurers.services.InsurerPlusYearPlusIndex;
import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alekseysamoylov on 6/18/16.
 * Class provide access to get concrete indexes.
 * Pattern Repository and Pattern Specification.
 * This class has very bad method. I didn't fix it,
 * because I spent my time for other work.
 */
@Component
public class ConcreteRepository implements EntryRepository<ConcreteIndex, InsurerPlusYearPlusIndex> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEntry(ConcreteIndex entry) {
        //Add implementation in FUTURE
    }

    @Override
    public void removeEntry(ConcreteIndex entry) {
        //Add implementation in FUTURE
    }

    @Override
    public void updateEntry(ConcreteIndex entry) {
        //Add implementation in FUTURE
    }

    /**
     * Ужасный, нечитаемый метод! Все бы переделал, но времени не хватило!
     * The worst method in the world! FIX IT!!!
     * @param specification It is Interface.
     *                      Specification for sorting entries
     * @param insurerPlusYearPlusIndex Parameter, includes information about
     *                                 selected insurer, year and index.
     * @return List of concrete indexes, selected and sorted using this parameters.
     */
    @Override
    public List<ConcreteIndex> getEntryList(EntrySpecification specification, InsurerPlusYearPlusIndex insurerPlusYearPlusIndex) {
        Session session = sessionFactory.openSession();
        List concreteIndexes = new ArrayList<>();
        Date minDate = new Date();
        Date maxDate = new Date();
        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();

        try {
            if (insurerPlusYearPlusIndex.getInsurer() == null) {
                throw new NullPointerException("Error with parameters of InsurerPlusYearPlusIndex class");
            } else if (insurerPlusYearPlusIndex.getYear() == null) {
                concreteIndexes = session.createCriteria(ConcreteIndex.class, "concreteIndex")
                        .createAlias("concreteIndex.insurer", "insurer")
                        .createAlias("concreteIndex.index", "index")
                        .add(Restrictions.eq("insurer.insurerId", insurerPlusYearPlusIndex.getInsurer().getInsurerId()))
                        .add(Restrictions.eq("index.indexId", insurerPlusYearPlusIndex.getIndex().getIndexId()))
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("concreteId")).list();
            } else {
                min.append("01-01-").append(insurerPlusYearPlusIndex.getYear());
                max.append("31-12-").append(insurerPlusYearPlusIndex.getYear());

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    minDate = formatter.parse(min.toString());
                    maxDate = formatter.parse(max.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                concreteIndexes = session.createCriteria(ConcreteIndex.class, "concreteIndex")
                        .createAlias("concreteIndex.insurer", "insurer")
                        .createAlias("concreteIndex.reportingPeriod", "period")
                        .add(Restrictions.eq("insurer.insurerId", insurerPlusYearPlusIndex.getInsurer().getInsurerId()))
                        .add(Restrictions.ge("period.startPeriod", minDate))
                        .add(Restrictions.lt("period.startPeriod", maxDate))
                        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
            }
        } finally {
            session.close();
        }

        Iterator<ConcreteIndex> i = concreteIndexes.iterator();
        while (i.hasNext()) {
            if (!specification.specified(i.next())) i.remove();
        }


        return concreteIndexes;
    }
}
