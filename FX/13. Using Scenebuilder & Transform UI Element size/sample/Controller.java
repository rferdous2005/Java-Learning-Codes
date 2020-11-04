package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {

    @FXML
    TextField itemName;

    @FXML
    Label allItems;

    @FXML
    Button btn1;

    @FXML
    Button btn2;


    public void initialize() {
        //btn1.setDisable(true);
    }

    public void onAddButtonClicked(ActionEvent event) {
        if(event.getSource().equals(btn1)) {
            allItems.setText("Add clicked");
        } else if(event.getSource().equals(btn2)) {

            Runnable backGround = new Runnable() {
                @Override
                public void run() {
                    String t1 = Platform.isFxApplicationThread() ? "UI Thread": "Background Thread";
                    System.out.println("Sleep is called on "+ t1);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    Platform.runLater( new Runnable() {
                                @Override
                                public void run() {
                                    String t1 = Platform.isFxApplicationThread() ? "UI Thread": "Background Thread";
                                    System.out.println("Label is updated on "+ t1);
                                    allItems.setTextFill(Color.RED);
                                    allItems.setText("Delete clicked");
                                }
                            }
                    );

                }
            };

            new Thread(backGround).start();
        }
    }

    public void keyRealeased() {
        if(itemName.getText().isEmpty()) {
            btn1.setDisable(true);
        } else {
            btn1.setDisable(false);
        }
    }

    public void onTransformEntered(MouseEvent mouseEvent) {
        btn1.setScaleX(2);
        btn2.setScaleY(2);
    }

    public void onTransformExit(MouseEvent mouseEvent) {
        btn1.setScaleX(1);
        btn2.setScaleY(1);
    }
}
