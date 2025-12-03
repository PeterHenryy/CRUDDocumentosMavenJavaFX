package inf.pedro.demo.model;

import java.time.LocalDate;

public class Documento {

    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private String descricao;
    private String tipo;

    public Documento() {}

    // Constructor for new documents (no id)
    public Documento(String titulo, String autor, LocalDate dataPublicacao, String descricao, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Constructor for loading from DB (with id)
    public Documento(Integer id, String titulo, String autor, LocalDate dataPublicacao, String descricao, String tipo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    // IMPORTANT: Needed for your DAO to set the generated ID
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
