package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasse Bestellung
 * @author Sylvain Gilgen
 */
@Entity
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bestellung")
    @SequenceGenerator(name = "seq_bestellung")
    private Long id;

    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kunde_fk")
    private Kunde kunde;

    @NotNull
    private Date datum;

    private String bemerkungen;

    @OneToMany
    @JoinColumn(name = "bestellungFk")
    private List<BestellPosition> bestellPositionList;

    /**
     * Leerer Konstruktor
     */
    public Bestellung() {
        datum = new Date();
    }

    /**
     * Konstruktor mit den notwendigsten Parametern
     * @param kunde
     * @param bestellPositionList
     */
    public Bestellung(Kunde kunde, List<BestellPosition> bestellPositionList) {
        this.kunde = kunde;
        this.bestellPositionList = bestellPositionList;
        this.datum = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getBemerkungen() {
        return bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }


    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<BestellPosition> getBestellPositionList() {
        return bestellPositionList;
    }

    public void setBestellPositionList(List<BestellPosition> bestellPositionList) {
        this.bestellPositionList = bestellPositionList;
    }
}
