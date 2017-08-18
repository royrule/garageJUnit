package com.everis.alicante.becajava.domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {

	private Booking expectedBooking;
	private Date expectedDate = new Date();
	private Client expectedClient = new Client();
	private Parkingplace expectedParkingPlace = new Parkingplace();
	private Vehicle expectedVehicle = new Vehicle();
	private Integer expectedIdBooking = 1;
	private String expectedToString = "Reserva a fecha " + expectedDate + " , del cliente=" + expectedClient.getName() + " , para la plaza " + expectedParkingPlace.getParkingnumber()
	+ ", y el vehiculo con matricula " + expectedVehicle.getVehicleplate() + "]";

	@Before
	public void init() {
		this.expectedBooking = new Booking();
		this.expectedBooking.setBookingdate(expectedDate);
		this.expectedBooking.setClient(expectedClient);
		this.expectedBooking.setIdbooking(expectedIdBooking);
		this.expectedBooking.setParkingplace(expectedParkingPlace);
		this.expectedBooking.setVehicle(expectedVehicle);
	}

	@Test
	public void testBooking() {
		// Assert
		Assert.assertNotNull(expectedBooking);
	}

	@Test
	public void testGetIdbooking() {
		// Act
		final Integer result = this.expectedBooking.getIdbooking();
		// Assert
		Assert.assertEquals(expectedIdBooking, result);

	}

	@Test
	public void testSetIdbooking() {
		// Arrange
		final Booking booking = new Booking();
		booking.setClient(expectedClient);
		booking.setParkingplace(expectedParkingPlace);
		booking.setVehicle(expectedVehicle);
		// Act
		booking.setIdbooking(expectedIdBooking);

		// Assert
		Assert.assertEquals(Double.valueOf(expectedIdBooking), Double.valueOf(booking.getIdbooking()));

	}

	@Test
	public void testGetBookingdate() {
		// Act
		final Date result = this.expectedBooking.getBookingdate();
		// Assert
		Assert.assertEquals(expectedDate, result);
	}

	@Test
	public void testSetBookingdate() {
		// Arrange
		final Booking booking = new Booking();
		booking.setClient(expectedClient);
		booking.setParkingplace(expectedParkingPlace);
		booking.setVehicle(expectedVehicle);
		// Act
		booking.setBookingdate(expectedDate);
		// Assert
		Assert.assertEquals(expectedDate, booking.getBookingdate());
	}

	@Test
	public void testGetClient() {
		// Act
		final Client result = this.expectedBooking.getClient();
		// Assert
		Assert.assertEquals(expectedClient, result);
	}

	@Test
	public void testSetClient() {
		// Arrange
		final Booking booking = new Booking();
		booking.setParkingplace(expectedParkingPlace);
		booking.setVehicle(expectedVehicle);

		// Act
		booking.setClient(expectedClient);

		// Assert
		Assert.assertEquals(expectedClient, booking.getClient());
	}

	@Test
	public void testGetParkingplace() {
		// Act
		final Parkingplace result = this.expectedBooking.getParkingplace();
		// Assert
		Assert.assertEquals(expectedParkingPlace, result);
	}

	@Test
	public void testSetParkingplace() {
		// Arrange
		final Booking booking = new Booking();
		booking.setClient(expectedClient);
		booking.setVehicle(expectedVehicle);
		// Act
		booking.setParkingplace(expectedParkingPlace);

		// Assert
		Assert.assertEquals(expectedParkingPlace, booking.getParkingplace());
	}

	@Test
	public void testGetVehicle() {
		// Act
		final Vehicle result = this.expectedBooking.getVehicle();
		// Assert
		Assert.assertEquals(expectedVehicle, result);
	}

	@Test
	public void testSetVehicle() {
		// Arrange
		final Booking booking = new Booking();
		booking.setClient(expectedClient);
		booking.setParkingplace(expectedParkingPlace);
		// Act
		booking.setVehicle(expectedVehicle);
		// Assert
		Assert.assertEquals(expectedVehicle, booking.getVehicle());
	}

	@Test
	public void testToString() {
		// Arrange
		final Booking booking = new Booking();
		booking.setClient(expectedClient);
		booking.setParkingplace(expectedParkingPlace);
		booking.setVehicle(expectedVehicle);
		booking.setBookingdate(expectedDate);
		// Act
		String result = booking.toString();
		// Assert
		Assert.assertEquals(expectedToString, result);
	}

}
