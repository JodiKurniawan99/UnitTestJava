package com.example.unittestjava;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    //dummy input
    private final double dummyLength = 12.0;
    private final double dummyWidth = 7.0;
    private final double dummyHeight = 6.0;

    //dummy result
    private final double dummyVolume = 504.0;
    private final double dummyCircumference = 100.0;
    private final double dummySurfaceArea = 396.0;


    //method with @Before annotation running for the first time, then
    //method with @Test running
    @Before
    public void before() {
        //mock function used for create mock object as real object
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    // JUnit test block code, used for unit test
    @Test
    public void testVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double volume = mainViewModel.getVolume();
        //delta 0.0001 give different tolerant value after decimal point
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testCircumference() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double circumference = mainViewModel.getCircumference();
        assertEquals(dummyCircumference, circumference, 0.0001);
    }
    @Test
    public void testSurfaceArea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight);
        double surfaceArea = mainViewModel.getSurfaceArea();
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001);
    }

    //Mockito test block code, usually used for mock object.
    //Mock object used for duplicate object to be tested
    @Test
    public void testMockVolume() {
        //when method used for manipulation behavior from mock object
        //thenReturn method used for manipulation result from mock object
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        //verify method used to check if the method is called with the given arguments.
        verify(cuboidModel).getVolume();
        //assertEquals method used for validation expected and actual output
        assertEquals(dummyVolume, volume, 0.0001);
    }
    @Test
    public void testMockCircumference() {
        when(mainViewModel.getCircumference()).thenReturn(dummyCircumference);
        double circumference = mainViewModel.getCircumference();
        verify(cuboidModel).getCircumference();
        assertEquals(dummyCircumference, circumference, 0.0001);
    }
    @Test
    public void testMockSurfaceArea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea);
        double surfaceArea = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001);
    }


    @Test
    public void save() {
    }

    @Test
    public void getCircumference() {
    }

    @Test
    public void getSurfaceArea() {
    }

    @Test
    public void getVolume() {
    }
}