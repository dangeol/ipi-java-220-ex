package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;
//import java.util.Date;

public class Entreprise {
    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250.0;
    public static final Double PRIME_ANCIENNETE = 100.0;

    public static Double primeAnnuelleBase() {
        //int year = Calendar.getInstance().get(Calendar.YEAR);
        LocalDate today = LocalDate.now();
        return today.getYear() / 2d;
    }
}
