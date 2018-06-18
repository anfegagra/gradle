package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.service.EmailService;
import co.ceiba.service.NotifyPersonService;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {
	
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setup() {
		//emailService = new EmailService();
		emailService = Mockito.mock(EmailService.class);
		notifyPersonService = new NotifyPersonService(emailService);
		
	}
	
	@Test
	public void notifyTest(){
		//Arrange
		Person person = new PersonTestDataBuilder().withName("hola").build();
		//Act
		Mockito.when(emailService.sendEmail(Mockito.anyString())).thenReturn("hola mundo");
		String message = notifyPersonService.notify(person);
		//Assert
		System.out.println(message);
		Assert.assertNotNull(message);
	}
}
