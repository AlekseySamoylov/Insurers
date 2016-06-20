package com.alekseysamoylov.insurers.data.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/12/16.
 * Name of Index
 */
@XmlRootElement(name = "index")
@Entity
@Table(name = "INDEX_TYPE")
@Access(value = AccessType.FIELD)
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "index_id_sequence")
    @SequenceGenerator(name = "index_id_sequence", sequenceName = "INDEX_TYPE_SEQ")
    @Column(name = "INDEX_ID")
    private Long indexId;

    @Column(name = "INDEX_NAME")
    private String indexName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "index", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcreteIndex> concreteIndexes = new ArrayList<ConcreteIndex>();


    public Long getIndexId() {
        return indexId;
    }

    public void setIndexId(Long indexId) {
        this.indexId = indexId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Override
    public String toString() {
        return "Index{" +
                "indexId=" + indexId +
                ", indexName='" + indexName + '\'' +
                '}';
    }
}
