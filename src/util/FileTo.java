package util;

import java.io.*;

import javax.xml.stream.events.NotationDeclaration;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusquedaGenerico;
import arbol.binario.listaligada.busqueda.normal.NodoBinarioBusqueda;
import arbol.nario.listageneralizada.ArbolNarioListaGeneralizada;
import arbol.nario.listageneralizada.NodoNario;
import ejemplos.grafico.arbol.binario.busqueda.biblioteca.NodoBinario;
import models.DnaTest;
import models.DnaTestGen1;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";

    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */
    public static ArbolAVL<DnaTest> recordTree(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            ArbolAVL<DnaTest> recordByGen2 = new ArbolAVL<DnaTest>();

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            while (null != line) {

                String[] fields = line.split(SEPARATOR);

                DnaTest tempTest = new DnaTest();
                tempTest.setUserId(Integer.parseInt(fields[0]));
                tempTest.setName(fields[1]);
                tempTest.setGen1(fields[2]);
                tempTest.setGen2(fields[3]);
                tempTest.setGen3(fields[4]);
                tempTest.setGen4(fields[5]);
                tempTest.setFatherId(Integer.parseInt(fields[6]));
                tempTest.setIndex(fields[0]);

                recordByGen2.insertarDato(tempTest);
                line = br.readLine();

            }

            return recordByGen2;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        } finally {
            if (null != br) {
                br.close();
            }
        }

    }
}