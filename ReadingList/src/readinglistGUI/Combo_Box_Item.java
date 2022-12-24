/*
 */
package readinglistGUI;

/**
 *
 * @author VJY
 */
public class Combo_Box_Item {
    public int value;
    public String label;

    public Combo_Box_Item(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
