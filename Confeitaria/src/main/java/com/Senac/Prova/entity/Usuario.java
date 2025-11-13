package com.Senac.Prova.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;
    @Column(name = "usuario_login")
    private String login;
    @Column(name = "usuario_senha")
    private String senha;
    @Column(name = "usuario_status")
    private Integer status;

   @ManyToMany (fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
   @JoinTable(name = "usuario_role",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns =  @JoinColumn(name = "role_id"))
   private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
