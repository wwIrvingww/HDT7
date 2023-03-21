import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);
        Tree t = new Tree();

        //Declarar variables;
        int optionInp;
        int optionOut;

        //Obtener informacion del usuario
        System.out.println("Ingrese el idioma de entrada: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionInp = sc.nextInt();

        System.out.println("Ingrese el idioma de salida: \n(1)Ingles \n(2)Español \n(3)Frances");
        optionOut = sc.nextInt();

        if (optionInp == 1 & optionOut ==3 ){
            System.out.println("no es posible realizar esta traduccion");
        }
        else if (optionInp == 3 & optionOut ==1 ){
            System.out.println("no es posible realizar esta traduccion");
        }

    }
}
