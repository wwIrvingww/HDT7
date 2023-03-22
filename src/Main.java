import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);
        BinaryTree translator = new BinaryTree();
        Reader reader = new Reader();


        //Declarar variables;
        int optionInp;
        String pathText = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT6-Dictionary\\HDT7\\src\\Text.txt";
        String pathTranslations = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT6-Dictionary\\HDT7\\src\\Translations.txt";
        ArrayList<String> sentences = Reader.readFile(pathText);

        //Bienvenida
        String welcome = "─▌█──║─║╔═║─║─╔═╗─\n" +
                "─███─╠═╣╠═║─║─║─║─\n" +
                "─▐█▐─║─║╚═╚═╚═╚═╝─\n" +
                "─▐▐───────────────\n" +
                "─▐▐───────────────";
        System.out.println(welcome);

        //Solicitar informacion al usuario
        System.out.println("Ingrese el idioma de entrada: \n(1)Ingles\n(2)Frances");
        optionInp = sc.nextInt();

        //Leer los acrchivos del txtfile
        BinaryTree.readFile(pathTranslations,optionInp);


        //Reocorrer las lineas del textFile y traducir cada palabra
        System.out.println("El texto traducido es:\n");
        for (String s : sentences) {
            String[] palabras = s.split(" ");
            StringBuilder traduccion = new StringBuilder();
            for (String palabra : palabras) {
                String traduccionPalabra = translator.translate(palabra);
                traduccion.append(traduccionPalabra).append(" ");
            }
            System.out.println(traduccion.toString().trim());
        }
    }
}
