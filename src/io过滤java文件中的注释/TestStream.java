package io过滤java文件中的注释;

import org.junit.Test;

import java.io.*;

public class TestStream {

//    相对路径起始处没有斜杠  复制
    @Test
    public void testInStream() throws IOException {
        byte[] fullBts = read(1024, "笔记/1.txt");
        write(fullBts,"笔记/2.txt");
        String path ="src/SortTest.java";
        String destination ="src/sortTestAndNoComment.java";
        filterStream(path,destination);
    }


    public byte[] read(Integer StackCapacity, String adrss) throws IOException {
        byte[] bts = new byte[StackCapacity];
        FileInputStream is = new FileInputStream(new File(adrss));
        is.read(bts);
        is.close();
        return bts;
    }

    public void  write(byte[] WriteDatas,String destination) throws IOException {
        FileOutputStream destinationStream = new FileOutputStream(new File(destination));
        destinationStream.write(WriteDatas);
        destinationStream.close();
    }

//    过滤该路径java文件的注释
    public void  filterStream(String readPath, String outputDestination) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(readPath)));
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File(outputDestination)));
        String line;
        while ((line =br.readLine())!=null){
            int flag = line.indexOf("//");
            if(flag>0){
                String newline =line.substring(0,flag);
                wr.write(newline);
                wr.newLine();
            }else if(flag==-1){
                wr.write(line);
                wr.newLine();
            }
            line=null;
            wr.flush();
        }
        br.close();
        wr.close();

    }
}
