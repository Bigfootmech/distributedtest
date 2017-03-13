package org.distributedtest.consumer;

import static org.junit.Assert.*;

import org.distributedtest.core.dao.tables.IEventsTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.distributedtest.consumer.App;
//import org.distributedtest.dao.App;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
@WebAppConfiguration
public class AppTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void checkConfig()
    {
    	IEventsTable bean =  appContext.getBean(IEventsTable.class);
        assertNotNull(bean);
    }
}
