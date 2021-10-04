package ru.redcollar.autoservice.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientID;

//    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
//    private UserEntity user;
}
