package dev.totaltax.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Renderer extends JFrame {

    private static Renderer INSTANCE;

    public List<SortingRenderer<?>> components = new ArrayList<>();

    public List<Double> input;

    /**
     * The main window renderer
     */
    private Renderer() {
        super();
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

    public List<Double> getInput() {
        return this.input;
    }
    /**
     * Initialize the window
     */
    public void init() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResour
        JTextField inputSorting = new JTextField(0);
        inputSorting.addActionListener(e -> {
            try {
                this.input = Arrays.stream(e.getActionCommand().trim().replaceAll(" +", " ").split(" "))
                        .flatMap(ie -> Stream.of(Double.parseDouble(ie))).toList();
            } catch (NumberFormatException nfe) {
                System.out.println("[ERROR] Error parsing input: " + nfe.getMessage());
            }
            System.out.println("[INFO] Sorting list updated: " + input);
        });

        this.setTitle("Sorting");
        this.setLayout(new GridLayout(0, 2));

        this.add(inputSorting);
        components.forEach(c -> {
            c.init();
            this.add(c);
        });

        this.setVisible(true);
//        Renderer renderer = Renderer.getInstance();
////        Scene scene = new Scene(renderer, 500, 500);
//        stage.setTitle("Sorting");
//        stage.setScene(scene);
    }

    /**
     * Add a sorter renderer
     * @param renderer A {@link SortingRenderer}
     */
    public void addSortRenderer(SortingRenderer<?> renderer) {
        components.add(renderer);
    }
}
