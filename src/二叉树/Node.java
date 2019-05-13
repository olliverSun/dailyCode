package 二叉树;

public class Node<E>{
    Node left;
    Node right;
    Node mid;

    int  num;

    Node(){

    }
    Node(int num){
        setNum(num);
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }




    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getMid() {
        return mid;
    }

    public void setMid(Node mid) {
        this.mid = mid;
    }
}
