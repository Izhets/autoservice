package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orderList")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class OrderListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderListID;

}
