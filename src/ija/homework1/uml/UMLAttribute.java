package ija.homework1.uml;

/**
 * Třída reprezentuje atribut, který má své jméno a typ. Je odvozena (rozšiřuje) od třídy Element.
 * Typ atributu je reprezentován třidou UMLClassifier. Lze použít jako atribut UML třídy nebo argument operace.
 */
public class UMLAttribute extends Element {
    UMLClassifier type;

    /**
     * Vytvoří instanci atributu.
     * @param name Název atributu.
     * @param type Typ atributu.
     */
    public UMLAttribute(String name, UMLClassifier type) {
        super(name);
        this.type = type;
    }

    /**
     * Poskytuje informaci o typu atributu.
     * @return Typ atributu.
     */
    public UMLClassifier getType() {
        return this.type;
    }

    /**
     * Vrací řetězec reprezentující stav atributu v podobě "nazev:typ".
     * @return Řetězec reprezentující atribut.
     */
    @Override
    public java.lang.String toString() {
        return String.format("%s:%s", this.getName(), this.type.toString());
    }
}
