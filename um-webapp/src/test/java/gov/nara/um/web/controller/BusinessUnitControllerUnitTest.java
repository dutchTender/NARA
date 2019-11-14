package gov.nara.um.web.controller;

import gov.nara.um.service.IBusinessUnitService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessUnitController.class)
@AutoConfigureMockMvc
public class BusinessUnitControllerUnitTest {

    @MockBean
    private IBusinessUnitService service;


    @Autowired
    private MockMvc mvc;

    @Test
    public final void checkingControllerExpectedInputOutput() throws Exception {
        //

        try {



        }
        catch (Exception ex){
            System.out.println("exception occurred: "+ex);
        }

    }
}
