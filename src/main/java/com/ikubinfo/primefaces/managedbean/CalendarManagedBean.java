package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

@ManagedBean(name="calendarView")
@ViewScoped
public class CalendarManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

    private Date date5;
   
    private Date dateDe;
   
    private Date dateTimeDe;
    private List<Date> multi;
    private List<Date> range;
    private List<Date> invalidDates;
    private List<Integer> invalidDays;
    private Date minDate;
    private Date maxDate;
    private Date minTime;
    private Date maxTime;
    private Date minDateTime;
    private Date maxDateTime;
 
 
    @PostConstruct
    public void init() {
        invalidDates = new ArrayList<>();
        Date today = new Date();
        invalidDates.add(today);
        long oneDay = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 5; i++) {
            invalidDates.add(new Date(invalidDates.get(i).getTime() + oneDay));
        }
 
        invalidDays = new ArrayList<>();
        invalidDays.add(0); /* the first day of week is disabled */
        invalidDays.add(3);
 
       minDate = new Date(today.getTime() - (365 * oneDay));
       maxDate = new Date(today.getTime() + (365 * oneDay));
 
        Calendar tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 9);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        minTime = tmp.getTime();
 
        tmp = Calendar.getInstance();
        tmp.set(Calendar.HOUR_OF_DAY, 17);
        tmp.set(Calendar.MINUTE, 0);
        tmp.set(Calendar.SECOND, 0);
        tmp.set(Calendar.MILLISECOND, 0);
        maxTime =  tmp.getTime();
 
        minDateTime = new Date(today.getTime() - (7 * oneDay));
        maxDateTime = new Date(today.getTime() + (7 * oneDay));
 
        dateDe = GregorianCalendar.getInstance().getTime();
        dateTimeDe = GregorianCalendar.getInstance().getTime();
    }
 
    public void onDateSelect(SelectEvent<Date> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
 
    public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }
 
   
 
   
 
  

    public Date getDate5() {
        return date5;
    }
 
    public void setDate5(Date date5) {
        this.date5 = date5;
    }
 

 
    public List<Date> getMulti() {
        return multi;
    }
 
    public void setMulti(List<Date> multi) {
        this.multi = multi;
    }
 
    public List<Date> getRange() {
        return range;
    }
 
    public void setRange(List<Date> range) {
        this.range = range;
    }
 
    public List<Date> getInvalidDates() {
        return invalidDates;
    }
 
    public void setInvalidDates(List<Date> invalidDates) {
        this.invalidDates = invalidDates;
    }
 
    public List<Integer> getInvalidDays() {
        return invalidDays;
    }
 
    public void setInvalidDays(List<Integer> invalidDays) {
        this.invalidDays = invalidDays;
    }
 
    public Date getMinDate() {
        return minDate;
    }
 
    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }
 
    public Date getMaxDate() {
        return maxDate;
    }
 
    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }
 
    public Date getDateTimeDe() {
        return dateTimeDe;
    }
 
    public void setDateTimeDe(Date dateTimeDe) {
        this.dateTimeDe = dateTimeDe;
    }
 
    public Date getDateDe() {
        return dateDe;
    }
 
    public void setDateDe(Date dateDe) {
        this.dateDe = dateDe;
    }
 
   
 
    public Date getMinTime() {
        return minTime;
    }
 
    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }
 
    public Date getMaxTime() {
        return maxTime;
    }
 
    public void setMaxTime(Date maxTime) {
        this.maxTime = maxTime;
    }
 
  
 
    public Date getMinDateTime() {
        return minDateTime;
    }
 
    public void setMinDateTime(Date minDateTime) {
        this.minDateTime = minDateTime;
    }
 
    public Date getMaxDateTime() {
        return maxDateTime;
    }
 
    public void setMaxDateTime(Date maxDateTime) {
        this.maxDateTime = maxDateTime;
    }
}
