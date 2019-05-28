package ch.happy.writer.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_artikel")
    @SequenceGenerator(name = "seq_artikel")
    private Long id;

    @NotNull
    @NotEmpty
    private String bezeichnung;

    @NotNull
    @NotEmpty
    private BigDecimal preis;

    @ManyToMany
    @JoinTable(
            name = "konfiguration",
            joinColumns = @JoinColumn(name = "artikel_id"),
            inverseJoinColumns = @JoinColumn(name = "inhalt_id"))
    private Set<Inhalt> inhaltSet;

    public Artikel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public Set<Inhalt> getInhaltSet() {
        return inhaltSet;
    }

    public void setInhaltSet(Set<Inhalt> inhaltSet) {
        this.inhaltSet = inhaltSet;
    }
}
