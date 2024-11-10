package tn.esprit.reservation.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.reservation.entity.Nutrition;

import java.util.List;

@FeignClient(name = "Nutrition", url = "http://localhost:9095")
public interface NutritionClient {
    @GetMapping("/nutrition/retrieve-all-nutritions")
    public List<Nutrition> getNutritions();
}
