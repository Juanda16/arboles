import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import models.Contac;
import java.io.IOException;
import util.FileTo;

//3. Conocer que personas están asociados a una característica particular en uno de sus genes.

public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // String inorden = "gehicbfdajklnmop";
        // String preorden = "abceghidflkjmnop";

        ArbolAVL<Contac> contactos = new ArbolAVL<Contac>();
        contactos = FileTo.agenda("src/contactos.txt"); // crear el directorio general 

        Contac contac = new Contac((Long.valueOf("3146011069")));

        System.out.println((contactos.buscar(contac)));// ejemplo buscar 

    }

}

// Lista de contactos ejecutivos=> //lista generalizada o un arbol n-ario aqui
// se van creando los contactos

// Identificador de llamadas =>Arbol AVL, número de telefono y a quien pertenece
// papá : Hijo
// 1. 13148284339 : 300123456
// 2. 300123456 : 301987654
// 3. 301987654 : 302345678
// 3. 301987654 : 302345679
// 1. 302345679 : 301987653 -> ojo con este que ya existía
// se pueden ingresar nuevos contactos de nivel 1 o de nivel 2 en adelante
