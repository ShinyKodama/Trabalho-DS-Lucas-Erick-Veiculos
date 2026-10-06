package veiculoslucaserick.Views;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class PromptComboBoxRenderer extends BasicComboBoxRenderer {
    private final String prompt;

    public PromptComboBoxRenderer(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (index == -1 && value == null) {
            setText(prompt);
        }
        
        return this;
    }
}