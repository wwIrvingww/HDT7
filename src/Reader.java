import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    /**
     * Metodo que lee un text file
     * @param fileName
     * @return
     */
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.toLowerCase();
                System.out.println(line.getClass());
                lines.add(line);
            }

            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo '" + fileName + "'");
            ex.printStackTrace();
        }
        return lines;
    }


    /**
     * Separa las oraciones en palabras
     * @param sentences
     * @return
     */
    public static ArrayList<String> spliter(ArrayList<String> sentences) {
        ArrayList<String> words = new ArrayList<>();
        for (String oracion : sentences) {
            String[] palabrasOracion = oracion.split(" ");
            for (String palabra : palabrasOracion) {
                words.add(palabra);
            }
        }
        return words;
    }

    public static ArrayList<String> spliter(String cadena) {
        String[] arreglo = cadena.split(" "); // dividir la cadena por espacios en blanco
        ArrayList<String> lista = new ArrayList<String>(); // crear un ArrayList vacío para almacenar las palabras
        for (int i = 0; i < arreglo.length; i++) {
            lista.add(arreglo[i]); // agregar cada palabra al ArrayList
        }
        return lista; // retornar el ArrayList con las palabras
    }







}
