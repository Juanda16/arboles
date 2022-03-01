package util;

import java.io.*;

import javax.xml.stream.events.NotationDeclaration;

import arbol.binario.listaligada.busqueda.avl.ArbolAVL;
import arbol.binario.listaligada.busqueda.avl.NodoAVL;
import arbol.binario.listaligada.busqueda.normal.ArbolBinarioBusquedaGenerico;
import arbol.binario.listaligada.busqueda.normal.NodoBinarioBusqueda;
import arbol.nario.listageneralizada.ArbolNarioListaGeneralizada;
import arbol.nario.listageneralizada.NodoNario;
import models.Contac;
import models.DnaTest;
import models.DnaTestGen1;

public class FileTo {

    public static final String SEPARATOR = ";";
    public static final String QUOTE = "\"";
    public static final String COLON_SEPARATOR = ":";
    /**
     * @param filePath
     * @return MatrizEnTripleta
     * @throws IOException
     */
    public static ArbolAVL<DnaTest> recordTree(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            ArbolAVL<DnaTest> recordById = new ArbolAVL<DnaTest>();
            ArbolAVL<DnaTest> recordByGen1 = new ArbolAVL<DnaTest>();
            ArbolAVL<DnaTest> recordByGen2 = new ArbolAVL<DnaTest>();
            ArbolAVL<DnaTest> recordByGen3 = new ArbolAVL<DnaTest>();
            ArbolAVL<DnaTest> recordByGen4 = new ArbolAVL<DnaTest>();
            recordByGen3 = new ArbolAVL<DnaTest>();
            ArbolAVL<DnaTest> recordAvl = new ArbolAVL<DnaTest>();
            ArbolNarioListaGeneralizada recordNario = new ArbolNarioListaGeneralizada(new NodoNario(null));
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
                recordById.insertarDato(tempTest);
                tempTest.setIndex(fields[2]);
                recordByGen1.insertarDato(tempTest);
                tempTest.setIndex(fields[3]);
                recordByGen2.insertarDato(tempTest);
                tempTest.setIndex(fields[4]);
                recordByGen3.insertarDato(tempTest);
                tempTest.setIndex(fields[5]);
                recordByGen4.insertarDato(tempTest);

                NodoNario result = new NodoNario(tempTest);
                recordNario.insertarNuevoHijo(result);
                line = br.readLine();

            }

            return recordAvl;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        } finally {
            if (null != br) {
                br.close();
            }
        }

    }

    public static ArbolAVL<Contac> agenda(String filePath) throws IOException {

        BufferedReader br = null;

        try {

            ArbolAVL<Contac> directorio = new ArbolAVL<Contac>();
            
            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            while (null != line) {

                String[] fields = line.split(COLON_SEPARATOR);

                fields[0]=fields[0].replaceAll(" ","");

                Contac tempContac = new Contac();
                tempContac.setPhoneNumber(Long.parseLong(fields[0]));
                tempContac.setName(fields[1]);
                directorio.insertarDato(tempContac);
;

                line = br.readLine();

            }

            return directorio;
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