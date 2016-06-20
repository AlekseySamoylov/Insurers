package com.alekseysamoylov.insurers.data.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by alekseysamoylov on 6/12/16.
 * About concrete indexes of insurers.
 */
@XmlRootElement(name = "concreteIndex")
@Entity
@Table(name = "CONCRETE_INDEX")
@Access(value = AccessType.FIELD)
public class ConcreteIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concrete_id_sequence")
    @SequenceGenerator(name = "concrete_id_sequence", sequenceName = "CONCRETE_INDEX_SEQ")
    @Column(name = "CONCRETE_ID")
    private Long concreteId;

    @ManyToOne
    @JoinColumn(name = "INSURER_ID")
    private Insurer insurer;

    @ManyToOne
    @JoinColumn(name = "INDEX_ID")
    private Index index;

    @Column(name = "VALUE")
    private double value;

    @ManyToOne()
    @JoinColumn(name = "PERIOD_ID")
    private ReportingPeriod reportingPeriod;

    public Long getConcreteId() {
        return concreteId;
    }

    public void setConcreteId(Long concreteId) {
        this.concreteId = concreteId;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ReportingPeriod getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(ReportingPeriod reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }



    @Override
    public String toString() {
        return "ConcreteIndex{" +
                "concreteId=" + concreteId +
                ", insurer=" + insurer +
                ", index=" + index +
                ", value=" + value +
                ", startTime=" + reportingPeriod.getStartPeriod() +
                '}';
    }
}
