package com.everis.alicante.becajava.domain;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GarajeExceptionTest {
	
	@Mock
	private Logger loggerMock;
	
	GarajeException expectedGarajeException;
	private Exception expectedException;
	
	@Before
	public void init() {
		expectedException = new Exception();
		expectedGarajeException = new GarajeException(expectedException);
	}
	
	@Test
	public void testGestionaExcepcion() {
		//Arrange
		String expectedMessage = "Ha ocurrido una excepcion del tipo : " + this.expectedException.getClass() +" por este motivo: " + this.expectedException.getLocalizedMessage();
		// Act
		expectedGarajeException.gestionaExcepcion();
		// Assert
		Mockito.verify(this.loggerMock, Mockito.times(1)).error(expectedMessage);
	}

	@Test
	public void testGarajeException() {
		// Assert
		Assert.assertNotNull(expectedException);
	}

	/*@Test
	public void testAdaptaFormatoTxt() {
		// Arrange
		String expectedTmp = "";
		expectedTmp=expectedTmp.concat(Calendar.getInstance().getTime().toString());
		expectedTmp=expectedTmp.concat(";");
		expectedTmp=expectedTmp.concat(this.expectedException.getClass().getSimpleName());
		expectedTmp=expectedTmp.concat(";");
		expectedTmp=expectedTmp.concat(this.expectedException.getLocalizedMessage());
		// Act
		String result = expectedGarajeException.adaptaFormatoTxt();
		// Assert
		Assert.assertEquals(expectedTmp, result);
	}*/

}
