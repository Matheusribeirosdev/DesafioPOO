import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java Básico");
        cursoJava.setDescricao("Introdução à linguagem Java");
        cursoJava.setCargaHoraria(8);

        Curso cursoSpring = new Curso();
        cursoSpring.setTitulo("Spring Framework");
        cursoSpring.setDescricao("Introdução ao desenvolvimento com Spring");
        cursoSpring.setCargaHoraria(6);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java Developer");
        mentoria.setDescricao("Mentoria sobre carreira e desenvolvimento Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao(
                "Bootcamp para formação de desenvolvedores Java"
        );

        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoSpring);
        bootcamp.getConteudos().add(mentoria);

        Dev dev = new Dev();
        dev.setNome("Matheus");

        dev.inscreverBootcamp(bootcamp);

        System.out.println("======================================");
        System.out.println("       BOOTCAMP JAVA DEVELOPER");
        System.out.println("======================================");

        System.out.println();
        System.out.println("Dev: " + dev.getNome());
        System.out.println("Bootcamp: " + bootcamp.getNome());

        System.out.println();
        System.out.println("Conteúdos inscritos:");

        dev.getConteudosInscritos()
                .forEach(conteudo ->
                        System.out.println("- " + conteudo.getTitulo())
                );

        System.out.println();
        System.out.println("Concluindo conteúdos...");

        dev.progredir();
        dev.progredir();

        System.out.println();
        System.out.println("Conteúdos concluídos:");

        dev.getConteudosConcluidos()
                .forEach(conteudo ->
                        System.out.println("- " + conteudo.getTitulo())
                );

        System.out.println();
        System.out.println("Conteúdos ainda pendentes:");

        dev.getConteudosInscritos()
                .forEach(conteudo ->
                        System.out.println("- " + conteudo.getTitulo())
                );

        System.out.println();
        System.out.println("XP total: " + dev.calcularTotalXp());

        System.out.println();
        System.out.println(
                "Data inicial: " + bootcamp.getDataInicial()
        );

        System.out.println(
                "Data final: " + bootcamp.getDataFinal()
        );

        System.out.println();
        System.out.println("======================================");
    }
}