package com.everis.alicante.becajava.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class VehicleDAOJPAImplTest {

	private VehicleDAOJPAImpl vehicleDAO;

	@Mock
	private EntityManager entityManagerMock;

	@Mock
	private EntityTransaction entityTransactionMock;

	@Before
	public void init() {
		this.vehicleDAO = new VehicleDAOJPAImpl(entityManagerMock);
	}

	@Test
	public void testCreate() {
		// Arrange
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		vehicleDAO.create(vehicle);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).persist(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		// Arrange
		Vehicle expectedVehicle = new Vehicle();
		Mockito.when(this.entityManagerMock.find(Vehicle.class, 1)).thenReturn(expectedVehicle);
		// Act
		final Vehicle result = vehicleDAO.readById(1);
		// Assert
		Assert.assertEquals(expectedVehicle, result);
	}

	@Test
	public void testUpdate() {
		// Arrange
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		vehicleDAO.update(vehicle);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).merge(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		// Arrange
		Vehicle vehicle = new Vehicle();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		vehicleDAO.delete(vehicle);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).remove(vehicle);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testClientDAOJPAImpl() {
		// Assert
		Assert.assertNotNull(entityManagerMock);
	}

	@Test
	public void testFindAll() {
		// Arrange
		List<Vehicle> expectedClient = new ArrayList<Vehicle>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNamedQuery("Vehicle.findAll")).thenReturn(queryMock);
		// Act
		final List<Vehicle> result = vehicleDAO.findAll();
		// Assert
		Assert.assertEquals(expectedClient, result);
	}

}
