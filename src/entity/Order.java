package entity;

import java.time.LocalDate;

public class Order {
    String id;
    LocalDate created_at;

    public Order(String id, LocalDate created_at) {
        this.id = id;
        this.created_at = created_at;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

}
