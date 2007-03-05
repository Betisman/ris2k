/*
 * TestXml.java
 *
 * Created on 4 de marzo de 2007, 21:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import model.Territorio;

/**
 *
 * @author Carlos
 */
public class TestXml {
    
    /** Creates a new instance of TestXml */
    public TestXml() {
        try {
            JAXBContext jctx = JAXBContext.newInstance(Territorio.class);
            Unmarshaller u = jctx.createUnmarshaller();
            // Creamos un cliente sherlock desde xml
            Territorio t = (Territorio)u.unmarshal(new FileInputStream("web/test/newYork.xml"));
            Marshaller m = jctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            // Serializamos el cliente sherlock una vez que el gestor de entidades 
            // le ha asignado los identificadores. Al no tener direcciones asignadas
            // algunos campos aparecen como nulos
            //m.marshal(t,new FileOutputStream("misc/output/test1.xml"));
        } catch (PropertyException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestXml test1 = new TestXml();
    }
    
}
