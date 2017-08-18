package com.everis.alicante.becajava.domain;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingplaceTest {

	private Parkingplace expectedParkingplace;
	private Integer expectedIdParkingPlace = 1;
	private Integer expectedParkingNumber = 1;
	private Integer expectedIdBooking = 1;
	private Double expectedParkingPrize = 1d;
	private Double expectedParkingSize = 1d;
	private Byte expectedParkingState = 1;
	private Date expectedDate = new Date();
	private Client expectedClient = new Client();
	private Booking expectedBooking = new Booking();
	private Set<Booking> expectedBookings = new HashSet<Booking>();
	private Vehicle expectedVehicle = new Vehicle();
	
	@Before
	public void init() {
		this.expectedParkingplace = new Parkingplace();
		this.expectedParkingplace.setIdparkingplace(expectedIdParkingPlace);
		this.expectedParkingplace.setBookings(expectedBookings);
		this.expectedParkingplace.setParkingnumber(expectedParkingNumber);
		this.expectedParkingplace.setParkingprize(expectedParkingPrize);
		this.expectedParkingplace.setParkingstate(expectedParkingState);
		this.expectedParkingplace.setParkingsize(expectedParkingSize);
		this.expectedBooking.setBookingdate(expectedDate);
		this.expectedBooking.setClient(expectedClient);
		this.expectedBooking.setIdbooking(expectedIdBooking);
		this.expectedBooking.setParkingplace(expectedParkingplace);
		this.expectedBooking.setVehicle(expectedVehicle);
	}

	@Test
	public void testParkingplace() {
		// Assert
		Assert.assertNotNull(expectedParkingplace);
	}

	@Test
	public void testGetIdparkingplace() {
		// Act
		final Integer result = this.expectedParkingplace.getIdparkingplace();
		// Assert
		Assert.assertEquals(expectedIdParkingPlace, result);
	}

	@Test
	public void testSetIdparkingplace() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setIdparkingplace(expectedIdParkingPlace);

		// Assert
		Assert.assertEquals(Integer.valueOf(expectedIdParkingPlace), Integer.valueOf(parkingplace.getIdparkingplace()));
	}

	@Test
	public void testGetParkingnumber() {
		// Act
		final Integer result = this.expectedParkingplace.getIdparkingplace();
		// Assert
		Assert.assertEquals(expectedIdParkingPlace, result);
	}

	@Test
	public void testSetParkingnumber() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setParkingnumber(expectedParkingNumber);

		// Assert
		Assert.assertEquals(Integer.valueOf(expectedParkingNumber), Integer.valueOf(parkingplace.getParkingnumber()));
	}

	@Test
	public void testGetParkingprize() {
		// Act
		final Double result = this.expectedParkingplace.getParkingprize();
		// Assert
		Assert.assertEquals(expectedParkingPrize, result);
	}

	@Test
	public void testSetParkingprize() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setParkingprize(expectedParkingPrize);

		// Assert
		Assert.assertEquals(Double.valueOf(expectedParkingPrize), Double.valueOf(parkingplace.getParkingprize()));
	}

	@Test
	public void testGetParkingsize() {
		// Act
		final Double result = this.expectedParkingplace.getParkingsize();
		// Assert
		Assert.assertEquals(expectedParkingSize, result);
	}

	@Test
	public void testSetParkingsize() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setParkingsize(expectedParkingSize);

		// Assert
		Assert.assertEquals(Double.valueOf(expectedParkingSize), Double.valueOf(parkingplace.getParkingsize()));
	}

	@Test
	public void testGetParkingstate() {
		// Act
		final Byte result = this.expectedParkingplace.getParkingstate();
		// Assert
		Assert.assertEquals(expectedParkingState, result);
	}

	@Test
	public void testSetParkingstate() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setParkingstate(expectedParkingState);

		// Assert
		Assert.assertEquals(Byte.valueOf(expectedParkingState), Byte.valueOf(parkingplace.getParkingstate()));
	}

	@Test
	public void testGetBookings() {
		// Act
		final Set<Booking> result = this.expectedParkingplace.getBookings();
		// Assert
		Assert.assertEquals(expectedBookings, result);
	}

	@Test
	public void testSetBookings() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();

		// Act
		parkingplace.setBookings(expectedBookings);

		// Assert
		Assert.assertEquals(expectedBookings, parkingplace.getBookings());
	}

	@Test
	public void testAddBooking() {
		// Arrange
		final Parkingplace parkingplace = new Parkingplace();
		final Booking booking = new Booking();
		// Act
		Booking result = parkingplace.addBooking(booking);
		// Assert
		Assert.assertEquals(1, parkingplace.getBookings().size());
		Assert.assertEquals(parkingplace, result.getParkingplace());
	}

//	@Test
//	public void testRemoveBooking() {
//		// Arrange
//		final Parkingplace parkingplace = new Parkingplace();
//		final Booking booking = new Booking();
//		parkingplace.addBooking(booking);
//		// Act
//		Booking result = parkingplace.removeBooking(expectedBooking);
//		// Assert
//		Assert.assertEquals(0, expectedBookings.size());
//		Assert.assertNull(booking.getParkingplace());
//	}

	@Test
	public void testToString() {
		// Arrange
		final Booking booking = new Booking();
		final String expectedToString = "Reserva a fecha " + expectedDate + " , del cliente=" + expectedClient.getName() + " , para la plaza " + expectedParkingplace.getParkingnumber()
		+ ", y el vehiculo con matricula " + expectedVehicle.getVehicleplate() + "]";
		booking.setClient(expectedClient);
		booking.setParkingplace(expectedParkingplace);
		booking.setVehicle(expectedVehicle);
		booking.setBookingdate(expectedDate);
		// Act
		String result = booking.toString();
		// Assert
		Assert.assertEquals(expectedToString, result);
	}

}
