package com.latam.techoffice.testdrive.model;

import javax.json.JsonObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    /**
     * Test of getCustomerID method, of class Customer.
     */
    @Test
    public void testCustomerID() {
        System.out.println("getCustomerID");
        Customer first = new Customer("111111");
        assertEquals("111111", first.getCustomerID());
        
        Customer second = new Customer();
        second.setCustomerID("222222");
        assertEquals("222222", second.getCustomerID());
    }
}
