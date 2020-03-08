package com.rtiwari.sales.controller;

import com.rtiwari.sales.annotation.SpringScopeView;
import com.rtiwari.sales.model.Email;
import com.rtiwari.sales.service.email.EmailService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rtiwari
 */
@Component
@ManagedBean
@SpringScopeView
@ViewScoped
public class EmailController implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
    private static final long serialVersionUID = 1L;
    private LineChartModel emailChart;
    private List<Email> emails;
    private List<String> weeks;
    private Email email;

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void init() {
        emails = emailService.getAllEmail();
        weeks = emailService.getWeeks();
        createLineModels();
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public LineChartModel getEmailChart() {
        return emailChart;
    }

    public void setEmailChart(LineChartModel emailChart) {
        this.emailChart = emailChart;
    }

    public void removeEmail(Long id) {
        LOGGER.debug("delete" + id);
        emailService.delete(id);
        this.emails = emailService.getAllEmail();
    }

    public void changeEmail(Email email) {
        LOGGER.debug("first " + email.getId());
        emailService.findBydate(email.getId());
        this.email = email;
    }

    public void addNewEmail() {
        this.email = new Email();
        this.emails = emailService.getAllEmail();
    }

    public void saveedit() {
        LOGGER.debug("value " + email);
        emailService.saveedit(email);
        this.emails = emailService.getAllEmail();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Configuration saved"));
    }

//    public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Contact Selected", ((Email) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }

    private void createLineModels() {
        emailChart = new LineChartModel();
        ChartSeries clicked = new ChartSeries();
        ChartSeries opened = new ChartSeries();
        ChartSeries sent = new ChartSeries();
        clicked.setLabel("Clicked");
        opened.setLabel("Opened");
        sent.setLabel("Sent");
        Axis xAxis = new CategoryAxis("Weeks");
        Axis yAxis = emailChart.getAxis(AxisType.Y);
        for (String w : weeks) {
            List<String> emailstats = Arrays.asList(w.split(","));
            int c = Integer.parseInt(emailstats.get(1));
            int o = Integer.parseInt(emailstats.get(2));
            int s = Integer.parseInt(emailstats.get(3));
            clicked.set(emailstats.get(0), c);
            opened.set(emailstats.get(0), o);
            sent.set(emailstats.get(0), s);
        }
        LOGGER.info(" -------------- Creating Graph ------------- ");
        LOGGER.info(" ---- Clicked : " + clicked);
        LOGGER.info(" ---- Opened : " + opened);
        LOGGER.info(" ---- Sent : " + sent);
        emailChart.addSeries(clicked);
        emailChart.addSeries(opened);
        emailChart.addSeries(sent);
        LOGGER.info(" -------------- Graph Completed ------------- ");
        emailChart.setLegendPosition("ne");
        emailChart.setAnimate(true);
        emailChart.getAxes().put(AxisType.X, xAxis);
        emailChart.getAxis(AxisType.Y);
        xAxis.setTickAngle(-50);
        yAxis.setLabel("Results");
        yAxis.setMin(0);
        yAxis.setMax(2000);
        emailChart.setExtender("skinEmailChart");
    }
}
