package max.models;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;

public class ComPort {

    private String comPortName = "COM11";                   // ComPort для быстрого подключения
    private int baudRate = 9600;                          // BaudRate для быстрого подключения

    private static int count = 0;

    private static DataHandler dataHandler = new DataHandler();
    private static String newString = "";

    public String statusComPort;
    private static SerialPort serialPort;

    /****************** метод подключения к ComPort ******************/
    public void connect() {
        try {

            serialPort = new SerialPort(comPortName);
            serialPort.openPort();
            statusComPort = "Is Open";
            System.out.println(comPortName + " Open");

            serialPort.setParams(baudRate, 8, 1, 0);
            serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
            serialPort.addEventListener(ComPort::comPortReader);
        } catch (SerialPortException ex) {
            System.out.println(ex);
            statusComPort = "Is Busy";
        }
    }

    /****************** метод чтения данных из ComPort ****************/
    private static void comPortReader(SerialPortEvent event) {
        if (event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                String inputString = serialPort.readString(event.getEventValue());  //Приняли строку и записали в переменную
                newString = newString.concat(inputString);

                if (newString.endsWith("\n")) {

                    dataHandler.parseInputString(newString);
                    //System.out.println(newString);
                    newString = "";
                }

            } catch (SerialPortException ex) {
                System.out.println(ex);

            }
        }
    }

    /****************** метод записи в ComPort ********************/
    //
    public void comPortWriter(String code) {
        try {
            serialPort.writeString(code + "\n");
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
