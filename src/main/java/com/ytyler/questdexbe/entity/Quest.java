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
public class Quest {
    @Id
    @SequenceGenerator(
            name = "quest_id_sequence",
            sequenceName = "quest_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quest_id_sequence"
    )
    private long quest_id;
    private String name;
    private String game_title;
    private String[] notes;
}
