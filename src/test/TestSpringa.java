package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import validation.MyValidator;

import com.zaliczenie.aspects.ConfigureAspect;
import com.zaliczenie.service.ManufacturerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config.xml")
public class TestSpringa {

	@Autowired
    private ManufacturerService manufacturerService;
	
	@Autowired
	private ConfigureAspect configureAspect;
	
	@Test
	public void testWstrzykiwaniaManufacturerService() {
		Assert.assertTrue(manufacturerService != null);
	}
	
	@Test
	public void testWstrzykiwaniaConfigureAspect() {
		Assert.assertTrue(configureAspect != null);
	}
	
	@Test
	public void testValidatoraMale() {
		MyValidator myValidator = new MyValidator();
		Assert.assertTrue(myValidator.isValid("test"));
	}
	
	@Test
	public void testValidatoraDuze() {
		MyValidator myValidator = new MyValidator();
		Assert.assertTrue(myValidator.isValid("Test"));
	}

}
