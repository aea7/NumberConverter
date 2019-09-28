package com.numberconverter.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class Conversion {

    private String from;
    private String to;
    private String number;

}
