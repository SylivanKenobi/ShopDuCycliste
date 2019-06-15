package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Equipment Klasse
 */
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inhalt")
    @SequenceGenerator(name = "seq_inhalt")
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Double preis;

    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "artikelFk")
    private Artikel artikel;

    @Column(nullable = false)
    private Integer aktiv;

    /**
     * Leerer Konstruktor
     */
    public Equipment() {
        this.aktiv = 1;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Integer getAktiv() {
        return aktiv;
    }

    public void setAktiv(Integer aktiv) {
        this.aktiv = aktiv;
    }
}
