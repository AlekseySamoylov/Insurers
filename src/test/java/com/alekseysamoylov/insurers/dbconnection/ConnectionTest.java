package com.alekseysamoylov.insurers.dbconnection;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by alekseysamoylov on 6/12/16.
 * Tests controllers.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appTestContext.xml"})
@WebAppConfiguration
public class ConnectionTest {

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void connectionTest1() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.close();
    }

}
