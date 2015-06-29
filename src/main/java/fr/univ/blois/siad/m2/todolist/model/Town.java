package fr.univ.blois.siad.m2.todolist.model;

import javax.xml.bind.annotation.*;
import java.util.Objects;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/*
Cette classe doit presenter une serialisation XML avec la ville en element et le code postale en attribut
 */
@XmlRootElement
@XmlAccessorType(FIELD)
public class Town {

    @XmlElement
    private String name;

    @XmlAttribute
    private String zipCode;

    public Town() {
    }

    public Town(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town)) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name) &&
                Objects.equals(zipCode, town.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zipCode);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Town{");
        stringBuilder.append("name='").append(name).append('\'');
        stringBuilder.append(", zipCode='").append(zipCode).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
