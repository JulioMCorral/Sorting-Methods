/*Julio M. Corral
jmcorral2@miners.utep.edu
MWF *10:30 to 11:20
04/27/10
Assignment#11, Jaime Nava
Binary Tree*/

//the class tree which state operation to do with the
//binary tree, in this case, insert, count leaves, and
//count single parents
import java.util.Scanner;
public class BinarySearchTree 
{

    //declare root private
    private BinaryTreeNode root;

    //default constructor
    public BinarySearchTree () 
    {
        root=null;
    }

    //insertNode method helps to add a new root in 
    //binary tree, if it is null, create other root          
    public void insertNode (int element)
    {
        if (root == null)
            root = new BinaryTreeNode(element);
        else
            root.insert(element);
    }
    
    //method inOrderMethod which traverse the binary tree
    //(root, leftSubTree, rightSubTree)
    private void inOrderMethod(BinaryTreeNode node)
    {
    	//if node is null, is empty
        if (node == null)
            return;
        //if not, travres the binary tree in a 
        //inorder way
        else 
        {
            inOrderMethod(node.lLink);
            System.out.print(" "+node.info+" :: ");
            inOrderMethod(node.rLink);
        }
    }

    //returns the result of the method inOrderMethod
    public void inOrderTraversal()
    {
        inOrderMethod(root);
    }
    
    //leafCountMethod helps to count which nodes do not have children
    private int leafCountMethod (BinaryTreeNode LC) 
    {
        //if node is null(root) retrun 0, 
        //invalidated
        if (LC == null)
            return 0;
        //travers each side of the node
        //if the left and right side are null
        //is a leaf, return 1
        else
            if (LC.rLink==null && LC.lLink==null)
            return 1;
        //recursion which goes to each node in the 
        //binary tree, at the end is adding how many 1's are in 
        //the binary tree
        else
            return leafCountMethod(LC.lLink) +
            leafCountMethod(LC.rLink);
    }
    
    //returns the result of the method leafCountMethod
    public int leafCount() 
    {
        int k=leafCountMethod(root);
        return k;
    }
    
    //this method counts how many parents only have one child
    private int singleParentMethod(BinaryTreeNode p)
    {
        //if node is null(root) retrun 0, 
        //invalidated
        if(p==null)
        {
            return 0;
        }
        //if the righ side or the left side are not null, 
        //returns 1, is a single parent
        else
        {
            //recursion which goes to each node in the 
            //binary tree, at the end is adding how many 1's are in 
            //the binary tree
            if((p.lLink!=null && p.rLink==null))
                return 1 + singleParentMethod(p.lLink);
            //travers for the rightsubtree of each parent
            else if (p.lLink==null&& p.rLink!=null)
            	return 1+ singleParentMethod(p.rLink);
            else
                return singleParentMethod(p.lLink)+singleParentMethod(p.rLink);
        }
    } 
    
    //return the result of the method singleParentMethod
    public int singleParent()
    {
        int p=singleParentMethod(root);
        return p;
    }
}
