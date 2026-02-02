import java.util.ArrayList;

public class Manager {
    private int maxSize;
    private ArrayList<Software> programStack;

    // Main constructor
    public Manager(int maxSize) {
        this.maxSize = maxSize;
    }

    // Check for index
    private boolean indexCheck(int index) {
        if (index < 0 || index > programStack.size()) {
            return false;
        } else {
            return true;
        }
    }

    // Main methods

    public Software getSoftware(int getPosition) {
        if (indexCheck(getPosition)) {
            return programStack.get(getPosition);
        }
    }

    public void insertSoftware(Software softwareInsert, int setPosition) {
        if (indexCheck(setPosition)) {
            programStack.add(setPosition, softwareInsert);
        }
    }

    public void killSoftware(int removePosition) {
        if (indexCheck(removePosition)) {
            programStack.remove(removePosition);
        }
    }

    public int getSoftwareN() {
        return programStack.size();
    }

    public int searchProgram(String toFind) {
        for (int i = 0; i < programStack.size(); i++) {
            if (programStack.get(i).getTitle().equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    

}
