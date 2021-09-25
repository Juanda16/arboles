import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import arbol.binario.listaligada.normal.ArbolBinarioListaLigada;
import arbol.binario.listaligada.normal.NodoBinarioGenerico;
import models.DnaTest;
import java.io.IOException;
import util.FileTo;
import util.LevenshteinDistance;

//3. Conocer que personas están asociados a una característica particular en uno de sus genes.

public class main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // String inorden = "gehicbfdajklnmop";
        // String preorden = "abceghidflkjmnop";
        //509403;FRANCISCO;Almagro;00FFFF;AB232BCF5;Cabeza;1450216
        DnaTest tempTest = new DnaTest();
                tempTest.setUserId(509403);
                tempTest.setName("FRANCISCO");
                tempTest.setGen1("Almagro");
                tempTest.setGen2("00FFFF");
                tempTest.setGen3("AB232BCF5");
                tempTest.setGen4("Cabeza");
                tempTest.setFatherId(1450216);


        ArbolAVL<DnaTest> record = new ArbolAVL<DnaTest>();
        record = FileTo.recordTree("src/muestras.csv");
        DnaTest dato= (DnaTest) (record.buscar(tempTest)).getDato();
        NodoAVL<DnaTest> response = new NodoAVL<DnaTest> (dato);
        System.out.println(response.toString());
        String inorden = "gehicrbfdajklnmop";

        String preorden = "abceghirdflkjmnop";

        Character[] inordenCH = convertirChar2Character(inorden);
        Character[] preordenCH = convertirChar2Character(preorden);

        String str1 = "identificar";
        String str2 = "identify";

        LevenshteinDistance ld = new LevenshteinDistance();
        ld.setWords(str1, str2);

        // Mostrar resultados
        System.out.println("Palabra1: " + str1);
        System.out.println("Palabra2: " + str2);
        System.out.println("\nDistancia de Levenshtein:\n" + ld.getDistancia());
        System.out.println("Afinidad:\n" + ld.getAfinidad() * 100 + " %");

        ArbolBinarioListaLigada abll = new ArbolBinarioListaLigada();
        NodoBinarioGenerico raiz = abll.construyeArbolCadenaPREyIN(preordenCH, inordenCH);

        abll.setRaiz(raiz);
        ArbolBinarioListaLigada.inorden(raiz);
    }

    private static Character[] convertirChar2Character(String cadena) {
        Character[] nuevoCH = new Character[cadena.length()];
        for (int i = 0; i < cadena.length(); i++) {
            Character c = cadena.charAt(i);
            nuevoCH[i] = c;
        }
        return nuevoCH;
    }

}
