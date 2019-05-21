package 注解;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class HibernateTest {


    private HashMap<String, HashMap<String,String>> hb = new HashMap();

    public static void main(String[] args) throws Exception {
        HibernateTest ht = new HibernateTest();
        ht.ScanEentity("src/注解");
    }

    /**
     *
     * @param path 扫描的路径
     * @d  扫描指定路径下的
     */

    public void ScanEentity(String path) throws Exception {
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fi:files){
                ScanEentity(fi.getPath());
            }
        }else {
            String name = file.getName().replace('\\','.');
            name = name.substring(0,name.length()-5);
            Class clazz = Class.forName("注解.Hero");
            putEnetityToContainer(clazz);
        }

        Set<String> strings = hb.keySet();
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            HashMap<String, String> stringStringHashMap = hb.get(next);
            Set<String> strings1 = stringStringHashMap.keySet();
            Iterator<String> iterator1 = strings1.iterator();
            while(iterator1.hasNext()){
                String next1 = iterator1.next();
                System.out.println(stringStringHashMap.get(next1));
            }
        }
    }


    private  void putEnetityToContainer(Class clazz) throws Exception {
        HashMap map = new HashMap();
        String key = null;
        String value = null;
        Annotation[] annotations = clazz.getAnnotations();
//        迭代类对象上所有的注解名称，并一一解析
        for (Annotation annotation : annotations) {
            String simpleName = annotation.annotationType().getSimpleName();
            if (simpleName == Entity.class.getSimpleName())
                key = simpleName;
            if (simpleName == ToTable.class.getSimpleName())
                value = simpleName;
        }
        try {
            map.put(key, value);
        } catch (Exception e) {
            throw new Exception("实体映射@Entity不能为空");
        }
        if (value == null)
            map.remove(key);
        else {
            HashMap<String,String>hashMap = mappingCloumn(clazz);
            hashMap.put(key,value);
            hb.put(key,hashMap);
        }



    }

    private HashMap mappingCloumn(Class clazz) throws Exception {
        HashMap fieldcloumn = new HashMap();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            ToColumn annotation = field.getAnnotation(ToColumn.class);
            if (annotation!=null){
                fieldcloumn.put(field.getName(),annotation.ColumName());
            }else{
                throw  new Exception("列映射不完整");
            }
        }
        return fieldcloumn;
    }}




