/*
 */
package readinglistGUI;

/**
 *
 * @author VJY
 */
public class ComboBoxItem {
    public int value;
    public String label;

    public ComboBoxItem(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
