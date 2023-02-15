package cse104_tutorial5;

public class IntBST {
    IntBTNode root;
	 
    /* Constructor */
    public IntBST()
    {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private IntBTNode insert(IntBTNode node, int data)
    {
        if (node == null){
            node = new IntBTNode(data);
            return node;
        }  
        if (data < node.data)
        	node.left = insert(node.left, data);
        else
        	node.right = insert(node.right,data);    	    
        return node;
    }     
    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(IntBTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Function to search for an element */
    public boolean search(int data)
    {
        return search(root, data);
    }
    /* Function to search for an element recursively */
    private boolean search(IntBTNode node, int data)
    {
        //Student's code here.
        return false;         
    }
    
    public void delete(int data){
    
        root = delete(root, data);
    
    }
    private IntBTNode delete(IntBTNode node, int data){
        
        //Student's code here. 
        return null;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        root.inorderPrint();
    }
    
    /* Function for preorder traversal */
    public void preorder()
    {
        root.preorderPrint();
    }
    
    /* Function for postorder traversal */
    public void postorder()
    {
        root.postorderPrint();
    }
    
}
