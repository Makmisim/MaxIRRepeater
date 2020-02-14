package max.models;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    private Boolean writeFileAllowed = true;
    private Integer countPressButtonIr = 0;
    private Integer idCode = 33;
    List<String> dataList = new ArrayList<>();

    /****************************************************************/


    /****************************************************************/

    void addData(String dataInput) {

      //  unPackage(dataInput);

        if (writeFileAllowed) {
            writeFile(dataInput);
            addDataList(dataInput);;
        }
    }

    private void addDataList(String data) {


            dataList.add(data);


        System.out.println("addDataList");
        System.out.println(dataList);
    }

    public void printDataList(){
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList);
            System.out.println("---------");
        }
    }

    private void unPackage(String data) {

        if (data.startsWith("\n")) {
            System.out.println("Command");
        } else {
            System.out.println("???");
        }

    }

    private void writeFile(String data) {
        try (FileWriter writer = new FileWriter("code.txt", true)) {

            writer.write(data);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Error :" + ex);
        }
        System.out.println(data);
    }

    public void readFile() {
        try (FileReader reader = new FileReader("code.txt")) {
//            char[] buf = new char[256];
//            int c;
//            while((c = reader.read(buf))>0){
//
//                if(c < 256){
//                    buf = Arrays.copyOf(buf, c);
//                }
//                System.out.print(buf);
//            }


//            System.out.println(reader.read(CharBuffer.allocate(5)));
//            int c;
//            while ((c = reader.read()) != -1) {                                   // читаем посимвольно
//                System.out.println((char) c);
//            }
        } catch (IOException ex) {
            System.out.println("Error :" + ex);
        }

    }

}

//                if (inputString.endsWith("\n")) {
//                    System.out.println(inputString);
//                }
//                writer.append('\n');              // Запись по символьно ???
//                writer.append('E');