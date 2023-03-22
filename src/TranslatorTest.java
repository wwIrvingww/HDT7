/**
 * Pruebas unitarias
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TranslatorTest {

    @Test
    public void addTest (){
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.addWord("hello","hola");
        String esperado = "hola";
        String resultado = binaryTree.translate("hello");
        assertEquals(esperado,resultado);

    }

    @Test
    public void translateTest (){
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.addWord("dog","perro");
        String esperado = "perro";
        String resultado = binaryTree.translate("dog");
        assertEquals(esperado,resultado);

    }

    @Test
    public void findTest () {
        BinaryTree tree = new BinaryTree();
        tree.addWord("apple", "manzana");

        Node result = tree.find(tree.getRoot(), "apple");
        assertNotNull(result);


    }



}
