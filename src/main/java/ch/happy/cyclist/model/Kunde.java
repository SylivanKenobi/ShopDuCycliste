package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_kunde")
    @SequenceGenerator(name = "seq_kunde")
    private Long id;

    @NotEmpty
    @NotNull
    private String vorname;

    @NotEmpty
    @NotNull
    private String nachname;

    @NotEmpty
    @NotNull
    private String strasse;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cityFk")
    private City city;


    private String telNr;


    private Date kundeSeit;

    public Kunde() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public Date getKundeSeit() {
        return kundeSeit;
    }

    public void setKundeSeit(Date kundeSeit) {
        this.kundeSeit = kundeSeit;
    }
}
