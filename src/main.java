import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import models.DnaTest;
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

        ArbolAVL<DnaTest> record = new ArbolAVL<DnaTest>();
        record = FileTo.recordTree("src/muestras.csv");

    }

}
