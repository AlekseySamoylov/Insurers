package com.alekseysamoylov.insurers.data.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by alekseysamoylov on 6/12/16.
 * Class about Insurer...
 */
@XmlRootElement(name = "insurer")
@Entity
@Table(name="INSURER")
@Access(value = AccessType.FIELD)
public class Insurer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insurer_id_sequence")
    @SequenceGenerator(name = "insurer_id_sequence", sequenceName = "INSURER_SEQ")
    @Column(name = "INSURER_ID")
    private Long insurerId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "insurer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcreteIndex> concreteIndexes = new ArrayList<ConcreteIndex>();

    @Column(name = "NAME")
    private String name;

    @Column(name = "LICENSE")
    private String license;

    @Column(name = "INN")
    private long inn;

    @Column(name = "OGRN")
    private long ogrn;

    @Column(name = "NUMBER_OF_BRANCHES")
    private int numberOfBranches;


    public Long getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(Long insurerId) {
        this.insurerId = insurerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }

    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }

    public List<ConcreteIndex> getConcreteIndexes() {
        return concreteIndexes;
    }

    public void setConcreteIndexes(List<ConcreteIndex> concreteIndexes) {
        this.concreteIndexes = concreteIndexes;
    }

    @Override
    public String toString() {
        return "Insurer{" +
                "insurerId=" + insurerId +
                ", name='" + name + '\'' +
                ", license='" + license + '\'' +
                ", inn=" + inn +
                ", ogrn=" + ogrn +
                ", numberOfBranches=" + numberOfBranches +
                '}';
    }
}
