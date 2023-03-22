import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryTree {

    private static Node root;

    public static void addWord(String other, String spanish) {
        other = other.toLowerCase();
        spanish = spanish.toLowerCase();
        if (root == null) {
            root = new Node(other, spanish);
        } else {
            addWord(root, other, spanish);
        }
    }

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

    public String translate(String other) {
        Node node = find(root, other);
        if (node == null) {
            return "*"+other+"*";
        } else {
            return node.spanish;
        }
    }

    private Node find(Node node, String other) {
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


    public void addWordsFromFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            String word = parts[0].trim();
            String translation = parts[1].trim();
            addWord(word, translation);
        }

        bufferedReader.close();
        fileReader.close();
    }

    public void addWordsFromFile(String filename, int wordIndex) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                if (words.length == 3) {
                    String key = words[wordIndex - 1].trim().toLowerCase();
                    String value = words[wordIndex].trim().toLowerCase();
                    addWord(key, value);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    public static void leerArchivo(String rutaArchivo, int parametro) {
        //HashMap<String, String> mapa = new HashMap<>();

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
                } else if (parametro == 3) {
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




}