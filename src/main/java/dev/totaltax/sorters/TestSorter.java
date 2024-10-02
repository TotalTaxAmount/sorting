package dev.totaltax.sorters;

public class TestSorter extends Sorter<Integer> {
    /**
     * Test sorter class
     *
     * @param name The name of the sorter
     */
    public TestSorter(String name) {
        super(name, Sorters.BUBBLE);
    }

    @Override
    public Integer[] sort(Integer[] list) {
        int temp;
        for (int l = 1; l < list.length; l++) {
            if (list[l - 1] > list[l]) {
                temp = list[l];
                list[l] = list[l - 1];
                list[l - 1] = temp;
//                System.out.println(Arrays.toString(list));
                this.renderer.updateStates(list);
            }
        }
        return list;
    }
}
