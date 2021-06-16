package com.dsp.cms.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Saef Rahal on 5/3/2021.
 */

@Entity
@Table(name = "content_providers")
public class ContentProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "content_provider_name")
    private String contentProviderName;

    @OneToMany(mappedBy="contentProvider")
    private Set<Content> content;

    @Column(name = "content_provider_logo")
    private String ContentProviderLogo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "content_providers_operators",
            joinColumns = @JoinColumn(name = "content_provider_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id"))
    private Set<Operator> operators = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="company_account_id")
    private CompanyAccount companyAccount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "content_provider_services",
            joinColumns = @JoinColumn(name = "company_account_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id"))
    private Set<Service> services = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContentProviderName() {
        return contentProviderName;
    }

    public void setContentProviderName(String contentProviderName) {
        this.contentProviderName = contentProviderName;
    }

    public Set<Content> getContent() {
        return content;
    }

    public void setContent(Set<Content> content) {
        this.content = content;
    }

    public String getContentProviderLogo() {
        return ContentProviderLogo;
    }

    public void setContentProviderLogo(String contentProviderLogo) {
        ContentProviderLogo = contentProviderLogo;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
        this.operators = operators;
    }
}
