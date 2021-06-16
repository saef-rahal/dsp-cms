package com.dsp.cms.model;

import javax.persistence.*;

/**
 * Created by Saef Rahal on 5/3/2021.
 */
@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "operator_logo")
    private String operatorLogo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorLogo() {
        return operatorLogo;
    }

    public void setOperatorLogo(String operatorLogo) {
        this.operatorLogo = operatorLogo;
    }
}
