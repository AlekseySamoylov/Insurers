package com.alekseysamoylov.insurers.gettables;

import com.alekseysamoylov.insurers.services.InsurerPlusYearPlusIndex;
import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.data.entities.Index;
import com.alekseysamoylov.insurers.data.entities.Insurer;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import com.alekseysamoylov.insurers.specification.ConcreteForFirstQuarter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/18/16.
 * Tests get Indexes lists from data base.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appTestContext.xml"})
@WebAppConfiguration
public class TestCocreteStore {

    private List<ConcreteIndex> concreteIndexes = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    @Qualifier("concreteRepository")
    @Autowired
    private EntryRepository<ConcreteIndex, InsurerPlusYearPlusIndex> concreteRepository;

    @Qualifier("concreteForFirstQuarter")
    @Autowired
    private EntrySpecification concreteFirstQuarterSpecification;

    @Qualifier("getAllSpecification")
    @Autowired
    private EntrySpecification getAllSpecification;



    @Test
    public void getIndexesOfOneCompanyOfFirstQuarter() {
        Insurer insurer = prepareInsurer();
        String year = "2005";
        InsurerPlusYearPlusIndex insurerPlusYearPlusIndex = new InsurerPlusYearPlusIndex(insurer, year);
        concreteIndexes = concreteRepository.getEntryList(concreteFirstQuarterSpecification, insurerPlusYearPlusIndex);

        for (ConcreteIndex concreteIndex : concreteIndexes) {
            System.out.println(concreteIndex);
        }
    }

    @Test
    public void getIndexesOfOneParameterOneCompanyAllQuarters() {
        Insurer insurer = prepareInsurer();
        Index index = prepareIndex();
        InsurerPlusYearPlusIndex insurerPlusYearPlusIndex = new InsurerPlusYearPlusIndex(insurer, index);
        concreteIndexes = concreteRepository.getEntryList(getAllSpecification, insurerPlusYearPlusIndex);
        for (ConcreteIndex concreteIndex : concreteIndexes) {
            System.out.println(concreteIndex);
        }

    }


    private Insurer prepareInsurer() {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Insurer.class, (long) 1);
        } finally {
            session.close();
        }

    }

    private Index prepareIndex() {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Index.class, (long) 1);
        } finally {
            session.close();
        }
    }

}
