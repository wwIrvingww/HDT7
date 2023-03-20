import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);
        Tree t = new Tree();

        //Declarar variables;
        int optionInt;
        int optionOut;

        //Obtener informacion del usuario
        System.out.println("Ingrese el idioma de entrada: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionInt = sc.nextInt();

        System.out.println("Ingrese el idioma de salida: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionOut = sc.nextInt();


    }
}
