package ch.happy.cyclist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BestellPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bestellung_pos")
    @SequenceGenerator(name = "seq_bestellung_pos")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artikel_fk")
    private Artikel artikel;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "equipmentSet",
            joinColumns = @JoinColumn(name = "bestellposition_fk"),
            inverseJoinColumns = @JoinColumn(name = "equipment_fk"))
    private Set<Equipment> equipmentSet;

    public BestellPosition() {
    }

    public BestellPosition(Set<Equipment> equipmentSet, Artikel artikel) {
        this.artikel = artikel;
        this.equipmentSet = equipmentSet;
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

    public Set<Equipment> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(Set<Equipment> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }
}
