package dev.totaltax.sorters;

import dev.totaltax.ui.SortingRenderer;

public abstract class Sorter<T extends Number> {
    private final String name;

    private final Sorters type;

    SortingRenderer<T> renderer;

    /**
     * Base sorter class
     * @param name The name of the sorter
     * @param type The type of sorter
     */
    public Sorter(String name, Sorters type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Sort a list of T type using one of {@link Sorters} methods
     * @param list A list of T
     * @return The sorted list of T
     */
    public abstract T[] sort(T[] list);

    public void setRenderer(SortingRenderer<T> handle) {
        this.renderer = handle;
    }

    public String getName() {
        return this.name;
    }

    public Sorters getType() {
        return this.type;
    }

    public enum Sorters {
        MERGE,
        BUBBLE
    }
}

