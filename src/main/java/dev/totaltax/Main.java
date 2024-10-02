package dev.totaltax;

import dev.totaltax.sorters.BubbleSort;
import dev.totaltax.sorters.TestSorter;
import dev.totaltax.ui.Renderer;
import dev.totaltax.ui.SortingRenderer;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.util.Arrays;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Renderer renderer = Renderer.getInstance();


        BubbleSort<Double> bubbleSort = new BubbleSort<>("Bubble sorter");
        SortingRenderer<Double> bubbleRenderer = new SortingRenderer<>(bubbleSort);

//        TestSorter testSorter = new TestSorter("Test sorter");
//        SortingRenderer<Integer> testSortRenderer = new SortingRenderer<>(testSorter);

        BubbleSort<Integer> intSort = new BubbleSort<>("Int sorter");
        SortingRenderer<Integer> intRenderer = new SortingRenderer<>(intSort);

        bubbleSort.setRenderer(bubbleRenderer);
        intSort.setRenderer(intRenderer);
//        testSorter.setRenderer(testSortRenderer);

        renderer.addSortRenderer(bubbleRenderer);
        renderer.addSortRenderer(intRenderer);
//        renderer.addSortRenderer(testSortRenderer);

        //        BubbleSort<Integer> intBubbleSort = new BubbleSort<>("Bubble sorter", renderer);
        Integer[] list = {5, 4, 3, 2, 1};
        Double[] listDouble = {23.4, 5.5, 2.89, 124.1, 20.4};

        bubbleRenderer.setData(listDouble);
        intRenderer.setData(list);

        renderer.init(stage);
    }
}