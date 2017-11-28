package com.latam.techoffice.testdrive;

import java.io.Serializable;
import java.util.logging.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com>
 */
@RunWith(Arquillian.class)
public class TestResource implements Serializable {

    private static final Logger LOG = Logger.getLogger(TestResource.class.getName());
    
    /**
     * Creating a micro-deployment */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
    }

    public TestResource() {
    }

}
