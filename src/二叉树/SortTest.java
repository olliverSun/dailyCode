package 二叉树;

import java.util.ArrayList;

public class SortTest
{
        SortTest left,right;//左右结点
        Integer value;//当前
        private static int step;//循环次数
        private static long startTime;//开始排序时间
          
                  
                public SortTest(ArrayList<Integer> unsorted)
        {
                step=0;
                startTime=System.currentTimeMillis();
                for(Integer current:unsorted)
                {
                        intoTree(current);
                }
        }
  
                private SortTest(int current)
        {
                intoTree(current);
        }
          
        //   填入二叉树依赖方法
                private void intoTree(int current)
        {
                step++;
                  
                if(this.value==null)
                        this.value=current;
                else if(current>this.value)
                {
                        if(this.right==null)
                                this.right=new SortTest(current);
                        else
                                this.right.intoTree(current);
                }
                else
                {
                        if(this.left==null)
                                this.left=new SortTest(current);
                        else
                                this.left.intoTree(current);
                }
        }
          
        //   选择法
                public static ArrayList<Integer> select(ArrayList<Integer> unsorted)
        {
                step=0;
                startTime=System.currentTimeMillis();
                  
                for(int i=1;i<unsorted.size();i++)
                {
                        if(unsorted.get(i)<unsorted.get(i-1))
                        {
                                for(int j=i;j>0&&unsorted.get(j)<unsorted.get(j-1);j--)
                                {
                                        step++;
                                          
                                        int temp=unsorted.get(j);
                                        unsorted.set(j,unsorted.get(j-1));
                                        unsorted.set(j-1,temp);
                                }
                        }
                }
                System.out.println("--选择法排序已完成--");
                System.out.println("循环次数："+step);
                System.out.println("排序用时："+(System.currentTimeMillis()-startTime)/1000f+"s");
                return unsorted;
        }
          
        //   二叉树排序法
                public ArrayList<Integer> bintree()
        {
                ArrayList<Integer> ordered=take();
                System.out.println("--二叉树排序已完成--");
                System.out.println("循环次数："+step);
                System.out.println("排序用时："+(System.currentTimeMillis()-startTime)/1000f+"s");
                return ordered;
        }
          
        //   从遍历实例二叉树进行排序
                private ArrayList<Integer> take()
        {
                step++;
                  
                ArrayList<Integer> tempOrdered=new ArrayList<>();
  
                if(this.left!=null)
                        tempOrdered.addAll(this.left.take());
                if(this.value!=null)
                        tempOrdered.add(this.value);
                if(this.right!=null)
                        tempOrdered.addAll(this.right.take());
                return tempOrdered;
        }
  
                public static void main(String[] args)
        {
                ArrayList<Integer> unsorted=new ArrayList<Integer>();
//           4w随机数
                for(int i=0;i<40000;i++)
                {
                        unsorted.add((int)(Math.random()*10000));
                }
//           System.out.println("未排序数组："+unsorted);
                  
                  
//           如果先跑选择法就会报错（栈溢出StackOverflowError）
//           二叉树排序
                SortTest ordered=new SortTest(unsorted);
                ordered.bintree();
                //选择法
                SortTest.select(unsorted);
        }
}