package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orderDescription")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderDescriptionID;

}