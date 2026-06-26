package datastructure;

import model.Medicine;

import java.util.Stack;

public class UndoStack {

    private static UndoStack instance;

    private Stack<Medicine> deletedMedicines;

    private UndoStack() {

        deletedMedicines = new Stack<>();
    }

    public static UndoStack getInstance() {

        if(instance == null) {

            instance = new UndoStack();
        }

        return instance;
    }

    public void push(Medicine medicine) {

        deletedMedicines.push(medicine);
    }

    public Medicine pop() {

        if(deletedMedicines.isEmpty()) {

            return null;
        }

        return deletedMedicines.pop();
    }

    public boolean isEmpty() {

        return deletedMedicines.isEmpty();
    }
}