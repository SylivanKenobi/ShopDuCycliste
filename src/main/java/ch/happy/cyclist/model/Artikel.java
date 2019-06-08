package ch.happy.cyclist.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_artikel")
    @SequenceGenerator(name = "seq_artikel")
    private Long id;

    @NotNull
    @NotEmpty
    private String model;

    @NotNull
    @NotEmpty
    private BigDecimal preis;

    public Artikel() {
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

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

}
