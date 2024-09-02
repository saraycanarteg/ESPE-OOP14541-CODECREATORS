/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class NotificationControlTest {

    public NotificationControlTest() {
    }

    @Test
    public void testGetDaysBetweenDates1() {
        System.out.println("getDaysBetweenDates - Case 1: End date is before start date");
        LocalDate startDate = LocalDate.of(2023, 1, 2);
        LocalDate endDate = LocalDate.of(2023, 1, 1);
        long expResult = -1L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates2() {
        System.out.println("getDaysBetweenDates - Case 2: Start date after leap day in non-leap year");
        LocalDate startDate = LocalDate.of(2021, 2, 28);
        LocalDate endDate = LocalDate.of(2021, 3, 1);
        long expResult = 1L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates3() {
        System.out.println("getDaysBetweenDates - Case 3: Cross-century dates");
        LocalDate startDate = LocalDate.of(1999, 12, 31);
        LocalDate endDate = LocalDate.of(2000, 1, 1);
        long expResult = 1L;
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates4() {
        System.out.println("getDaysBetweenDates - Case 4: Large date range with multiple leap years");
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 1, 1);
        long expResult = 36524L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates5() {
        System.out.println("getDaysBetweenDates - Case 5: Leap day in leap year");
        LocalDate startDate = LocalDate.of(2020, 2, 28);
        LocalDate endDate = LocalDate.of(2020, 3, 1);
        long expResult = 2L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates6() {
        System.out.println("getDaysBetweenDates - Case 6: Large negative date range");
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(1900, 1, 1);
        long expResult = -43829L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates7() {
        System.out.println("getDaysBetweenDates - Case 7: Same month, different days");
        LocalDate startDate = LocalDate.of(2021, 1, 10);
        LocalDate endDate = LocalDate.of(2021, 1, 15);
        long expResult = 5L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates8() {
        System.out.println("getDaysBetweenDates - Case 8: Different months, same year");
        LocalDate startDate = LocalDate.of(2021, 3, 31);
        LocalDate endDate = LocalDate.of(2021, 4, 1);
        long expResult = 1L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates9() {
        System.out.println("getDaysBetweenDates - Case 9: Crossing daylight saving time changes");
        LocalDate startDate = LocalDate.of(2021, 3, 13);
        LocalDate endDate = LocalDate.of(2021, 3, 15);
        long expResult = 2L; 
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDaysBetweenDates10() {
        System.out.println("getDaysBetweenDates - Case 10: End of year to start of next year");
        LocalDate startDate = LocalDate.of(2021, 12, 31);
        LocalDate endDate = LocalDate.of(2022, 1, 1);
        long expResult = 1L;
        long result = C_NotificationHandle.getDaysBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
    }
}
