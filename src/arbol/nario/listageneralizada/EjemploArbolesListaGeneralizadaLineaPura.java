/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.nario.listageneralizada;

/**
 *
 * @author alejandroescobar
 */
public class EjemploArbolesListaGeneralizadaLineaPura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String h = "(a(b(c,d(e)),f,g(h,i(j,k(l)),m,n)))";
        ArbolNarioListaGeneralizada arbolLG = new ArbolNarioListaGeneralizada(h);
        
        arbolLG.lineaPura('e');
        System.out.println("");
        arbolLG.lineaPura('j');

    }

}
