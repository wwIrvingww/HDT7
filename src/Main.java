import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);
        BinaryTree translator = new BinaryTree();


        //Declarar variables;
        int optionInp;
        int optionOut;

        String pathText = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT6-Dictionary\\HDT7\\src\\Text.txt";
        String pathTranslations = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT6-Dictionary\\HDT7\\src\\Translations.txt";
        //Obtener informacion del usuario


        System.out.println("Ingrese el idioma de entrada: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionInp = sc.nextInt();

        if (optionInp == 2){
            System.out.println("");
        }

        /**System.out.println("Ingrese el idioma de salida: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionOut = sc.nextInt();*/

        BinaryTree.leerArchivo(pathTranslations,optionInp);
        System.out.println(translator.translate("hello"));



    }
}
