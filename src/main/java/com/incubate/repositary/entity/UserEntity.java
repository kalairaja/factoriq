package com.incubate.repositary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity(name="est_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="firstname" ,nullable = false, length = 45)
    private String firstName;
    @Column(name ="lastname" ,nullable = false, length = 45)
    private String lastName;
    @Column(name ="email" ,nullable = false, length = 30)
    private String email;
    @Column(name ="phoneno" ,nullable = true, length = 12)
    private String phoneNo;
//    @OneToOne(cascade = {CascadeType.ALL})
    //private AddressEntity address;
}
