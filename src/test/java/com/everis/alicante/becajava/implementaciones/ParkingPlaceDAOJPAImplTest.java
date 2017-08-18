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

import com.everis.alicante.becajava.domain.Parkingplace;

@RunWith(MockitoJUnitRunner.class)
public class ParkingPlaceDAOJPAImplTest {

	private ParkingPlaceDAOJPAImpl parkingPlaceDAO;

	@Mock
	private EntityManager entityManagerMock;

	@Mock
	private EntityTransaction entityTransactionMock;

	@Before
	public void init() {
		this.parkingPlaceDAO = new ParkingPlaceDAOJPAImpl(entityManagerMock);
	}

	@Test
	public void testCreate() {
		// Arrange
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		parkingPlaceDAO.create(parkingPlace);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).persist(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		// Arrange
		Parkingplace expectedParkingPlace = new Parkingplace();
		Mockito.when(this.entityManagerMock.find(Parkingplace.class, 1)).thenReturn(expectedParkingPlace);
		// Act
		final Parkingplace result = parkingPlaceDAO.readById(1);
		// Assert
		Assert.assertEquals(expectedParkingPlace, result);
	}

	@Test
	public void testUpdate() {
		// Arrange
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		parkingPlaceDAO.update(parkingPlace);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).merge(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		// Arrange
		Parkingplace parkingPlace = new Parkingplace();
		Mockito.when(this.entityManagerMock.getTransaction()).thenReturn(this.entityTransactionMock);
		// Act
		parkingPlaceDAO.delete(parkingPlace);
		// Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.entityManagerMock, Mockito.times(1)).remove(parkingPlace);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testParkingPlaceDAOJPAImpl() {
		// Assert
		Assert.assertNotNull(entityManagerMock);
	}

	@Test
	public void testFindAll() {
		// Arrange
		List<Parkingplace> expectedParkingPlace = new ArrayList<Parkingplace>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNamedQuery("Parkingplace.findAll")).thenReturn(queryMock);
		// Act
		final List<Parkingplace> result = parkingPlaceDAO.findAll();
		// Assert
		Assert.assertEquals(expectedParkingPlace, result);
	}

	@Test
	public void testFindFreeParkingPlace() {
		// Arrange
		List<Integer> expectedIdParkingPlaces= new ArrayList<Integer>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNativeQuery(Mockito.anyString())).thenReturn(queryMock);
		expectedIdParkingPlaces.add(1);
		Mockito.when(queryMock.getResultList()).thenReturn(expectedIdParkingPlaces);
		// Act
		final Integer result = parkingPlaceDAO.findFreeParkingPlace();
		// Assert
		Assert.assertEquals(Integer.valueOf(1), result);

	}

	@Test
	public void testFindFreeParkingPlaces() {
		// Arrange
		List<Parkingplace> expectedParkingPlace = new ArrayList<Parkingplace>();
		Query queryMock = Mockito.mock(Query.class);
		Mockito.when(this.entityManagerMock.createNamedQuery("Parkingplace.findFreePlaces")).thenReturn(queryMock);
		// Act
		final List<Parkingplace> result = parkingPlaceDAO.findFreeParkingPlaces();
		// Assert
		Assert.assertEquals(expectedParkingPlace, result);
	}

}
