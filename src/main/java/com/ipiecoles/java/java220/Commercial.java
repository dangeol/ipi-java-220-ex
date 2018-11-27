package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;
import java.util.Objects;

public class Commercial extends Employe {

    private Double caAnnuel;

    public Double getPrimeAnnuelle() {
        return 100.0;
    }

    public Double getCaAnnuel() {
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Commercial caAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
        return this;
    }
    
}
