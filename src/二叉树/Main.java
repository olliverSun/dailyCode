package 二叉树;

import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



    }



void TestCollection(){
        //测试一下数组
    ArrayList TetsArrayList = new ArrayList();
//    查看数组扩容机制
    /**
     *首先，创建ArrayList时会給一个初始化一个默认容量
     * public ArrayList() {
     *         this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     *     }
     * 然后在add方法中
     * 判断当前插入个数是否等于数组长度。
     * 若等于
     *则扩容
     * 扩容逻辑是利用
     * arrays.copyof(elementData，newCapacity(minCapacity))；--传入当前数组所需要最小参数(当前容量+1) 为A
     *newCapacity(minCapacity)逻辑为:取之前的容量并扩容至1.5倍 B=B+(B>>2)
     * 如果新容量大于最小需要容量。则取新容量。若新容量小于最小需要容量，则取最小需要容量(当旧容量指定为1的时候，
     *就会出现这个情况)。
     * 最后判断扩容之后的新容量是否大于最大容量，若大于最大容量就不用B=B+(B>>2)来扩容；用B=B++来扩容
     *
     */
    }
    @Test
    public void testDate(){
        Date a = new Date();
        System.out.println(a);
        System.out.println(System.currentTimeMillis());
    }
    @Test
    public void LinkList2(){
         LinkedList es = new LinkedList();
        System.out.println(System.currentTimeMillis());
    }


//    二叉树
    @Test
    public void binaryTree(){
        ArrayList<Integer> arrayList = new ArrayList();
        initList(arrayList);

        Node TreeNode = new Node();

        for(Integer i :arrayList){
            addTreeNode(i,TreeNode);
        }

        pollTree(TreeNode);
    }


//    迭代二叉树
//    二叉树：以树节点为对象，树节点包含以下信息
//    1、左右两边的树节点
//    2、数据

    public void pollTree(Node MostLeftNode){

        if(MostLeftNode.getLeft()!=null){
//            找到最左边的树节点
            MostLeftNode=MostLeftNode.getLeft();
            pollTree(MostLeftNode);
        }else{
            nodePrintln(MostLeftNode);
        }
    }




    //        从最左边的树一直遍历到最右边
    public void nodePrintln(Node MostLeftNode){
        if(MostLeftNode.getRight()!=null){
            System.out.println(MostLeftNode.getNum());
            nodePrintln(MostLeftNode.getRight());
            return;
        }

        System.out.println(MostLeftNode.getNum());
        System.out.println("迭代终止");



    }



    //    生成一个四万数字的集合
    public void initList(List arrary){
        for (int i = 0; i <300 ; i++) {
            arrary.add(i);
        }
    }

    public void addTreeNode(Integer num, Node TreeNode){
        if (num > TreeNode.getNum() && TreeNode.getRight() == null) {
            TreeNode.setRight(new Node(num));
        } else if (num < TreeNode.getNum() && TreeNode.getLeft() == null) {
            TreeNode.setLeft(new Node(num));
        }else if(num > TreeNode.getNum() && TreeNode.getRight()!=null){
                    addTreeNode(num,TreeNode.getRight());
        }else if(num < TreeNode.getNum() && TreeNode.getLeft() != null){
                    addTreeNode(num,TreeNode.getLeft());
        }

    }
}
