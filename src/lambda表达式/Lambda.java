package lambda表达式;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Lambda {

    @Test
    public void test(){
        ArrayList<Student> a = new ArrayList();
        addList(a,1);
        addList(a,2);
        filter(a);
        System.out.println(a.toString());
    }

    public void filter(ArrayList<Student> a){
        for(Student s:a){
            if(s.Student_num<1000){
                a.remove(s);
            }
        }
    }

    public void addList(ArrayList<Student> s, Integer gender){
        if (gender==1){
            for(int i=0;i<10;i++){
                s.add(new Student("a"+i,1000+i,gender));
            };
        }else{
            for(int i=0;i<10;i++){
                s.add(new Student("A"+i,1000+i,gender));
            };
        }

    }
}
