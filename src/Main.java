import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);
        BinaryTree t = new BinaryTree();


        //Declarar variables;
        int optionInp;
        int optionOut;

        String path = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT6-Dictionary\\HDT7\\src\\Text.txt";
        //Obtener informacion del usuario

        /**
        System.out.println("Ingrese el idioma de entrada: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionInp = sc.nextInt();

        System.out.println("Ingrese el idioma de salida: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionOut = sc.nextInt();

        //Verifica que no sea de ingles-frances o viceversa.
        if (optionInp == 1 & optionOut ==3 ){
            System.out.println("no es posible realizar esta traduccion");
        }
        else if (optionInp == 3 & optionOut ==1 ){
            System.out.println("no es posible realizar esta traduccion");
        }*/

        ArrayList<String> text = Reader.readFile(path);

        text = Reader.spliter(text);

        for (String s: text){
            System.out.println(s);
        }



    }
}
