package ija.homework1.uml;

import java.util.List;
import java.util.ListIterator;

public class ClassDiagram extends Element {
    private String name;
    private List<UMLClass> classes;
    private List<UMLClassifier> classifiers;

    public ClassDiagram(String name) {
        super(name);
    }

    public UMLClass createClass(String name) {
        UMLClass newClass = new UMLClass(name);
        if(this.classes.contains(newClass))
            return null;
        this.classes.add(newClass);
        return newClass;
    }

    public UMLClassifier classifierForName(String name) {
        UMLClassifier newClassifier = UMLClassifier.forName(name);
        if(this.classifiers.contains(newClassifier))
            return newClassifier;

        this.classifiers.add(newClassifier);
        return newClassifier;
    }

    public UMLClassifier findClassifier(String name) {
        UMLClassifier target = new UMLClassifier(name);
        return this.classifiers.contains(target) ? target : null;
    }
}
