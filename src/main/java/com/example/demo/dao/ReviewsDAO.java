package com.example.demo.dao;

import com.example.demo.models.Person;
import com.example.demo.models.Reviews;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewsDAO {
    private static int REVIEWS_COUNT;
    private final List<Reviews> reviews;

    {
        reviews = new ArrayList<>();

        reviews.add(new Reviews(++REVIEWS_COUNT, "Кристалис", "Полина", "10 из 10", "очень круто режут"));
        reviews.add(new Reviews(++REVIEWS_COUNT, "Пернилис", "Петя", "10 из 10", "лучше не видал"));
        reviews.add(new Reviews(++REVIEWS_COUNT, "Лопалис", "Варя", "1 из 10", "разрезал себе всё что можно"));
    }

    public List<Reviews> index() {
        return reviews;
    }

    public Reviews show(int id) {
        return reviews.stream().filter(reviews -> reviews.getId() == id).findAny().orElse(null);
    }

    public void save(Reviews review) {
        review.setId(++REVIEWS_COUNT);
        reviews.add(review);
    }

    public void update(int id, Reviews updatedReviews) {
        Reviews reviewsToBeUpdated = show(id);

        if (reviewsToBeUpdated != null) {
            reviewsToBeUpdated.setNamecut(updatedReviews.getNamecut());
            reviewsToBeUpdated.setClientname(updatedReviews.getClientname());
            reviewsToBeUpdated.setRaiting(updatedReviews.getRaiting());
            reviewsToBeUpdated.setComment(updatedReviews.getComment());
        }
    }

    public void delete(int id) {
        reviews.removeIf(p -> p.getId() == id);
    }
}
