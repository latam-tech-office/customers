package testing;

import com.latam.techoffice.testdrive.Service;
import java.io.Serializable;
import java.util.logging.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com>
 */
@RunWith(Arquillian.class)
public class TestArquilian implements Serializable {

    private static final Logger LOG = Logger.getLogger(TestArquilian.class.getName());
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addClass(Service.class);
    }
    

    @Test
    public void testArquilian() {
        System.out.printf("TTT testArquilian()\n");
        
        fail("### testArquilian()");
    }

}
