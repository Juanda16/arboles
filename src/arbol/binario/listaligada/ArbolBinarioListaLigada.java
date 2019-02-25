package arbol.binario.listaligada;

import arbol.nario.listageneralizada.NodoNario;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author alejandroescobar
 * @param <E>
 */
public class ArbolBinarioListaLigada<E> {

    protected NodoBinario raiz;

    public ArbolBinarioListaLigada() {
    }

    public ArbolBinarioListaLigada(NodoBinario<E> raiz) {
        this.setRaiz(raiz);
    }

    public void setRaiz(NodoBinario<E> raiz) {
        this.raiz = raiz;
    }

    public NodoBinario getRaiz() {
        return raiz;
    }

    /**
     * Para la construcción de un arbol con las cadenas PRE e IN
     */
    public static NodoBinario construyeArbolCadenaPREyIN(Character[] preorden, Character[] inorden) throws Exception {
        NodoBinario r = reconstuir(preorden, inorden);
        return r;
    }

    /**
     * Esta función es recursiva, se llama una y otra vez Para la construcción
     * de un arbol con las cadenas PRE e IN
     *
     * @param preorden
     * @param inorden
     * @return
     */
    private static NodoBinario reconstuir(Character[] preorden, Character[] inorden) throws Exception {
        /**
         * Se extrae el dato con la raiz de esta ejecución y se crea el nodo con
         * ese caracter
         */
        char dr = preorden[0];
        NodoBinario r = new NodoBinario(dr);

        /**
         * Evalua la parte más izquierda
         */
        int posDatoRaizEnInorden = buscarEnVector(inorden, dr);
        Character[] nuevoVectorInorden = cortarIzquierda(inorden, posDatoRaizEnInorden);
        int posPreorden = 0;
        Character[] nuevoPreorden;
        if (nuevoVectorInorden.length != 0) {
            posPreorden = nuevoVectorInorden.length;
            nuevoPreorden = cortarNDatos(preorden, 1, posPreorden + 1);
            if (posPreorden != 0) {
                r.setLi(reconstuir(nuevoPreorden, nuevoVectorInorden)); // Llamado recursivo
            }
        }

        /**
         * Evalua la parte más derecha
         */
        nuevoVectorInorden = cortarDerecha(inorden, posDatoRaizEnInorden);
        if (nuevoVectorInorden.length != 0) {
            nuevoPreorden = cortarNDatos(preorden, posPreorden + 1, nuevoVectorInorden.length + posPreorden + 1);
            r.setLd(reconstuir(nuevoPreorden, nuevoVectorInorden));
        }
        return r;
    }

    /**
     * Busca un caracter en un vector de caracteres
     */
    public static int buscarEnVector(Character[] arr, char dr) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(dr)) {
                return i;
            }
        }
        throw new Exception("No se encuentra en el Vector");
    }

    public static Character[] cortarIzquierda(Character[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, 0, pdrin);
    }

    private static Character[] cortarNDatos(Character[] arr, int i, int f) {
        return Arrays.copyOfRange(arr, i, f);
    }

    private static Character[] cortarDerecha(Character[] arr, int pdrin) {
        return Arrays.copyOfRange(arr, pdrin + 1, arr.length);
    }

    public int altura() throws Exception {
        throw new Exception("Sin codigo");
    }

    public static void inorden(NodoBinario r) {
        if (r != null) {
            inorden(r.getLi());
            System.out.print(r.getDato());
            inorden(r.getLd());
        }
    }

    public static int hojas(NodoBinario r) {
        int hh = 0;
        if (r != null) {
            if (r.getLi() == null && r.getLd() == null) {
                hh = hh + 1;
            } else {
                hh = hh + hojas(r.getLi()) + hojas(r.getLd());
            }

        }
        return hh;
    }

    /**
    public static void contarHojas() {
        int numeroHojas = 0;
        numeroHojas = contarHojasRecursivo(raiz, numeroHojas);
    }

    public static int contarHojasRecursivo(NodoBinario r, int nh) {
        if (r != null) {
            nh = nh + contarHojasRecursivo(r.getLi(), nh);
            if (r.getLi() == null && r.getLd() == null) {
                nh = nh + 1;
            }
            nh = nh + contarHojasRecursivo(r.getLd(), nh);
        }
        return nh;
    }
**/
    
    public void recorrido1() {
        Queue<NodoBinario> queue = new LinkedList<>();
        System.out.println("Comienzo recorrido1");
        if (raiz != null) {
            queue.add(raiz);
            NodoBinario a;
            while (!queue.isEmpty()) {
                a = queue.poll();
                System.out.print(a.getDato() + ",");
                if (a.getLi() != null) {
                    queue.add(a.getLi());
                }
                if (a.getLd() != null) {
                    queue.add(a.getLd());
                }
            }
        }
    }

    public void recorrido2() {
        Stack<NodoBinario> stac = new Stack<>();

        System.out.println("Comienzo recorrido2");
        if (raiz != null) {
            stac.add(raiz);
            NodoBinario a;
            while (!stac.isEmpty()) {
                a = stac.pop();
                System.out.print(a.getDato() + ",");
                if (a.getLi() != null) {
                    stac.add(a.getLi());
                }
                if (a.getLd() != null) {
                    stac.add(a.getLd());
                }
            }
        }
    }

    public static void inordenNR(NodoBinario r) {
        Stack<NodoBinario> migas = new Stack<>();
        migas.add(r);
        r = r.getLi();
        while (!migas.isEmpty() || r != null) {
            if (r != null) {
                migas.add(r);
                r = r.getLi();
            } else {
                r = migas.pop();
                System.out.print(r.getDato());
                r = r.getLd();
            }
        }
    }

    public static void preorden(NodoBinario r) {
        if (r != null) {
            System.out.print(r.getDato());
            preorden(r.getLi());
            preorden(r.getLd());
        }
    }

    public static NodoBinario convertirArbolNario2ArbolBinario(NodoNario rlg) {
        NodoBinario raizBinario = new NodoBinario(rlg.getDato());
        NodoNario p = rlg.getLiga();
        NodoNario q = null;
        NodoBinario xBinario = raizBinario;
        NodoBinario ultimoBinario = xBinario;

        Stack pila = new Stack();
        while (p != null) {
            if (p.getSw() == 0) {
                xBinario = new NodoBinario(p.getDato());
            } else {
                q = ((NodoNario) p.getDato());
                xBinario = new NodoBinario(q.getDato());
                pila.add(xBinario);
                pila.add(q.getLiga());
            }
            ultimoBinario.setLi(xBinario);
            ultimoBinario = xBinario;
            p = q.getLiga();
            while (p != null) {
                if (p.getSw() == 0) {
                    xBinario = new NodoBinario(p.getDato());
                } else {
                    q = ((NodoNario) p.getDato());
                    xBinario = new NodoBinario(q.getDato());
                    pila.add(xBinario);
                    pila.add(q.getLiga());
                }
                ultimoBinario.setLd(xBinario);
                ultimoBinario = xBinario;
                p = q.getLiga();
            }
            if (!pila.isEmpty()) {
                p = (NodoNario) pila.pop();
                ultimoBinario = (NodoBinario) pila.pop();
            }

        }
        return raizBinario;

    }

}
