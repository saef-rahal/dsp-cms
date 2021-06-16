package com.dsp.cms.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Saef Rahal on 5/3/2021.
 */
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "service_name")
    private String serviceName;

    @ManyToOne
    @JoinColumn(name="company_account_id")
    private CompanyAccount companyAccount;

    @ManyToOne
    @JoinColumn(name="operator_id")
    private Operator operator;

    private String description;

    @OneToMany(mappedBy="service")
    private Set<Content> contents;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }
}
