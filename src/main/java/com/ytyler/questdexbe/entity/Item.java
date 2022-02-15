package com.ytyler.questdexbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_id_sequence",
            sequenceName = "item_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )
    private long item_id;
    private String name;
    private String game_title;
    private String[] notes;
    private long number_needed;
}
