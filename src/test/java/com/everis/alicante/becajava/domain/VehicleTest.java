package com.everis.alicante.becajava.domain;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

	private Integer expectedIdVehicle = 1;
	private String expectedVehicleModel = "Coche";
	private String expectedVehiclePlate = "AAAFFF";
	private Client expectedClient = new Client();
	private Set<Booking> expectedBookings = new HashSet<Booking>();
	private Vehicle expectedVehicle = new Vehicle();
	private Booking expectedBooking = new Booking();

	@Before
	public void init() {
		this.expectedVehicle = new Vehicle();
		this.expectedVehicle.setClient(expectedClient);
		this.expectedVehicle.setBookings(expectedBookings);
		this.expectedVehicle.setIdvehicle(expectedIdVehicle);
		this.expectedVehicle.setVehiclemodel(expectedVehicleModel);
		this.expectedVehicle.setVehicleplate(expectedVehiclePlate);
	}

	@Test
	public void testVehicle() {
		// Assert
		Assert.assertNotNull(expectedVehicle);
	}

	@Test
	public void testGetIdvehicle() {
		// Act
		final Integer result = this.expectedVehicle.getIdvehicle();
		// Assert
		Assert.assertEquals(Integer.valueOf(expectedVehicle.getIdvehicle()), result);
	}

	@Test
	public void testSetIdvehicle() {
		// Arrange
		final Vehicle vehicle = new Vehicle();

		// Act
		vehicle.setIdvehicle(expectedIdVehicle);

		// Assert
		Assert.assertEquals(Integer.valueOf(expectedIdVehicle), Integer.valueOf(vehicle.getIdvehicle()));
	}

	@Test
	public void testGetVehiclemodel() {
		// Act
		final String result = this.expectedVehicle.getVehiclemodel();
		// Assert
		Assert.assertEquals(expectedVehicleModel, result);
	}

	@Test
	public void testSetVehiclemodel() {
		// Arrange
		final Vehicle vehicle = new Vehicle();

		// Act
		vehicle.setVehiclemodel(expectedVehicleModel);

		// Assert
		Assert.assertEquals(expectedVehicleModel, vehicle.getVehiclemodel());
	}

	@Test
	public void testGetVehicleplate() {
		// Act
		final String result = this.expectedVehicle.getVehicleplate();
		// Assert
		Assert.assertEquals(expectedVehiclePlate, result);
	}

	@Test
	public void testSetVehicleplate() {
		// Arrange
		final Vehicle vehicle = new Vehicle();

		// Act
		vehicle.setVehicleplate(expectedVehiclePlate);

		// Assert
		Assert.assertEquals(expectedVehiclePlate, vehicle.getVehicleplate());
	}

	@Test
	public void testGetBookings() {
		// Act
		final Set<Booking> result = this.expectedVehicle.getBookings();
		// Assert
		Assert.assertEquals(expectedBookings, result);
	}

	@Test
	public void testSetBookings() {
		// Arrange
		final Vehicle vehicle = new Vehicle();

		// Act
		vehicle.setBookings(expectedBookings);

		// Assert
		Assert.assertEquals(expectedBookings, vehicle.getBookings());
	}

	@Test
	public void testAddBooking() {
		// Arrange
		final Vehicle vehicle = new Vehicle();
		final Booking booking = new Booking();
		// Act
		Booking result = vehicle.addBooking(booking);
		// Assert
		Assert.assertEquals(1, vehicle.getBookings().size());
		Assert.assertEquals(vehicle, result.getVehicle());
	}

//	@Test
//	public void testRemoveBooking() {
//		// Arrange
//		final Vehicle vehicle = new Vehicle();
//		final Booking booking = new Booking();
//		vehicle.addBooking(booking);
//		// Act
//		Booking result = vehicle.removeBooking(expectedBooking);
//		// Assert
//		Assert.assertEquals(0, expectedBookings.size());
//		Assert.assertNull(booking.getVehicle());
//	}

	@Test
	public void testGetClient() {
		// Act
		final Client result = this.expectedClient;
		// Assert
		Assert.assertEquals(expectedClient, result);
	}

	@Test
	public void testSetClient() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setBookings(expectedBookings);

		// Assert
		Assert.assertEquals(expectedBookings, client.getBookings());
	}

}
