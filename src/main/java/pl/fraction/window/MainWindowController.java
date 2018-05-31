package pl.fraction.window;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import pl.fraction.containers.fraction.Fraction;
import pl.fraction.containers.fraction.Fractionable;
import pl.fraction.operators.addition.FractionAddition;
import pl.fraction.operators.division.FractionDivision;
import pl.fraction.operators.multiplication.FractionMultiplication;
import pl.fraction.operators.subtraction.FractionSubtraction;
import pl.fraction.utils.ReflectionHelper;
import pl.fraction.window.view.TreeLeafInteraction;

public class MainWindowController {

    private static final Logger log = Logger.getLogger(MainWindowController.class);

    @FXML private GridPane rootPane;
    @FXML private GridPane controlPane;
    @FXML private TreeView<String> inputTree;
    @FXML private TreeView<String> outputTree;
    @FXML private Button countBtn;
    @FXML private ComboBox<String> operationType;
    @FXML private ProgressIndicator progression;

    @FXML public void setUiControlsDefaultSettings() {
        setApplicationLayout();
        provideUiControlsSettings();
        populateTrees();
        log.info(ReflectionHelper.getCurrentMethodName() + "()");
    }

    @FXML private void setApplicationLayout() {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setFillWidth(true);
        rootPane.getColumnConstraints().add(columnConstraints);
        controlPane.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);
        rootPane.getRowConstraints().add(rowConstraints);
        controlPane.getColumnConstraints().add(columnConstraints);

        log.info(ReflectionHelper.getCurrentMethodName() + "()");
    }

    @FXML private void provideUiControlsSettings() {
        countBtn.setText("Count");
        progression.setProgress(0.0);

        ObservableList<String> options = FXCollections.observableArrayList("Addition", "Subtraction", "Multiplication", "Division");
        operationType.getItems().addAll(options);
        operationType.promptTextProperty().setValue("Operation...");
        operationType.getSelectionModel().select(0);

        log.info(ReflectionHelper.getCurrentMethodName() + "()");
    }

    @FXML private void populateTrees() {
        TreeItem<String> root = new TreeItem<>("Operands");
        root.setExpanded(true);

        List<TreeItem<String>> branches = new ArrayList<>();
        branches.add(new TreeItem<>("Left operand"));
        branches.add(new TreeItem<>("Right operand"));

        for (TreeItem<String> treeItem : branches) {
            treeItem.setExpanded(true);
            treeItem.getChildren().add(new TreeItem<>("0"));
            treeItem.getChildren().add(new TreeItem<>("1"));
            root.getChildren().add(treeItem);
        }

        inputTree.setRoot(root);
        inputTree.setEditable(true);
        inputTree.setCellFactory(param -> new TreeLeafInteraction());

        TreeItem<String> result = new TreeItem<>("Result");
        result.setExpanded(true);
        result.getChildren().add(new TreeItem<>("numerator"));
        result.getChildren().add(new TreeItem<>("denominator"));
        outputTree.setRoot(result);
        outputTree.setCellFactory(param -> new TreeLeafInteraction());

        log.info(ReflectionHelper.getCurrentMethodName() + "()");
    }

    @FXML private void onCountButtonClick() {
        Fractionable leftOperand = new Fraction(
            inputTree.getTreeItem(0).getChildren().get(0).getChildren().get(0).getValue(),
            inputTree.getTreeItem(0).getChildren().get(0).getChildren().get(1).getValue()
        );

        Fractionable rightOperand = new Fraction(
            inputTree.getTreeItem(0).getChildren().get(1).getChildren().get(0).getValue(),
            inputTree.getTreeItem(0).getChildren().get(1).getChildren().get(1).getValue()
        );

        Task<Fractionable> task = new Task<>() {
            @Override protected Fractionable call() {
                switch (operationType.getSelectionModel().getSelectedIndex()) {
                    default:
                    case 0:
                        log.info(ReflectionHelper.getCurrentMethodName() + "(+)");
                        return new FractionAddition().addIntegers(leftOperand, rightOperand);
                    case 1:
                        log.info(ReflectionHelper.getCurrentMethodName() + "(-)");
                        return new FractionSubtraction().subtractIntegers(leftOperand, rightOperand);
                    case 2:
                        log.info(ReflectionHelper.getCurrentMethodName() + "(*)");
                        return new FractionMultiplication().multiplyIntegers(leftOperand, rightOperand);
                    case 3:
                        log.info(ReflectionHelper.getCurrentMethodName() + "(/)");
                        return new FractionDivision().divideIntegers(leftOperand, rightOperand);
                }
            }
        };

        onCountButtonTask(task);
        progression.setProgress(-1);
        operationType.setDisable(true);
        countBtn.setDisable(true);

        try {
            new Thread(task).start();
        } catch (IllegalThreadStateException exp) {
            log.error(exp);
            progression.setProgress(0);
            operationType.setDisable(false);
            countBtn.setDisable(false);
        }

        log.info(ReflectionHelper.getCurrentMethodName() + '(' + leftOperand + ',' + rightOperand + ')');
    }

    @FXML private void onCountButtonTask(@NotNull final Task<Fractionable> task) {
        task.stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == State.SUCCEEDED) {
                try {
                    outputTree.getTreeItem(0).getChildren().get(0).setValue(task.get().getNumerator());
                    outputTree.getTreeItem(0).getChildren().get(1).setValue(task.get().getDenominator());
                    progression.setProgress(100);
                    operationType.setDisable(false);
                    countBtn.setDisable(false);
                    log.info(ReflectionHelper.getCurrentMethodName() + '(' + task.get().toString() + ')');
                } catch (InterruptedException | ExecutionException exp) {
                    log.error(exp);
                }
            }
        });
    }
}
