/*Julio M. Corral
jmcorral2@miners.utep.edu
MWF *10:30 to 11:20
04/27/10
Assignment#11, Jaime Nava
Binary Tree*/

//main class called TreeNodeClass where the user types 
//some number to create their binary tree
import java.util.Scanner;
public class TreeNodeClass 
{
    public static void main(String args [])
 {
        Scanner console=new Scanner(System.in);
        BinarySearchTree myTree = new BinarySearchTree();
        int num, nodes;
        //ask for how many nodes
        System.out.println("How many nodes do you want in your tree?: \n");
        nodes=console.nextInt();
        //depending of how many nodes, the user will type n numbers
        for (int i=0; i<nodes; i++)
        {
            System.out.println("Enter a number:  ");
            num=console.nextInt();
            //inserting the numbers in the binary tree
            myTree.insertNode(num);
        }
        //printing how many leaves are in your tree
        System.out.println("\nThis is the number of leaf or leaves" +
                           "that has your binary tree: "+
                           myTree.leafCount());
        //printing how many single parents are in your tree
        System.out.println("\nSingleParents in your binary tree: "+myTree.singleParent());
        // check the inorder traverse of your tree
        System.out.println("\nThis is the inorder secuences of your binary tree: ");  
        myTree.inOrderTraversal();

    }
}
