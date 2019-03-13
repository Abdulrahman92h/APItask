package com.abd.receive;
import com.fasterxml.jackson.annotation.*;

public class APImodel {

    private String id;
    private String price;
    private String totalDuration;
    private long stops;
    private String[] airlineLogo;
    private String[] departingAirportName;
    private String[] arrivalAirportName;
    private String logoCover;
    private String[] depCityName;
    private String[] arrCityName;
    private String[] depDateAndTime;
    private String[] arrDateAndTime;
    private String[] airlineName;
    private String[] flightNumber;
    private String[] layOverTime;
    private String[] layOverMinutes;
    private String[] layOverCity;
    private String[] arrAirportName;
    private String[] flightModel;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getPrice() { return price; }
    public void setPrice(String value) { this.price = value; }

    public String getTotalDuration() { return totalDuration; }
    public void setTotalDuration(String value) { this.totalDuration = value; }

    public long getStops() { return stops; }
    public void setStops(long value) { this.stops = value; }

    public String[] getAirlineLogo() { return airlineLogo; }
    public void setAirlineLogo(String[] value) { this.airlineLogo = value; }

    public String[] getDepartingAirportName() { return departingAirportName; }
    public void setDepartingAirportName(String[] value) { this.departingAirportName = value; }

    public String[] getArrivalAirportName() { return arrivalAirportName; }
    public void setArrivalAirportName(String[] value) { this.arrivalAirportName = value; }

    public String getLogoCover() { return logoCover; }
    public void setLogoCover(String value) { this.logoCover = value; }

    public String[] getDepCityName() { return depCityName; }
    public void setDepCityName(String[] value) { this.depCityName = value; }

    public String[] getArrCityName() { return arrCityName; }
    public void setArrCityName(String[] value) { this.arrCityName = value; }

    public String[] getDepDateAndTime() { return depDateAndTime; }
    public void setDepDateAndTime(String[] value) { this.depDateAndTime = value; }

    public String[] getArrDateAndTime() { return arrDateAndTime; }
    public void setArrDateAndTime(String[] value) { this.arrDateAndTime = value; }

    public String[] getAirlineName() { return airlineName; }
    public void setAirlineName(String[] value) { this.airlineName = value; }

    public String[] getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String[] value) { this.flightNumber = value; }

    public String[] getLayOverTime() { return layOverTime; }
    public void setLayOverTime(String[] value) { this.layOverTime = value; }

    public String[] getLayOverMinutes() { return layOverMinutes; }
    public void setLayOverMinutes(String[] value) { this.layOverMinutes = value; }

    public String[] getLayOverCity() { return layOverCity; }
    public void setLayOverCity(String[] value) { this.layOverCity = value; }

    public String[] getArrAirportName() { return arrAirportName; }
    public void setArrAirportName(String[] value) { this.arrAirportName = value; }

    public String[] getFlightModel() { return flightModel; }
    public void setFlightModel(String[] value) { this.flightModel = value; }
}
