package org.akavity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardData {
    String profileElement;
    String cardNumber;
    String validPeriod;
    String cvv;
    String partOfNumber;
}
