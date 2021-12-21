package byfayzullayev.market.controller;

import byfayzullayev.market.entity.Market;
import byfayzullayev.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/markets")
public class MarketController {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    //CREATE
    @PostMapping("/addmarket")
    public String addmarket(@RequestBody Market market) {
        Market addmarket = new Market();
        Market byName = marketRepository.findByName(market.getName());
        if (byName != null) {
            return "Bu market allaqachon mavjud";
        }
        addmarket.setName(market.getName());
        marketRepository.save(addmarket);
        return "Market qo`shildi";
    }

    //READ
    @GetMapping("/marketlist")
    public List<Market> getMarketList() {
        List<Market> markets = marketRepository.findAll();
        return markets;

    }

    @PutMapping("/edit/{id}")
    public String editMarket(@PathVariable Integer id, @RequestBody Market market) {
        Optional<Market> byId = marketRepository.findById(id);
        if (byId.isPresent()) {
            Market editMarket = byId.get();
            Market byName = marketRepository.findByName(market.getName());

            if (byName != null) {
                return "Bu market nomi mavjud";
            }
            editMarket.setName(market.getName());
            marketRepository.save(editMarket);
            return "saqland";
        }
        return "Qayta urunib ko`ring";
    }

    //DELETE
    @DeleteMapping("/delete")
    public String deleteMarket(@PathVariable Integer id) {
        Optional<Market> byId = marketRepository.findById(id);
        if (byId.isPresent()) {
            marketRepository.deleteById(id);
            return "O`chirildi";
        }
        return "Qaytadan uruning";
    }

}
