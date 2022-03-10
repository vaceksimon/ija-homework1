package ija.homework1.uml;

import java.util.Collections;
import java.util.List;

public class UMLClass extends  UMLClassifier{
    private String name;
    private boolean isAbstract;
    private List<UMLAttribute> attributes;

    public UMLClass(String name) {
        super(name);
    }

    public boolean isAbstract() {
        return this.isAbstract;
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public boolean addAttribute(UMLAttribute attr) {
        if(this.attributes.contains(attr))
            return false;
        return this.attributes.add(attr);
    }

    public int getAttrPosition(UMLAttribute attr) {
        return this.attributes.indexOf(attr);
    }

    public int moveAttrAtPosition(UMLAttribute attr, int pos) {
        if(!this.attributes.remove(attr))
            return -1;
        this.attributes.add(pos, attr);
        return pos;
    }

    public java.util.List<UMLAttribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
    }
}
