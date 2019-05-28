package ch.happy.writer.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Inhalt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inhalt")
    @SequenceGenerator(name = "seq_inhalt")
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private BigDecimal preis;

    @ManyToMany
    @JoinTable(
            name = "konfiguration",
            joinColumns = @JoinColumn(name = "inhalt_id"),
            inverseJoinColumns = @JoinColumn(name = "artikel_id"))
    private Set<Artikel> artikelSet;

    public Inhalt() {
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

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public Set<Artikel> getArtikelSet() {
        return artikelSet;
    }

    public void setArtikelSet(Set<Artikel> artikelSet) {
        this.artikelSet = artikelSet;
    }
}
