package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Klasse City
 * @author Sylvain Gilgen
 */
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_city")
    @SequenceGenerator(name = "seq_city")
    private Long id;

    @NotNull
    @NotEmpty
    private String ort;

    @NotEmpty
    @NotNull
    private String plz;

    /**
     * Leerer City Konstruktor
     */
    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    /**
     * toString Methode
     * @return
     */
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", ort='" + ort + '\'' +
                ", plz='" + plz + '\'' +
                '}';
    }
}
