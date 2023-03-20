import java.util.TreeMap;

public class Tree {
    private TreeMap<String, String> dictionary;

    public Tree() {
        dictionary = new TreeMap<>();
    }

    public void addWord(String palabra, String traduccion) {
        dictionary.put(palabra, traduccion);
    }

    public String translateWord(String palabra) {
        return dictionary.get(palabra);
    }

    public boolean containsWord(String palabra) {
        return dictionary.containsKey(palabra);
    }

    public void eliminarPalabra(String palabra) {
        dictionary.remove(palabra);
    }
}
