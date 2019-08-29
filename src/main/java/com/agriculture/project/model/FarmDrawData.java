package com.agriculture.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FarmDrawData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmDrawDataId;

    //    @Column(columnDefinition="VARCHAR")
    private String farmOutlineShape;

    //    @Column(columnDefinition="VARCHAR")
    private String moduleDrawData;

    //    @Column(columnDefinition="VARCHAR")
    private String productDrawData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmId")
    private Farm farm;

}
