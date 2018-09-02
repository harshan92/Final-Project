package com.nortshore.metrofactory;

public class Machine {
    private  Long hum;
    private  String installed;
    private  String maintained;
    private String name;
    private  Long temp;

    public Machine(String name, String maintained, String installed, Long hum, Long temp) {
        this.name = name;
        this.maintained = maintained;
        this.installed = installed;
        this.hum = hum;
        this.temp = temp;
    }

    public Machine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaintained() {
        return maintained;
    }

    public void setMaintained(String maintained) {
        this.maintained = maintained;
    }

    public String getInstalled() {
        return installed;
    }

    public void setInstalled(String installed) {
        this.installed = installed;
    }

    public Long getHum() {
        return hum;
    }

    public void setHum(Long hum) {
        this.hum = hum;
    }

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Machine{}";
    }

}
