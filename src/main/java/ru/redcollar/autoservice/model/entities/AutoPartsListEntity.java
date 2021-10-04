package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "autoPartsList")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class AutoPartsListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long autoPartID;

}
