package max.models;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataHandler {


    String param1;
    String param2;
//    String param3;
//    String param4;
//    String param5;
//    String param6;
//    String param7;

List<System> list = new ArrayList<>();

    private Boolean writeFileAllowed = true;    // флаг разрешения записи в файл

    private int countIrCommand;
    private String pathCodeFile = "H:\\Max\\Workspace\\Java\\Max IR Repeater\\src\\max\\res\\code.txt";
    private File codeFile = new File(pathCodeFile);

    /*****************************************************************/
    String codeString = "0x77E1D088\t32\t37\n";   // Пример формата строки IR code
    String commandString = "";   // Пример формата строки для команд
    int countParameter = 0;
    // здесь надо разобрать строку на параметры и возможно команды
    void parseInputString(String inputString) {

        String[] dataParamsArray;
        String[] numberLinesArray;
        String data;
        System.out.println(inputString);
        System.out.println("********************");

        if (inputString.startsWith("0x")) {                     // если это IR code

            dataParamsArray = inputString.replaceAll("0x", "").split("\t");



            for (int i = 0; i < dataParamsArray.length; i++) {
                String param = "param" + i;
                countParameter++;
                param = dataParamsArray[i];
                System.out.print(dataParamsArray[i]+ "#");
              //  System.out.println("***************");
                System.out.println(param);
            }


            System.out.println("Колличество принятых параметров = "
                    .concat(String.valueOf(countParameter)));

            countIrCommand++;

            if (writeFileAllowed) {                             // если запись в файл разрешена
                writeFile(inputString);
            }
        }

        if (inputString.startsWith("Cx")) {                      // если это команда

        }
    }

    private void addArray(String string) {        // скорей всего в ObservableList

    }

    private void createFile() {
        try {
            boolean created = codeFile.createNewFile();
            if (created)
                System.out.println("File has been created");
            // Создаем header
            // writeFile("*********************************************************************");
        } catch (IOException ex) {
            System.out.println("Error :" + ex);
        }
    }

    private void writeFile(String string) {

        if (codeFile.exists()) {
//            System.out.println("File exists");

            try (FileWriter writer = new FileWriter(pathCodeFile, true)) {     //H:\Max\Workspace\Java\Max IR Repeater\src\max\res\code.txt
                writer.write(countIrCommand + "\t" + string.replaceAll("0x", ""));
                writer.flush();
            } catch (IOException ex) {
                System.out.println("Error :" + ex);
            }

            System.out.println(countIrCommand);
        } else {
            System.out.println("File not found");
            createFile();
        }

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

    void testString() {
        String habr = "/habrahabr";
        // получить длину строки
        int length = habr.length();
        // теперь можно узнать есть ли символ символ 'h' в "habrahabr"
        char searchChar = '/';
        boolean isFound = false;
        for (int i = 0; i < length; ++i) {
            if (habr.charAt(i) == searchChar) {
                isFound = true;
                break; // первое вхождение
            }
        }
        System.out.println(message(isFound)); // Your char had been found!
        // ой, забыл, есть же метод indexOf
        //  System.out.println(message(habr.indexOf(searchChar) != -1)); // Your char had been found!
    }

    private static String message(boolean b) {
        return "Your char had" + (b ? " " : "n't ") + "been found!";
    }

}

