package com.latam.techoffice.testdrive.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

import com.latam.techoffice.testdrive.error.InvalidException;
/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com>
 */
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {
    
    public static final String COLLECTION = "customers";

    private static final Logger LOG = Logger.getLogger(Customer.class.getName());

    public static final String TAG_CUSTOMER_ID = "_id";
    @XmlElement(name = TAG_CUSTOMER_ID, nillable = true, required = false)
    private ObjectId customerID;
    
    public static final String TAG_FIRST_NAME = "firstName";
    @XmlElement(name = TAG_FIRST_NAME, nillable = false, required = true)
    private String firstName;
    
    public static final String TAG_LAST_NAME = "lastName";
    @XmlElement(name = TAG_LAST_NAME, nillable = false, required = true)
    private String lastName;
    
    public Customer() {
    }

    public Customer(String customerID) throws InvalidException {
        setCustomerID(customerID);
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String customerID, String firstName, String lastName) 
                                                        throws InvalidException {
        setCustomerID(customerID);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Customer(ObjectId customerID, String firstName, String lastName) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public ObjectId getCustomerID() {
        return customerID;
    }
    
    public final void setCustomerID(String customerID) throws InvalidException {
        if(customerID == null) throw new InvalidException("customerID is null");
        if(!ObjectId.isValid(customerID))
            throw new InvalidException("customerID is not valid number: "+customerID);
        
        setCustomerID(new ObjectId(customerID));
    }

    public void setCustomerID(ObjectId customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.customerID);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerID, other.customerID)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
    public JsonObject toJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        if(this.customerID != null) 
            builder.add(TAG_CUSTOMER_ID, this.customerID.toString());
        
        if(this.firstName != null)
            builder.add(TAG_FIRST_NAME, this.firstName);
        
        if(this.lastName != null)
            builder.add(TAG_LAST_NAME, this.lastName);
        
        return builder.build();
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
}
