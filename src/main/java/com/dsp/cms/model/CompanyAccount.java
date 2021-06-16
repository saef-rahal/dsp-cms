package com.dsp.cms.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.swing.text.StyleConstants.Size;

/**
 * Created by Saef Rahal on 5/3/2021.
 */
@Entity
@Table(name = "company_accounts")
public class CompanyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_account_roles",
            joinColumns = @JoinColumn(name = "company_account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "company_account_operators",
            joinColumns = @JoinColumn(name = "company_account_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id"))
    private Set<Operator> operators;

    private boolean status;

    @OneToMany(mappedBy="companyAccount")
    private Set<ContentProvider> contentProviders;

    @OneToMany(mappedBy="companyAccount")
    private Set<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
        this.operators = operators;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
