package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;

    private final LocalDate dataInicial;
    private final LocalDate dataFinal;

    private Set<Dev> devsInscritos;
    private Set<Conteudo> conteudos;

    public Bootcamp() {
        this.dataInicial = LocalDate.now();
        this.dataFinal = dataInicial.plusDays(45);

        this.devsInscritos = new HashSet<>();
        this.conteudos = new LinkedHashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Bootcamp)) {
            return false;
        }

        Bootcamp outro = (Bootcamp) objeto;

        return Objects.equals(nome, outro.nome)
                && Objects.equals(descricao, outro.descricao)
                && Objects.equals(dataInicial, outro.dataInicial)
                && Objects.equals(dataFinal, outro.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                nome,
                descricao,
                dataInicial,
                dataFinal
        );
    }
}