import java.util.LinkedList;

public class Aluno extends Pessoa{
    private String sumario;
    private Identificador professor;


    public Aluno(String nome, long numero) {
        this(nome, numero, new LinkedList<>());
    }

    public Aluno(String nome, long numero, LinkedList<Aula> aulas) {
        super(nome, numero, aulas);
        for (Aula aula : aulas) {
            adicionar(aula);
        }
    }

    protected void escreverSumario(Aula aula) {
        assinarSumario(aula);
    }

    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    public void desassociar(Aula aula) {
        Aula aulaARemover = aula;
        this.aulas.remove(aulaARemover);
        this.remover(aulaARemover);
    }
}