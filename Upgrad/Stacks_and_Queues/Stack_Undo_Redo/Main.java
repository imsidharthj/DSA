import java.util.*;

class TextEditor {
    private StringBuilder text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        this.text = new StringBuilder();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void insertText(String newText) {
        undoStack.push(text.toString());
        text.append(newText);
        redoStack.clear();
    }

    public void deleteText(int length) {
        if (length > text.length()) {
            length = text.length();
        }
        undoStack.push(text.toString());
        text.delete(text.length() - length, text.length());
        redoStack.clear();
    }
    
    public StringBuilder getText() {
        return text;
    }

    public void undo() {
        if(!undoStack.isEmpty()){
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void redo() {
        if(!redoStack.isEmpty()){
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TextEditor editor = new TextEditor();

        String str = scanner.nextLine();
        editor.insertText(str);

        int deleteCount = scanner.nextInt();

        System.out.println("Text: " + editor.getText());

        editor.deleteText(deleteCount);
        System.out.println("Text after deletion: " + editor.getText());

        editor.undo();
        System.out.println("Text after undo: " + editor.getText());

        editor.redo();
        System.out.println("Text after redo: " + editor.getText());
    }
}