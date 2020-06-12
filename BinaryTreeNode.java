/*Julio M. Corral
jmcorral2@miners.utep.edu
MWF *10:30 to 11:20
04/27/10
Assignment#11, Jaime Nava
Binary Tree*/

//the class TreeNode implementing binary nodes
//creation of your tree
public class BinaryTreeNode
{
 
    //creating the left and right sub tree
    //and the information that will be stored in
    //each node
    BinaryTreeNode lLink;
    BinaryTreeNode rLink;
    int info;
    
    //constructor of treenode
    public BinaryTreeNode (int item) 
    {
        info=item;
        lLink=rLink=null;
    }
    //method insert which construct the binary tree
    public void insert(int item)
    {
        //place the numbers lower than the root to the left
        if (item <info)
        {
            if (lLink == null)
                lLink = new BinaryTreeNode(item);
            else
                lLink.insert(item);
        }
        //place hte numbers greater than the root to the right
        else
            if (item > info) 
        {
            if (rLink == null)
                rLink= new BinaryTreeNode(item);
            else
                rLink.insert(item);
        }
    }    
}