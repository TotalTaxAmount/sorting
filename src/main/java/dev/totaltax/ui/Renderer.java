package dev.totaltax.ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class Renderer extends BorderPane {

    private static Renderer INSTANCE;

    public List<SortingRenderer<?>> components = new ArrayList<>();

    /**
     * The main window renderer
     */
    private Renderer() {
        super();
//        b
    }

    /**
     * Get the current instance of the renderer
     * @return The current instance of the renderer
     */
    public static Renderer getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Renderer();

        return INSTANCE;
    }

    /**
     * Initialize the window
     */
    public void init(Stage stage) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResour
//        components.forEach(c -> {
//            c.init();
////            this.(c);
//        });
//        this.sho(stage);
        Renderer renderer = Renderer.getInstance();
        Scene scene = new Scene(renderer, 500, 500);
        stage.setTitle("Sorting");
        stage.setScene(scene);
    }

    /**
     * Add a sorter renderer
     * @param renderer A {@link SortingRenderer}
     */
    public void addSortRenderer(SortingRenderer<?> renderer) {
        components.add(renderer);
    }
}
