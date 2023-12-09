import java.util.ArrayList;
import java.util.List;

// Originator class
class Martinez {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Nested Memento class
    public static class Memento {
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    // Create Memento
    public Memento createMemento() {
        return new Memento(state);
    }

    // Restore state from Memento
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// Caretaker class with history
class Caretaker {
    private List<Martinez.Memento> mementoHistory = new ArrayList<>();

    public void addMemento(Martinez.Memento memento) {
        mementoHistory.add(memento);
    }

    public Martinez.Memento getMemento(int index) {
        return mementoHistory.get(index);
    }

    public void undo() {
        if (!mementoHistory.isEmpty()) {
            // Get the last Memento from history
            Martinez.Memento lastMemento = mementoHistory.remove(mementoHistory.size() - 1);
        }
    }
}

// Example usage
class Example {
    public static void main(String[] args) {
        Martinez martinez = new Martinez();
        Caretaker caretaker = new Caretaker();

        // Set initial state
        martinez.setState("Original State");
        System.out.println("Current State: " + martinez.getState());

        // Save state to Memento and add to history
        caretaker.addMemento(martinez.createMemento());

        // Change state
        martinez.setState("New State");
        System.out.println("Current State: " + martinez.getState());

        // Save state to Memento and add to history
        caretaker.addMemento(martinez.createMemento());

        // Change state again
        martinez.setState("Another State");
        System.out.println("Current State: " + martinez.getState());

        // Undo the last operation
        caretaker.undo();
        System.out.println("Undone State: " + martinez.getState());
    }
}