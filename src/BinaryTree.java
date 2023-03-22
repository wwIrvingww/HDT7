/**
 * Clase que implementa el arbol binario solicitado
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTree {
    private static Node root;
    public static Node getRoot() {
        return root;
    }



    /**
     * Agrega palabaras al mapa. La key es la palabra en el idioma extranjero y el value es su significado en español
     * @param other
     * @param spanish
     */
    public static void addWord(String other, String spanish) {
        other = other.toLowerCase();
        spanish = spanish.toLowerCase();
        if (root == null) {
            root = new Node(other, spanish);
        } else {
            addWord(root, other, spanish);
        }
    }

    /**
     * Agrega una nueva palabra al árbol de búsqueda binaria en orden alfabético basandose en OTHER, (la palabra en otro idioma)
     * y su traducción al español. Si ya existe, cambia el valo
     * @param node
     * @param other
     * @param spanish
     */
    private static void addWord(Node node, String other, String spanish) {
        other = other.toLowerCase();
        spanish = spanish.toLowerCase();
        if (other.compareTo(node.other) < 0) {
            if (node.left == null) {
                node.left = new Node(other, spanish);
            } else {
                addWord(node.left, other, spanish);
            }
        } else if (other.compareTo(node.other) > 0) {
            if (node.right == null) {
                node.right = new Node(other, spanish);
            } else {
                addWord(node.right, other, spanish);
            }
        } else {
            node.spanish = spanish;
        }
    }

    /**
     * Retorna el valor de la key, literalmente traduce basandose en la funcion find
     * @param other
     * @return
     */
    public String translate(String other) {
        Node node = find(root, other);
        if (node == null) {
            return "*"+other+"*";
        } else {
            return node.spanish;
        }
    }

    /**
     * Busca en el nodo que contiene el valor de la key solicitada
     * @param node
     * @param other
     * @return
     */
    public Node find(Node node, String other) {
        if (node == null) {
            return null;
        } else if (other.compareTo(node.other) == 0) {
            return node;
        } else if (other.compareTo(node.other) < 0) {
            return find(node.left, other);
        } else {
            return find(node.right, other);
        }
    }


    /**
     * Lee el archivo que contiene el banco de palabras con sus traducciones y los almacena en un mapa.
     * El parametro sirve para saber si tomar la palabra en ingles (1) o la palabra en frances (2)
     * @param rutaArchivo
     * @param parametro
     */
    public static void readFile(String rutaArchivo, int parametro) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(",");
                if (palabras.length != 3) {
                    System.out.println("Error: la línea \"" + linea + "\" no contiene 3 palabras separadas por comas");
                    continue;
                }

                String key, value;
                if (parametro == 1) {
                    key = palabras[0];
                    value = palabras[1];
                } else if (parametro == 2) {
                    key = palabras[2];
                    value = palabras[1];
                } else {
                    System.out.println("Error: el parámetro debe ser 1 o 3");
                    return;
                }

                addWord(key, value);
            }
        } catch (IOException e) {
            System.out.println("Error: no se pudo leer el archivo " + rutaArchivo);
            return;
        }

    }

    public static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print("(" + node.other + ", " + node.spanish + ") ");
            printInOrder(node.right);
        }
    }

}