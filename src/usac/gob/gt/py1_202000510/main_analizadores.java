/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.gob.gt.py1_202000510;

import usac.gob.gt.py1_202000510.Analizadores.Lexico;
import java.io.FileInputStream;
import usac.gob.gt.py1_202000510.Estructuras.AFD;
import java.util.Map;
/**
 *
 * @author javie
 */
public class main_analizadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here;
    }
    
    private static void interpretar(String path) {
        usac.gob.gt.py1_202000510.Analizadores.Sintactico pars;
        try {
            Lexico lexical = new usac.gob.gt.py1_202000510.Analizadores.Lexico(new FileInputStream(path));
            pars=new usac.gob.gt.py1_202000510.Analizadores.Sintactico(lexical);
            pars.parse();
            Map<String, AFD> arbol = pars.LIST_AFD;
            System.out.println(arbol);
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex.getCause());
        } 
    }
}
