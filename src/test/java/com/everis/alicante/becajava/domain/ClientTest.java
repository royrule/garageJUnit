package com.everis.alicante.becajava.domain;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Client expectedClient;
	private Integer expectedIdClient = 1;
	private String expectedName = "";
	private String expectedNif = "";
	private String expectedSurname = "";
	private String expectedTelephone = "";
	private Set<Booking> expectedBookings = new HashSet<Booking>();
	private Booking expectedBooking = new Booking();
	private Set<Vehicle> expectedVehicles = new HashSet<Vehicle>();
	private Vehicle expectedVehicle = new Vehicle();

	@Before
	public void init() {
		this.expectedClient = new Client();
		this.expectedClient.setBookings(expectedBookings);
		this.expectedClient.setIdclient(expectedIdClient);
		this.expectedClient.setName(expectedName);
		this.expectedClient.setNif(expectedNif);
		this.expectedClient.setSurname(expectedSurname);
		this.expectedClient.setTelephone(expectedTelephone);
		this.expectedClient.setVehicles(expectedVehicles);
	}

	@Test
	public void testClient() {
		// Assert
		Assert.assertNotNull(expectedClient);
	}

	@Test
	public void testGetIdclient() {
		// Act
		final Integer result = this.expectedClient.getIdclient();
		// Assert
		Assert.assertEquals(expectedIdClient, result);
	}

	@Test
	public void testSetIdclient() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setIdclient(expectedIdClient);

		// Assert
		Assert.assertEquals(Integer.valueOf(expectedIdClient), Integer.valueOf(client.getIdclient()));
	}

	@Test
	public void testGetName() {
		// Act
		final String result = this.expectedClient.getName();
		// Assert
		Assert.assertEquals(expectedName, result);
	}

	@Test
	public void testSetName() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setName(expectedName);

		// Assert
		Assert.assertEquals(expectedName, client.getName());
	}

	@Test
	public void testGetNif() {
		// Act
		final String result = this.expectedClient.getNif();
		// Assert
		Assert.assertEquals(expectedNif, result);
	}

	@Test
	public void testSetNif() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setNif(expectedNif);

		// Assert
		Assert.assertEquals(expectedNif, client.getNif());
	}

	@Test
	public void testGetSurname() {
		// Act
		final String result = this.expectedClient.getSurname();
		// Assert
		Assert.assertEquals(expectedSurname, result);
	}

	@Test
	public void testSetSurname() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setSurname(expectedSurname);

		// Assert
		Assert.assertEquals(expectedSurname, client.getSurname());
	}

	@Test
	public void testGetTelephone() {
		// Act
		final String result = this.expectedClient.getTelephone();
		// Assert
		Assert.assertEquals(expectedTelephone, result);
	}

	@Test
	public void testSetTelephone() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setTelephone(expectedTelephone);

		// Assert
		Assert.assertEquals(expectedTelephone, client.getTelephone());
	}

	@Test
	public void testGetBookings() {
		// Act
		final Set<Booking> result = this.expectedClient.getBookings();
		// Assert
		Assert.assertEquals(expectedBookings, result);
	}

	@Test
	public void testSetBookings() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setBookings(expectedBookings);

		// Assert
		Assert.assertEquals(expectedBookings, client.getBookings());
	}

	@Test
	public void testAddBooking() {
		// Arrange
		final Client client = new Client();
		// Act
		Booking result = client.addBooking(expectedBooking);
		// Assert
		Assert.assertEquals(1, client.getBookings().size());
		Assert.assertEquals(client, result.getClient());
	}

	@Test
	public void testRemoveBooking() {
		// Arrange
		final Client client = new Client();
		final Booking booking = new Booking();
		client.addBooking(expectedBooking);
		// Act
		Booking result = client.removeBooking(expectedBooking);
		// Assert
		Assert.assertEquals(0, expectedBookings.size());
		Assert.assertNull(booking.getClient());
	}

	@Test
	public void testGetVehicles() {
		// Act
		final Set<Vehicle> result = this.expectedClient.getVehicles();
		// Assert
		Assert.assertEquals(expectedVehicles, result);
	}

	@Test
	public void testSetVehicles() {
		// Arrange
		final Client client = new Client();

		// Act
		client.setVehicles(expectedVehicles);

		// Assert
		Assert.assertEquals(expectedVehicles, client.getVehicles());
	}

	@Test
	public void testAddVehicle() {
		// Arrange
		final Client client = new Client();
		// Act
		Vehicle result = client.addVehicle(expectedVehicle);
		// Assert
		Assert.assertEquals(1, client.getVehicles().size());
		Assert.assertEquals(client, result.getClient());
	}

	@Test
	public void testRemoveVehicle() {
		// Arrange
		final Client client = new Client();
		final Booking booking = new Booking();
		// Act
		client.addVehicle(expectedVehicle);
		Vehicle result = client.removeVehicle(expectedVehicle);
		// Assert
		Assert.assertEquals(0, expectedVehicles.size());
		Assert.assertNull(booking.getVehicle());
	}

}
