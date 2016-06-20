package com.alekseysamoylov.insurers.services;

import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/20/16.
 * for JSON.
 * used in HomeController
 */
@Component
@Scope("prototype")
public class TableInformationList {

    List<TableInformation> tableInformationList = new ArrayList<>();

    public TableInformationList() {
    }



    public void setConcreteIndexes(List<ConcreteIndex> concreteIndexes) {
        tableInformationList = new ArrayList<>();
        for (ConcreteIndex index : concreteIndexes) {
            tableInformationList.add(new TableInformation(index.getReportingPeriod().getStopPeriod(), index.getValue()));
        }

    }

    public List<TableInformation> getTableInformationList() {
        return tableInformationList;
    }

    public void setTableInformationList(List<TableInformation> tableInformationList) {
        this.tableInformationList = tableInformationList;
    }
}
