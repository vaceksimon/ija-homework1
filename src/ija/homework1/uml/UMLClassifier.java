package ija.homework1.uml;

public class UMLClassifier extends Element{
    private String name;
    private boolean isUserDefined;

    public UMLClassifier(String name) {
        super(name);
    }

    public UMLClassifier(String name, boolean isUserDefined) {
        super(name);
        this.isUserDefined = isUserDefined;
    }

    public static UMLClassifier forName(String name) {
        return new UMLClassifier(name);
    }

    public boolean isUserDefined() {
        return this.isUserDefined;
    }

    public String toString() {
        return String.format("%s(%s)", this.getName(), isUserDefined ? "true" : "false");
    }
}
