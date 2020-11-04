package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
        CategoryAxis xAxis = new CategoryAxis();

        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
                "Speed", "Mileage", "Safety", "User Rating")));
        xAxis.setLabel("category");

        //Defining the y axis
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("score");

        //Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Comparison between Motorcycles on different aspects");

        //Prepare XYChart.Series objects by setting data
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Yamaha R15-150");
        series1.getData().add(new XYChart.Data<>("Speed", 8.0));
        series1.getData().add(new XYChart.Data<>("User Rating", 6.5));
        series1.getData().add(new XYChart.Data<>("Mileage", 6.5));
        series1.getData().add(new XYChart.Data<>("Safety", 7.0));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Bajaj Pulsar NS-160");
        series2.getData().add(new XYChart.Data<>("Speed", 7.5));
        series2.getData().add(new XYChart.Data<>("User Rating", 9.5));
        series2.getData().add(new XYChart.Data<>("Mileage", 10.0));
        series2.getData().add(new XYChart.Data<>("Safety", 8.5));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Suzuki Gixxer-155");
        series3.getData().add(new XYChart.Data<>("Speed", 7.0));
        series3.getData().add(new XYChart.Data<>("User Rating", 7.0));
        series3.getData().add(new XYChart.Data<>("Mileage", 10.5));
        series3.getData().add(new XYChart.Data<>("Safety", 8.0));

        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Honda CBR-150");
        series4.getData().add(new XYChart.Data<>("Speed", 9.0));
        series4.getData().add(new XYChart.Data<>("User Rating", 9.5));
        series4.getData().add(new XYChart.Data<>("Mileage", 10.5));
        series4.getData().add(new XYChart.Data<>("Safety", 8.0));

        //Setting the data to bar chart
        barChart.getData().addAll(series1, series2, series3, series4);
        Group root = new Group(barChart);
        Scene scene = new Scene(root ,900, 600);
        primaryStage.setTitle("Bar Chart Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
