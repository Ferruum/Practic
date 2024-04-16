package com.example.demo.dao;

import com.example.demo.models.Person;
import com.example.demo.models.Promotion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PromotionDAO {
    private static int PROMOTION_COUNT;
    private final List<Promotion> promotion;

    {
        promotion = new ArrayList<>();

        promotion.add(new Promotion(++PROMOTION_COUNT, "Скидон", "10 дней", "Купить от 500", "fq43fsd"));
        promotion.add(new Promotion(++PROMOTION_COUNT, "1+1", "5 дней", "купить акционные ножницы", "34fsvsdvasv"));
        promotion.add(new Promotion(++PROMOTION_COUNT, "Ножницы в подарок", "1 день", "купить кухонные клещи", "hyndy66"));
    }

    public List<Promotion> index() {
        return promotion;
    }

    public Promotion show(int id) {
        return promotion.stream().filter(promotion -> promotion.getId() == id).findAny().orElse(null);
    }

    public void save(Promotion promotions) {
        promotions.setId(++PROMOTION_COUNT);
        promotion.add(promotions);
    }

    public void update(int id, Promotion updatedPromotion) {
        Promotion promotionToBeUpdated = show(id);

        if (promotionToBeUpdated != null) {
            promotionToBeUpdated.setPromotionname(updatedPromotion.getPromotionname());
            promotionToBeUpdated.setPromotiontime(updatedPromotion.getPromotiontime());
            promotionToBeUpdated.setConditions(updatedPromotion.getConditions());
            promotionToBeUpdated.setPronocode(updatedPromotion.getPronocode());
        }
    }

    public void delete(int id) {
        promotion.removeIf(p -> p.getId() == id);
    }

}
