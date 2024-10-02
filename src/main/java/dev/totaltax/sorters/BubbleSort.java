package dev.totaltax.sorters;

public class BubbleSort<T extends Number> extends Sorter<T> {

    /**
     * The classic bubble sort
     * @param name Name of the sorter
     */
    public BubbleSort(String name) {
        super(name, Sorters.BUBBLE);
    }

    @Override
    public T[] sort(T[] list) {
        T[] listClone = list.clone();
        this.renderer.updateStates(listClone);
        int i, j, l = listClone.length;
        T temp;
        boolean swapped;
        for (i = 0; i < l - 1; i++) {
            swapped = false;
            for (j = 0; j < l - i - 1; j++) {
                if (listClone[j].doubleValue() > listClone[j + 1].doubleValue()) {

                    // The next number in the list is less than the previous one,
                    // This means we need to switch them around
                    temp = listClone[j];
                    listClone[j] = listClone[j + 1];
                    listClone[j + 1] = temp;
                    swapped = true;
                    this.renderer.updateStates(listClone);
                }
            }

            if (!swapped)
                break; // If nothing was swapped then we can break out
        }
        return list;
    }
}
