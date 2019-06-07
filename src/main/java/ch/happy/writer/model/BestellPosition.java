package ch.happy.writer.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BestellPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bestellung_pos")
    @SequenceGenerator(name = "seq_bestellung_pos")
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artikel_fk")
    private Artikel artikel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "inhalte",
            joinColumns = @JoinColumn(name = "bestellposition_fk"),
            inverseJoinColumns = @JoinColumn(name = "inhalte_fk"))
    private Set<Inhalt> inhalte;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bestellung_fk")
    private Bestellung bestellung;

    public BestellPosition() {
    }

    public BestellPosition(Set<Inhalt> inhaltSet, Artikel artikel, Bestellung bestellung) {
        this.artikel = artikel;
        this.inhalte = inhalte;
        this.bestellung = bestellung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Set<Inhalt> getInhalte() {
        return inhalte;
    }

    public void setInhalte(Set<Inhalt> inhalte) {
        this.inhalte = inhalte;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

    public void setBestellung(Bestellung bestellung) {
        this.bestellung = bestellung;
    }
}
