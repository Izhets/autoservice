package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "branchOffice")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BranchOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long branchOfficeID;

}

