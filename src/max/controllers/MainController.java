package max.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import max.models.ComPort;
import max.models.Data;

public class MainController {


    public Label comPortLabel;
    public Button btnOnLed;
    public Button btnOffLed;
    public Label labelIrCode;

    public void openPort(ActionEvent actionEvent) {
        ComPort comPort = new ComPort();
        comPort.connect();
        comPortLabel.setText(comPort.statusComPort);
    }

    public void onLed(ActionEvent event) {
        ComPort comPort = new ComPort();
        comPort.comPortWriter("1313");
    }

    public void offLed(ActionEvent event) {
        ComPort comPort = new ComPort();
        comPort.comPortWriter("0000");
    }

    public void readFileAction(ActionEvent event) {
        Data data = new Data();
        data.readFile();
    }

    public void writeAction(ActionEvent event) {

    }

    public void dataListAction(ActionEvent event) {
        Data data = new Data();
        data.printDataList();
    }
}
