package pl.fraction.window.view;

import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.input.KeyCode;
import org.jetbrains.annotations.NotNull;

public final class TreeLeafInteraction extends TreeCell<String> {

    private TextField textField;

    @Override public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override public void cancelEdit() {
        super.cancelEdit();
        setText(String.valueOf(getItem()));
        setGraphic(getTreeItem().getGraphic());
    }

    @Override public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
            return;
        }

        if (isEditing()) {
            if (textField != null) {
                textField.setText(getString());
            }

            setText(null);
            setGraphic(textField);
        } else {
            setText(getString());
            setGraphic(getTreeItem().getGraphic());
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                commitEdit(textField.getText());
            } else if (event.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });
    }

    @NotNull private String getString() {
        return getItem() == null ? "" : getItem();
    }

}
