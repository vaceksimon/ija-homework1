package ija.homework1.uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Třída (její instance) reprezentuje model třídy z jazyka UML.
 * Rozšiřuje třídu UMLClassifier. Obsahuje seznam atributů a operací (metod).
 * Třída může být abstraktní.
 */
public class UMLClass extends  UMLClassifier {
    private boolean isAbstract;
    private List<UMLAttribute> attributes;

    /**
     * Vytvoří instanci reprezentující model třídy z jazyka UML.
     * Třída není abstraktní.
     * @param name Název třídy (klasifikátoru).
     */
    public UMLClass(String name) {
        super(name, true);
        attributes = new ArrayList<>();
    }

    /**
     * Test, zda objekt reprezentuje model abstraktní třídy.
     * @return Pokud je třída abstraktní, vrací true. Jinak vrací false.
     */
    public boolean isAbstract() {
        return this.isAbstract;
    }

    /**
     * Změní informaci objektu, zda reprezentuje abstraktní třídu.
     * @param isAbstract Zda se jedná o abstraktní třídu nebo ne.
     */
    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     * Vloží atribut do modelu UML třídy.
     * Atribut se vloží na konec seznamu (poslední položka).
     * Pokud již třída obsahuje atribut stejného jména, nedělá nic.
     * @param attr Vkládaný atribut.
     * @return Úspěch akce (pokud se podařilo vložit, vrací true, jinak false).
     */
    public boolean addAttribute(UMLAttribute attr) {
        if(this.attributes.contains(attr))
            return false;
        return this.attributes.add(attr);
    }

    /**
     * Vrací pozici atributu v seznamu atributů. Pozice se indexuje od hodnoty 0.
     * Pokud třída daný atribut neobsahuje, vrací -1.
     * @param attr Hledaný atribut.
     * @return Pozice atributu.
     */
    public int getAttrPosition(UMLAttribute attr) {
        return this.attributes.indexOf(attr);
    }

    /**
     * Přesune pozici atributu na nově zadanou. Pozice se indexuje od hodnoty 0.
     * Pokud třída daný atribut neobsahuje, nic neprovádí a vrací -1.
     * Při přesunu na pozici pos se všechny stávající položky (atributy) od pozice pos (včetně) posunou o jednu pozici doprava.
     * @param attr Přesunovaný atribut.
     * @param pos Nová pozice.
     * @return Úspech operace.
     */
    public int moveAttrAtPosition(UMLAttribute attr, int pos) {
        if(!this.attributes.remove(attr))
            return -1;
        this.attributes.add(pos, attr);
        return pos;
    }

    /**
     * Vrací nemodifikovatelný seznam atributů. Lze využít pro zobrazení atributů třídy.
     * @return Nemodifikovatelný seznam atributů.
     */
    public java.util.List<UMLAttribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
    }
}
