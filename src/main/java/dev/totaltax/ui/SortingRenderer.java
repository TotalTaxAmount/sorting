package dev.totaltax.ui;


import dev.totaltax.sorters.Sorter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SortingRenderer<T extends Number> extends JPanel {
    private final Sorter<T> sorter;

    private final JPanel jStates = new JPanel();

    private T[] data;

    private Set<T[]> states = new LinkedHashSet<>();;

    /**
     * A renderer for a {@link Sorter}
     * @param sorter A {@link Sorter}
     */
    public SortingRenderer(Sorter<T> sorter) {
        this.sorter = sorter;
    }

    /**
     * Get the sorter
     * @return
     */
    public Sorter<?> getSorter() {
        return this.sorter;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public void init()  {
        System.out.println("[INFO] Initializing renderer for " + this.sorter.getName());
        this.add(new JLabel(this.sorter.getName()));
        this.jStates.setLayout(new GridLayout(this.states.size(), 2));
        JButton sortButton = new JButton("Sort");
        JButton clearButton = new JButton("Clear");
        sortButton.addActionListener(e -> {
            this.jStates.removeAll();
            this.states = new LinkedHashSet<>(this.data.length);
            this.sorter.sort(this.data);
        });

        clearButton.addActionListener(e -> {
            this.jStates.removeAll();
            this.jStates.revalidate();
            this.revalidate();
        });

        this.add(sortButton);
        this.add(clearButton);
        this.add(jStates);
        this.setVisible(true);
        System.out.println("[INFO] Finished initializing renderer for " + this.sorter.getName());
    }

    public void updateStates(T[] currState) {
        states.add(currState);
        for (T[] state : this.states) {
            DefaultListModel<T> dlm = new DefaultListModel<>();
            JList<T> jList = new JList<>(dlm);
            jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            jList.setVisibleRowCount(1);
            jList.setBorder(new EmptyBorder(5,0, 5, 5));
            jList.setFont(new Font("Monospaced", Font.BOLD, 30));
            JScrollPane scrollPane = new JScrollPane(jList);
            int state_index = 0;
            for (T entry : state) {
                dlm.add(state_index++, entry);
            }
            this.jStates.add(scrollPane);
        }
        this.jStates.revalidate();
        this.revalidate();
    }


}
