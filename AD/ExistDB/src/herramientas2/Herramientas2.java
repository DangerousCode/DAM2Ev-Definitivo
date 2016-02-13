/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas2;

import PrimerosPasos.Ejemplo1;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author AlumnoT
 */
public class Herramientas2 {

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static Collection conectarDb(String Uri, String username, String password) throws XMLDBException {
        String Driver = "org.exist.xmldb.DatabaseImpl";
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/" + Uri;

        //Captura de excepciones. Pasos de conexión.
        try {
            Class C1 = Class.forName(Driver);
            org.xmldb.api.base.Database database = (org.xmldb.api.base.Database) C1.newInstance();
            DatabaseManager.registerDatabase(database);
            System.out.println("Inicializado el Driver");
        } catch (Exception e) {
            System.out.println("Error al iniciar la B.D.");
        }

        Collection col = DatabaseManager.getCollection(URI, username, password);
        if (col == null) {
            System.out.println("La coleccion no existe");
        } else {
            System.out.println("Te has conectado");
        }
        return col;
    }

    public static void consultaXQUERY(Collection col, String consulta) throws XMLDBException {
        XPathQueryService s = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        ResourceSet result = s.query(consulta);
        ResourceIterator i = result.getIterator();
        
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println(r.getContent());
        }
    }

}
