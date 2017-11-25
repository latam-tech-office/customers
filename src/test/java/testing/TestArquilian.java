package testing;

import com.latam.techoffice.testdrive.Service;
import java.io.Serializable;
import java.util.logging.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com>
 */
@RunWith(Arquillian.class)
public class TestArquilian implements Serializable {

    private static final Logger LOG = Logger.getLogger(TestArquilian.class.getName());
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).addClass(Service.class);
    }
    
//    @ArquillianResource
//    private URL deploymentURL;
//    
//    @Deployment
//    public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class)
//                .addPackage(Resource.class.getPackage())
//                .addClass(RESTEnabled.class).addClass(Service.class).addClass(Resource.class);
//    }
    
    

    @Test
    public void testArquilian() {
        System.out.printf("TTT testArquilian()\n");
        
//        fail("### testArquilian()");
    }
    
//    @Test
//    public void testResource(@ArquillianResteasyResource Resource resource) {
//        System.out.printf(">>> TTTT testResource()\n");
//        
//        // Given
//        String name = "Mauricio Leal";
//        // When
//        Response response = resource.myName();
//        // Then
//        assertEquals(name, response.getEntity().toString());
//    }
//    
//    @Test
//    @RunAsClient
//    public void testResourceWebTarget(@ArquillianResteasyResource("api") ResteasyWebTarget target) {
//        System.out.printf(">>> TTTT testResourceWebTarget()\n");
//        System.out.printf(">>> WebTarget is NULL ? %s\n", target == null ? "NULL" : "NOT NULL");
//        assertNotNull(target);
//        
//        String name = "Mauricio Leal";
//        String content = target.path("/resource").request(MediaType.TEXT_PLAIN).get(String.class);
//        assertEquals(name, content);
//    }
    

}
