/*
 * A factory interface for a factory that generates GUI forms for a user to
 * fill in an entry to a database table
 */
package readinglistGUI;

import javax.swing.JPanel;

/**
 *
 * @author Alexander Yahna
 */
public interface InsertEntryGUIFactoryInterface {
    /**
     * Generates a JPanel with a prompt JText (i.e. "Author's Name :")
     * and an appropriate input field, based on the arguments, next to it
     * @param args an array of arguments
     * @return a JPanel
     */
    public JPanel getPromptInputPanel(String[] args);
}
