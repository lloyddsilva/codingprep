package edu.cmu.lloyddsilva;

/*********************************************************
 *				BinaryTree Implementation
 ********************************************************/


public class BinaryTree
{	
	public static class pTwoChildNode
	{
	    protected Object data;
	    protected pTwoChildNode left,right;
	
	    public pTwoChildNode(){
	        data = null;
	        left = right = null;
	    }
	    public pTwoChildNode(Object d){
	        data = d;
	        left = right = null;
	    }
	    public void setLeft(pTwoChildNode l){
	        left = l;
	    }
	    public void setRight(pTwoChildNode r){
	        right = r;
	    }
	    public void setData(Object d){
	        data = d;
	    }
	    public pTwoChildNode getLeft(){
	        return left;
	    }
	    public pTwoChildNode getRight(){
	        return right;
	    }
	    public Object getData(){
	        return data;
	    }
	    public String toString(){
	        return ""+data;
	    }
	}

	
	public static abstract class pGenericBinaryTree
	{
	    private pTwoChildNode root;
	
	    protected pTwoChildNode getRoot(){
	        return root;
	    }
	    protected void setRoot(pTwoChildNode r){
	        root = r;
	    }
	    public pGenericBinaryTree(){
	        setRoot(null);
	    }
	    public pGenericBinaryTree(Object o){
	        setRoot(new pTwoChildNode(o));
	    }
	    public boolean isEmpty(){
	        return getRoot() == null;
	    }
	    public Object getData(){
	        if(!isEmpty())
	            return getRoot().getData();
	        return null;
	    }
	    public pTwoChildNode getLeft(){
	        if(!isEmpty())
	            return getRoot().getLeft();
	        return null;
	    }
	    public pTwoChildNode getRight(){
	        if(!isEmpty())
	            return getRoot().getRight();
	        return null;
	    }
	    public void setData(Object o){
	        if(!isEmpty())
	            getRoot().setData(o);
	    }
	    public void insertLeft(pTwoChildNode p,Object o){
	        if((p != null) && (p.getLeft() == null))
	            p.setLeft(new pTwoChildNode(o));
	    }
	    public void insertRight(pTwoChildNode p,Object o){
	        if((p != null) && (p.getRight() == null))
	            p.setRight(new pTwoChildNode(o));
	    }
	    public void print(int mode){
	        if(mode == 1) pretrav();
	        else if(mode == 2) intrav();
	        else if(mode == 3) postrav();
	    }
	    public void pretrav(){
	        pretrav(getRoot());
	    }
	    protected void pretrav(pTwoChildNode p){
	        if(p == null)
	            return;
	        System.out.print(p.getData()+" ");
	        pretrav(p.getLeft());
	        pretrav(p.getRight());
	    }
	    public void intrav(){
	        intrav(getRoot());
	    }
	    protected void intrav(pTwoChildNode p){
	        if(p == null)
	            return;
	        intrav(p.getLeft());
	        System.out.print(p.getData()+" ");
	        intrav(p.getRight());
	    }
	    public void postrav(){
	        postrav(getRoot());
	    }
	    protected void postrav(pTwoChildNode p){
	        if(p == null)
	            return;
	        postrav(p.getLeft());
	        postrav(p.getRight());
	        System.out.print(p.getData()+" ");
	    }
	}
	
	
	public static interface pComparable
	{
    	public int compareTo(Object o);
    }
	
	public static class pInteger implements pComparable
	{
	    int i;
	
	    public pInteger(){
	    }
	    public pInteger(int j){
	        set(j);
	    }
	    public int get(){
	        return i;
	    }
	    public void set(int j){
	        i = j;
	    }
	    public String toString(){
	        return ""+get();
	    }
	    public int compareTo(Object o){
	        if(o instanceof pInteger)
	            if(get() > ((pInteger)o).get())
	                return 1;
	            else if(get() < ((pInteger)o).get())
	                return -1;
	        return 0;
	    }
	}
	
	public static class pBinarySearchTree extends pGenericBinaryTree
	{
	
	    public pBinarySearchTree(){
	        super();
	    }
	
	    public pBinarySearchTree(Object o){
	        super(o);
	    }
	
	    public void print(){
	        print(2);
	    }
	
	    public void insert(pComparable o){
	        pTwoChildNode t,q;
	        for(q = null, t = getRoot();
	            t != null && o.compareTo(t.getData()) != 0;
	            q = t,t = o.compareTo(t.getData()) < 0
	                ? t.getLeft():t.getRight());
	        if(t != null)
	            return;
	        else if(q == null)
	            setRoot(new pTwoChildNode(o));
	        else if(o.compareTo(q.getData()) < 0)
	            insertLeft(q,o);
	        else
	            insertRight(q,o);
	    }
	}


	public static void main(String[] args)
	{
        pBinarySearchTree tree = new pBinarySearchTree();
        pInteger n;
        int i;
        System.out.println("Numbers inserted:");
        for(i=0;i<10;i++){
            tree.insert(n=new pInteger((int)(Math.random()*1000)));
            System.out.print(n+" ");
        }
        System.out.println("\nPre-order:");
        tree.print(1);
        System.out.println("\nIn-order:");
        tree.print();
        System.out.println("\nPost-order:");
        tree.print(3);
    }

}