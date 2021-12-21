package byfayzullayev.market.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "market")
    private List<Product> product;

}
