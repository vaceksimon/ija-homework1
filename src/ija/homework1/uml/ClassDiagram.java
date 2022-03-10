package ija.homework1.uml;

import java.util.List;

/**
 * Třída reprezentuje diagram tříd.
 * Je odvozen od třídy Element (má název).
 * Obsahuje seznam tříd (instance třídy UMLClass) příp. klasifikátorů pro uživatelsky nedefinované typy (instance třídy UMLClassifier).
 */
public class ClassDiagram extends Element {
    private String name;
    private List<UMLClass> classes;
    private List<UMLClassifier> classifiers;

    /**
     * Konstruktor pro vytvoření instance diagramu. Každý diagram má svůj název.
     * @param name Název diagramu.
     */
    public ClassDiagram(String name) {
        super(name);
    }

    /**
     * Vytvoří instanci UML třídy a vloží ji do diagramu.
     * Pokud v diagramu již existuje třída stejného názvu, nedělá nic.
     * @param name Název vytvářené třídy.
     * @return Objekt (instance) reprezentující třídu. Pokud třída s daným názvem již existuje, vrací null.
     */
    public UMLClass createClass(String name) {
        UMLClass newClass = new UMLClass(name);
        if(this.classes.contains(newClass))
            return null;
        this.classes.add(newClass);
        return newClass;
    }

    /**
     * Vyhledá v diagramu klasifikátor podle názvu.
     * Pokud neexistuje, vytvoří instanci třídy Classifier reprezentující klasifikátor, který není v diagramu zachycen
     * (viz UMLClassifier.forName(java.lang.String)); využito např. pro modelování typu proměnné, který v diagramu není.
     * Tato instance je zařazena do struktur diagramu, tzn. že při dalším pokusu o vyhledání se použije tato již vytvořená instance.
     * @param name Název klasifikátoru.
     * @return Nalezený, příp. vytvořený, klasifikátor.
     */
    public UMLClassifier classifierForName(String name) {
        UMLClassifier newClassifier = UMLClassifier.forName(name);
        if(this.classifiers.contains(newClassifier))
            return newClassifier;

        this.classifiers.add(newClassifier);
        return newClassifier;
    }

    /**
     * Vyhledá v diagramu klasifikátor podle názvu.
     * @param name Název klasifikátoru.
     * @return Nalezený klasifikátor. Pokud v diagramu neexistuje klasifikátor daného jména, vrací null.
     */
    public UMLClassifier findClassifier(String name) {
        UMLClassifier target = new UMLClassifier(name);
        return this.classifiers.contains(target) ? target : null;
    }
}
