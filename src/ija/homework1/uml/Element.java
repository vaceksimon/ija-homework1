package ija.homework1.uml;

/**
 * Třída reprezentuje pojmenovaný element (thing), který může být součástí jakékoliv části v diagramu.
 */
public class Element {
    private String name;

    /**
     * Vytvoří instanci se zadaným názvem.
     * @param name Název elementu.
     */
    public Element(String name) {
        this.name = name;
    }

    /**
     * Vrátí název elementu.
     * @return Název elementu.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Přejmenuje element.
     * @param name Nový název elementu.
     */
    public void rename(String name) {
        this.name = name;
    }
}
