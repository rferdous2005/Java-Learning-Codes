package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void init() {
        System.out.println("init() called");
    }

    @Override
    public void stop() {
        System.out.println("stop() called");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Preparing ObservbleList object
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Dhaka", 230),
                new PieChart.Data("Chattogram", 180),
                new PieChart.Data("Rajshahi", 105),
                new PieChart.Data("Khulna", 130),
                new PieChart.Data("Noakhali", 90));

        //Creating a Pie chart
        PieChart pieChart = new PieChart(pieChartData);

        //Setting the title of the Pie chart
        pieChart.setTitle("Area wise sales");

        //setting the direction to arrange the data
        pieChart.setClockwise(true);    // change it to false and test

        //Setting the length of the label line
        pieChart.setLabelLineLength(50); // change the value & test

        //Setting the labels of the pie chart visible
        pieChart.setLabelsVisible(true);

        //Setting the start angle of the pie chart
        pieChart.setStartAngle(180); // change the angle value & test

        //Creating a Group object
        Group root = new Group(pieChart);
        Scene scene = new Scene(root ,900, 600);
        primaryStage.setTitle("Bar Chart Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
