package eu.artofcoding.abrechnung.model.jaxb;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "interval", propOrder = {"interval", "intervalDescription"})
public class Interval {

    private int interval;

    private String intervalDescription;

    public Interval() {
    }

    public Interval(int interval, String intervalDescription) {
        this.interval = interval;
        this.intervalDescription = intervalDescription;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getIntervalDescription() {
        return intervalDescription;
    }

    public void setIntervalDescription(String intervalDescription) {
        this.intervalDescription = intervalDescription;
    }

}
