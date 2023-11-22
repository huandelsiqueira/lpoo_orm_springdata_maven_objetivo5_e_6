package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name = "Clientes")
@Table(name = "clientes")
public class Clientes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "idade_cliente")
    private int idade;

    @Column(name = "tel_cliente", nullable = false)
    private int telefone;

    @Column(name = "end_cliente")
    private String endereco;

    @Column(name = "tipo_cliente")
    private int tipoCliente;

    @OneToOne(mappedBy = "cliente")
    private Exemplares exemplar;

    public Clientes() {
    }

    public Clientes(Long id, String nome, int idade, int telefone, String endereco, int tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoCliente = tipoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void manterClientes() {

    }

    @Override
    public String toString() {
        return "\nClientes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

}
