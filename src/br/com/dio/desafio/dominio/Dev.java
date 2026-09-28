package br.com.dio.desafio.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;

    private Set<Conteudo> conteudosInscritos;
    private Set<Conteudo> conteudosConcluidos;

    public Dev() {
        this.conteudosInscritos = new LinkedHashSet<>();
        this.conteudosConcluidos = new LinkedHashSet<>();
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {

        Optional<Conteudo> primeiroConteudo =
                conteudosInscritos.stream().findFirst();

        if (primeiroConteudo.isPresent()) {

            Conteudo conteudo = primeiroConteudo.get();

            conteudosConcluidos.add(conteudo);
            conteudosInscritos.remove(conteudo);

        } else {
            System.out.println(
                    "Você não possui conteúdos pendentes."
            );
        }
    }

    public double calcularTotalXp() {

        Iterator<Conteudo> iterator =
                conteudosConcluidos.iterator();

        double totalXp = 0;

        while (iterator.hasNext()) {
            totalXp += iterator.next().calcularXp();
        }

        return totalXp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof Dev)) {
            return false;
        }

        Dev outro = (Dev) objeto;

        return Objects.equals(nome, outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}