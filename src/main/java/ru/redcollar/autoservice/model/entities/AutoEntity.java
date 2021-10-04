package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "auto")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long autoID;

}
