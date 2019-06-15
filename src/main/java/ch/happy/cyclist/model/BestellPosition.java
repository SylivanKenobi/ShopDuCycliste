package ch.happy.cyclist.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Klasse Bestellposition
 * @author Sylvain Gilgen
 */
@Entity
public class BestellPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bestellung_pos")
    @SequenceGenerator(name = "seq_bestellung_pos")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "artikel_fk")
    private Artikel artikel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "equipmentSet",
            joinColumns = @JoinColumn(name = "bestellposition_fk"),
            inverseJoinColumns = @JoinColumn(name = "equipment_fk"))
    private Set<Equipment> equipmentSet;

    /**
     * Leerer Konstruktor
     */
    public BestellPosition() {
    }

    /**
     * Konstruktor mit den nötigsten Attributen
     * @param equipmentSet
     * @param artikel
     */
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

    /**
     * toString Methode
     * @return
     */
    @Override
    public String toString() {
        return "BestellPosition{" +
                "id=" + id +
                ", artikel=" + artikel +
                ", equipmentSet=" + equipmentSet +
                '}';
    }
}
