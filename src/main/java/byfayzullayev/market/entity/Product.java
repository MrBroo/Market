package byfayzullayev.market.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.CriteriaBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    private Integer id;
    private String name;
    private String marketname;

    @JsonIgnore
    @ManyToOne
    private Market market;
}
