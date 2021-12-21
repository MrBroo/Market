package byfayzullayev.market.repository;

import byfayzullayev.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository <Market, Integer> {
    Market findByName(String name);
}
