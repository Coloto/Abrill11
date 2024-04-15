package com.softtek.modelo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    private int product_id;
    private String product_name;
    private int category_id;
    private int unit_price;
    private int units_on_stock;

    @Override
    public String toString() {
        return "Producto{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", category_id=" + category_id +
                ", unit_price=" + unit_price +
                ", units_on_stock=" + units_on_stock +
                '}';
    }
}
