package com.alekseysamoylov.insurers.controllers;

import com.alekseysamoylov.insurers.data.entities.ConcreteIndex;
import com.alekseysamoylov.insurers.data.entities.Index;
import com.alekseysamoylov.insurers.services.*;
import com.alekseysamoylov.insurers.data.entities.Insurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alekseysamoylov on 6/19/16.
 * Control all page and JSON responses.
 */
@Controller
public class HomeController {


    @Autowired
    private TablesForHome tablesForHome;

    @Autowired
    private TableForInsurer tableForInsurer;

    @Autowired
    private TableForGraph tableForGraph;

    @Autowired
    private TableInformationList tableInformationList;

    /**
     * Home page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goHome(Model model) {
        List<Insurer> insurers = tablesForHome.getInsurers();
        model.addAttribute("insurers", insurers);
        model.addAttribute("searchFields", new SearchFields());

        return "home";
    }

    /**
     * Search controller from home page
     * @param searchFields object includes two parameters(name & INN) from the form in head of page.
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String goSearch(Model model, @ModelAttribute SearchFields searchFields) {
        System.out.println(searchFields.getName() + " | " + searchFields.getInn());
        List<Insurer> insurers = tablesForHome.getInsurers(searchFields);
        model.addAttribute("insurers", insurers);
        model.addAttribute("searchFields", searchFields);
        return "home";
    }

    /**
     * Show Selecting quarter page.
     * @param insurerId included Insurer's Id.
     */
    @RequestMapping(value = "/insurer/{insurerId}")
    public String goToQuarter(Model model, @PathVariable Long insurerId) {
        Insurer insurer = new Insurer();
        insurer.setInsurerId(insurerId);
        InsurerPlusYearPlusIndex insurerPlusYearPlusIndex = new InsurerPlusYearPlusIndex();
        insurerPlusYearPlusIndex.setInsurer(insurer);
        model.addAttribute("quarterParams", insurerPlusYearPlusIndex);
        List<Integer> qOptions = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<String> yOptions = new ArrayList<>(Arrays.asList("2005", "2006"));
        model.addAttribute("qOptions", qOptions);
        model.addAttribute("yOptions", yOptions);
        return "quarter";
    }

    /**
     * Show indexes in one quarter.
     * @param insurerPlusYearPlusIndex Included Insurer, Year, quarter.
     */
    @RequestMapping(value = "/insurer/list", method = RequestMethod.POST)
    public String showInsurerInQuarter(Model model, @ModelAttribute InsurerPlusYearPlusIndex insurerPlusYearPlusIndex) {
        System.out.println(insurerPlusYearPlusIndex);
        System.out.println(insurerPlusYearPlusIndex.getInsurer().getInsurerId());
        model.addAttribute("concretes", tableForInsurer.getTableQuarter(insurerPlusYearPlusIndex));
        return "insurer";
    }

    /**
     * Show page with graph.
     * List of changes over time in indexes.
     * @param graphId insurerId plus indexId
     */
    @RequestMapping(value = "/graph/{graphId}")
    public String showGraph(Model model, @PathVariable String graphId) {
        model.addAttribute("concretes", getListFromPath(graphId));
        model.addAttribute("graphId", graphId);
        return "graph";
    }

    /**
     * get JSON for all!
     * @param graphId insurerId plus indexId
     */
    @CrossOrigin
    @RequestMapping("/graph/get/{graphId}")
    @ResponseBody
    public TableInformationList findResource(@PathVariable("graphId") String graphId) {
        tableInformationList.setConcreteIndexes(getListFromPath(graphId));
        return tableInformationList;
    }

    /**
     * Show Exception page
     */
    @ExceptionHandler(Exception.class)
    public String handlerError(HttpServletRequest request) {
        return "error";
    }

    /**
     * parse String from GET request
     * @param graphId insurerId plus indexId
     * @return Object with list Date + Value to JSON
     */
    private List<ConcreteIndex> getListFromPath(String graphId) {
        String delims = "[+]";
        String[] tokens = graphId.split(delims);
        Insurer insurer = new Insurer();
        insurer.setInsurerId(Long.parseLong(tokens[0]));
        Index index = new Index();
        index.setIndexId(Long.parseLong(tokens[1]));
        InsurerPlusYearPlusIndex insurerPlusYearPlusIndex = new InsurerPlusYearPlusIndex();
        insurerPlusYearPlusIndex.setInsurer(insurer);
        insurerPlusYearPlusIndex.setIndex(index);
        return tableForGraph.getTableGraph(insurerPlusYearPlusIndex);
    }
}
