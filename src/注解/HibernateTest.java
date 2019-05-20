package 注解;

import java.io.File;

public class HibernateTest {
    public static void main(String[] args) {
        HibernateTest ht = new HibernateTest();
        ht.ScanEentity("src/注解");
    }

    /**
     *
     * @param path 扫描的路径
     * @d  扫描指定路径下的
     */

    public void ScanEentity(String path) {
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fi:files){
                ScanEentity(fi.getPath());
            }
        }else {

        }
    }
}
