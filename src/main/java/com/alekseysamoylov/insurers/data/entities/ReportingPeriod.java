package com.alekseysamoylov.insurers.data.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/13/16.
 * This class about period of concrete index.
 */
@XmlRootElement(name = "reportingPeriod")
@Entity
@Table(name = "REPORTING_PERIOD")
@Access(value = AccessType.FIELD)
public class ReportingPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_period_id")
    @SequenceGenerator(name = "generator_period_id", sequenceName = "REPORTING_PERIOD_SEQ")
    @Column(name = "PERIOD_ID")
    private Long periodId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reportingPeriod", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcreteIndex> concreteIndexes = new ArrayList<>();

    @Column(name = "START_PERIOD")
    @Temporal(TemporalType.DATE)
    private Date startPeriod;

    @Column(name = "STOP_PERIOD")
    @Temporal(TemporalType.DATE)
    private Date stopPeriod;


    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public List<ConcreteIndex> getConcreteIndexes() {
        return concreteIndexes;
    }

    public void setConcreteIndexes(List<ConcreteIndex> concreteIndexes) {
        this.concreteIndexes = concreteIndexes;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getStopPeriod() {
        return stopPeriod;
    }

    public void setStopPeriod(Date stopPeriod) {
        this.stopPeriod = stopPeriod;
    }

    @Override
    public String toString() {
        return "ReportingPeriod{" +
                "periodId=" + periodId +
                ", startPeriod=" + startPeriod +
                ", stopPeriod=" + stopPeriod +
                '}';
    }
}
