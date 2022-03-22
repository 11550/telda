package ru.telda.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Region implements Serializable {

    @Serial()
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String nameSimple;

}
