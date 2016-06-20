package com.alekseysamoylov.insurers.gettables;


import com.alekseysamoylov.insurers.data.entities.Index;
import com.alekseysamoylov.insurers.data.entities.Insurer;
import com.alekseysamoylov.insurers.repository.EntryRepository;
import com.alekseysamoylov.insurers.repository.EntrySpecification;
import com.alekseysamoylov.insurers.services.SearchFields;
import org.junit.Assert;
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
 * Created by alekseysamoylov on 6/15/16.
 * Tests get Insurers lists from data base.
 * With search.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appTestContext.xml"})
@WebAppConfiguration
public class TestInsurerStore {

    private List<Insurer> insurers = new ArrayList<>();
    private List<Index> indexes = new ArrayList<>();


    @Qualifier("insurerRepository")
    @Autowired
    private EntryRepository<Insurer, SearchFields> entryRepository;


    @Qualifier("getAllSpecification")
    @Autowired
    private EntrySpecification specification;


    @Test
    public void prepareEmptyTable() {

    }

    @Test
    public void getAllInsurerListTest1() {
        SearchFields searchFields = new SearchFields();
        searchFields.setInn(3317000791L);
        searchFields.setName("Ро");
        insurers = entryRepository.getEntryList(specification, searchFields);
        for (Insurer insurer : insurers) {
            System.out.println(insurer);
            System.out.println(insurer.getConcreteIndexes().get(1).getValue());
        }
        Assert.assertTrue(insurers.get(0) != null);
    }

    @Test
    public void getAllInsurerListTest2() {
        SearchFields searchFields = new SearchFields();
        searchFields.setInn(3317000791L);
        searchFields.setName("Ро");
        insurers = entryRepository.getEntryList(specification, searchFields);
        Assert.assertNotNull(insurers.get(0).getName());
        Assert.assertNotNull(insurers.get(0).getLicense());
        Assert.assertTrue(insurers.get(0).getNumberOfBranches() > 0);
        Assert.assertNotNull(insurers.get(0).getConcreteIndexes().get(0).getIndex().getIndexName());
        Assert.assertNotNull(insurers.get(0).getConcreteIndexes().get(0).getValue());
        Assert.assertNotNull(insurers.get(0).getConcreteIndexes().get(0).getReportingPeriod().getStartPeriod());

    }



}
