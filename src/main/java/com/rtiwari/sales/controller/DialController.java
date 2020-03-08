package com.rtiwari.sales.controller;

import com.rtiwari.sales.annotation.SpringScopeView;
import com.rtiwari.sales.model.Dial;
import com.rtiwari.sales.service.dials.DialService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rtiwari
 */
@Component
@ManagedBean
@SpringScopeView
@ViewScoped
public class DialController implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(DialController.class);
    private static final long serialVersionUID = 1L;
    private List<Dial> dials;
    private Dial dial;
    private List<String> weeks;
    private Integer latestval;
    private Integer latestaip;
    private Integer latestagg;
    private LineChartModel dialChart;

    @Autowired
    private DialService dialService;

    @PostConstruct
    public void init() {
        dials = dialService.getAllDial();
        weeks = dialService.getWeeks();
        latestval = dialService.getRecentValue();
        latestaip = dialService.getRecentAIP();
        latestagg = dialService.getRecentAGG();
        createLineModels();
    }

    public List<Dial> getDials() {
        return dials;
    }

    public Dial getDial() {
        return dial;
    }

    public void setDial(Dial dial) {
        this.dial = dial;
    }

    public Integer getLatestval() {
        return latestval;
    }

    public Integer getLatestaip() {
        return latestaip;
    }

    public Integer getLatestagg() {
        return latestagg;
    }

    public LineChartModel getDialChart() {
        return dialChart;
    }

    public void setDialChart(LineChartModel dialChart) {
        this.dialChart = dialChart;
    }

    public void removeDial(Long id) {
        LOGGER.debug("delete" + id);
        dialService.delete(id);
        this.dials = dialService.getAllDial();
    }

    public void changeDial(Dial dial) {
        LOGGER.debug("first " + dial.getId());
        dialService.findBydate(dial.getId());
        this.dial = dial;
    }

    public void addNewDial() {
        this.dial = new Dial();
        this.dials = dialService.getAllDial();
    }

    public void saveedit() {
        LOGGER.debug("value " + dial);
        dialService.saveedit(dial);
        this.dials = dialService.getAllDial();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Configuration saved"));
    }

//    public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Contact Selected", Dial);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    private void createLineModels() {
        dialChart = new LineChartModel();
        ChartSeries totaldials = new ChartSeries();
        ChartSeries accountinprogress = new ChartSeries();
        totaldials.setLabel("Total Dials");
        accountinprogress.setLabel("Account In Progress");
        Axis xAxis = new CategoryAxis("Weeks");
        Axis yAxis = dialChart.getAxis(AxisType.Y);
        for (String w : weeks) {
            List<String> dialstats = Arrays.asList(w.split(","));
            int v = Integer.parseInt(dialstats.get(1));
            int a = Integer.parseInt(dialstats.get(2));
            totaldials.set(dialstats.get(0), v);
            accountinprogress.set(dialstats.get(0), a);
        }
        dialChart.addSeries(totaldials);
        dialChart.addSeries(accountinprogress);
        dialChart.setLegendPosition("ne");
        dialChart.setAnimate(true);
        dialChart.getAxes().put(AxisType.X, xAxis);
        dialChart.getAxis(AxisType.Y);
        xAxis.setTickAngle(-50);
        yAxis.setLabel("Results");
        yAxis.setMin(0);
        yAxis.setMax(100);
        dialChart.setExtender("skinDialChart");
        LOGGER.info(" -------------- Created Graph ------------- ");
    }
}
