package com.latam.techoffice.testdrive.model;

import com.latam.techoffice.testdrive.error.InvalidException;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.bson.types.ObjectId;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.json.JSONException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.skyscreamer.jsonassert.JSONAssert;


/**
 *
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
public class CustomerTest {
    
    private static JAXBContext context;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void initJAXContext() {
        System.out.printf("TTTT initJAXContext()\n");
        try { 
            context = JAXBContext.newInstance(Customer.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            
            unmarshaller = context.createUnmarshaller();
            unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
            
        } catch(JAXBException ex) {
            fail("### Unable to initialize JAXB Context properly or unable to create (Un)Marshallers");
        }
    }
    
    @Test
    public void testCustomerUnmarshalling() {
        System.out.printf("TTTT testCustomerUnmarshalling()\n");
        
        String content = "{\"firstName\":\"Mauricio\",\"lastName\":\"Leal\"}";
        try {
            StreamSource json = new StreamSource(new StringReader(content));
            Customer customer = unmarshaller.unmarshal(json, Customer.class).getValue();
            
            assertEquals("Mauricio", customer.getFirstName());
            assertEquals("Leal", customer.getLastName());
            
            
        } catch(JAXBException ex) {
            fail("### Unable to unmarshalling content");
        }
    }
    
    @Test
    public void testCustomerUnmarshallingWithObjectId() {
        System.out.printf("TTTT testCustomerUnmarshallingWithObjectId()\n");
        String content = "{\"_id\":\"5a0b8d54ab139334b3148b75\", \"firstName\":\"Mauricio\", \"lastName\":\"Leal\"}";
        try {
            StreamSource json = new StreamSource(new StringReader(content));
            Customer customer = unmarshaller.unmarshal(json, Customer.class).getValue();
            System.out.printf("Customer ID: %s\n", customer.getCustomerID() != null
                    ? customer.getCustomerID().toString() : "NULL");
            
            assertEquals(new ObjectId("5a0b8d54ab139334b3148b75"), customer.getCustomerID());
            assertEquals("Mauricio", customer.getFirstName());
            assertEquals("Leal", customer.getLastName());
            
        } catch(JAXBException ex) {
            fail("### Unable to unmarshalling content");
        }
    }
    
    @Test
    public void testConstructorCustomer() {
        System.out.printf("TTTT testConstructorCustomer()\n");
        // Invalid CustomerID
        try {
            Customer invalidCustomer = new Customer("helloworld");
            fail("### CustomerID should not be valid");
        } catch(InvalidException ex) {
            // Works just fine
        }
        
        // Valid CustomerID
        try {
            Customer validCustomer = new Customer("5a0b8d54ab139334b3148b75");
        } catch(InvalidException ex) {
            fail("### CustomerID is a valid ID");
        }
        
        // First and Last name
        Customer firstLastCustomer = new Customer("John", "Doe");
        assertEquals("John", firstLastCustomer.getFirstName());
        assertEquals("Doe", firstLastCustomer.getLastName());
        
        // INVALID VERSION: Customer ID, First and Last Name
        try {
            Customer customerIdFirstLast = new Customer("helloworld","John", "Doe");
            assertEquals("John", customerIdFirstLast.getFirstName());
            assertEquals("Doe", customerIdFirstLast.getLastName());
        } catch(InvalidException ex) {
            // It fails like a charm !!!
        }
        
        // VALID VERSION: Customer ID, First and Last Name
        try {
            Customer customerIdFirstLast2 = new Customer("5a0b8d54ab139334b3148b75", 
                                                                    "John", "Doe");
            assertEquals("John", customerIdFirstLast2.getFirstName());
            assertEquals("Doe", customerIdFirstLast2.getLastName());
            
        } catch(InvalidException ex) {
            fail("### CustomerID is not valid");
        }
        
        
    }
    
    @Test
    public void testJSON() {
        System.out.printf("TTTT testJSON()\n");
        try {
            Customer customer1 = new Customer("5a0b8d54ab139334b3148b75", "John", "Doe");
            JSONAssert.assertEquals("{\"_id\":\"5a0b8d54ab139334b3148b75\", \"firstName\":\"John\", \"lastName\":\"Doe\"}", 
                    customer1.toString(), false);
            
            Customer customer2 = new Customer("John", "Doe");
            JSONAssert.assertEquals("{\"lastName\":\"Doe\", \"firstName\":\"John\"}", 
                                                    customer2.toString(), false);
        
        } catch(InvalidException ex) {
            fail("### CustomerID is not valid");
        } catch(JSONException ex) {
            fail("### JSON Exception:"+ex.getMessage());
        }
        
    }
}
