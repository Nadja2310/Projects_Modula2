package telran;

public class Main {
    public static void main(String[] args) {
        Node nine=new Node("9",null,null);
        Node seven = new Node("7",null,null);
        Node eight=new Node("8",nine,null);
        Node six=new Node("6",seven,eight);
        Node five=new Node("5",six,null);
        Node one=new Node ("1",null,null);
        Node three=new Node("3",null,null);
        Node two=new Node("2",one,three);
        Node four=new Node("4",two,five);
        Node four2=new Node("4",two,null);


        System.out.println("Vertex number: "+getVertexNumber(four));
        System.out.println("Vertex number: "+getVertexNumber(four2));
        System.out.println("Vertex number: "+getVertexNumber(nine));
        System.out.println("Height tree: "+getHeight(four));
        System.out.println("Height tree: "+getHeight(four2));
        System.out.println("Height tree: "+getHeight(nine));

    }
    public static int getVertexNumber(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        return getVertexNumber(root.left) + getVertexNumber(root.right) + 1;
    }

    public static int getHeight(Node root) {
        if (root == null)
            return 0;
        else
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}

