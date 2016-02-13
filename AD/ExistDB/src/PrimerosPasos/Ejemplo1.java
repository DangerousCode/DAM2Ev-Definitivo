/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerosPasos;
import herramientas2.Herramientas2;

/**
 *
 * @author AlumnoT
 */
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
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Obtencion de coleccion y establecimiento de conexion
            Collection col=herramientas2.Herramientas2.conectarDb("Bailes","admin","admin");
            //Consulta
            herramientas2.Herramientas2.consultaXQUERY(col, "let $i := //baile/nombre return <los-bailes>{$i}</los-bailes>");
        } catch (XMLDBException ex) {
            Logger.getLogger(Ejemplo1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
