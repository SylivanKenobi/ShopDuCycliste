package ch.happy.writer.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bestellung")
    @SequenceGenerator(name = "seq_bestellung")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kunde_fk")
    private Kunde kunde;

    @NotEmpty
    @NotNull
    private Date datum;

    @NotEmpty
    @NotNull
    private String bemerkungen;

    public Bestellung() {
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getBemerkungen() {
        return bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }
}
