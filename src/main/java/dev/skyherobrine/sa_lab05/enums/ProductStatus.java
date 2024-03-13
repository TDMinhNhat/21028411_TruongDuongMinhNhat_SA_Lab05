package dev.skyherobrine.sa_lab05.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ProductStatus {
    SELLING(1), SOLD_OUT(0), EXPIRED(-1);

    private int value;
}
