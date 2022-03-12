package ija.homework1.uml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Třída reprezentuje operaci, která má své jméno, návratový typ a seznam argumentů.
 * Je odvozena (rozšiřuje) od třídy UMLAttribute, od které přejímá název a návratový typ.
 * Argument je reprezentován třídou UMLAttribute.
 * Lze použít jako součást UML klasifikátoru třída nebo rozhraní.
 */
public class UMLOperation extends UMLAttribute {
    private List<UMLAttribute> attributes;

    /**
     * Konstruktor pro vytvoření operace s daným názvem a návratovým typem.
     * @param name Název operace.
     * @param type Návratový typ operace.
     */
    public UMLOperation(java.lang.String name, UMLClassifier type) {
        super(name, type);
        attributes = new ArrayList<>();
    }

    /**
     * Tovární metoda pro vytvoření instance operace.
     * @param name Název operace.
     * @param type Návratový typ operace.
     * @param args Seznam argumentů operace.
     * @return Objekt reprezentující operaci v diagramu UML.
     */
    public static UMLOperation create(String name, UMLClassifier type, UMLAttribute... args) {
        UMLOperation newOperation = new UMLOperation(name, type);
        newOperation.attributes.addAll(Arrays.asList(args));
        return newOperation;
    }

    /**
     * Přidá nový argument do seznamu argumentů. Argument se vloží na konec seznamu.
     * Pokud v seznamu již existuje argument stejného názvu, operaci neprovede.
     * @param arg Vkládaný argument.
     * @return Úspěch operace - true, pokud se podařilo vložit, jinak false.
     */
    public boolean addArgument(UMLAttribute arg) {
        if(this.attributes.contains(arg))
            return false;
        return this.attributes.add(arg);
    }

    /**
     * Vrací nemodifikovatelný seznam argumentů. Lze využít pro zobrazení.
     * @return Nemodifikovatelný seznam argumentů.
     */
    public java.util.List<UMLAttribute> getArguments() {
        return Collections.unmodifiableList(this.attributes);
    }
}
