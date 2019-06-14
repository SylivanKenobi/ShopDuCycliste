package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Artikel Klasse
 * @author Sylvain Gilgen
 */
@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_artikel")
    @SequenceGenerator(name = "seq_artikel")
    private Long id;

    @NotNull
    @NotEmpty
    private String model;

    @Column(nullable = false)
    private Double preis;

    @Column(nullable = false)
    private Integer aktiv;

    private String pfad;

    /**
     * Leerer Konstruktor
     */
    public Artikel() {
    }

    /**
     * Voller Konstrukter zum Artikel erstellen
     * @param model
     * @param preis
     * @param pfad
     */
    public Artikel(String model, Double preis, String pfad) {
        this.model = model;
        this.preis = preis;
        this.pfad = pfad;
        this.aktiv = 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Integer getAktiv() {
        return aktiv;
    }

    public void setAktiv(Integer aktiv) {
        this.aktiv = aktiv;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }
}
