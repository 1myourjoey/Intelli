
package com.sky.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {

    private Long prodId;
    @NonNull private String prodName;
    @NonNull private Integer prodPrice;
}
