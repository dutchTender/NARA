package gov.nara.um.web.controller;

import gov.nara.um.service.IBusinessUnitService;
import gov.nara.um.service.impl.BusinessUnitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BusinessUnitController.class }, loader = AnnotationConfigContextLoader.class)
public class BusinessUnitControllerUnitTest {

    @InjectMocks
    private IBusinessUnitService service = new BusinessUnitServiceImpl();

    @Test
    public final void checkingControllerExpectedInputOutput() {
        //


    }
}
