import java.util.LinkedList;

public class Professor extends Pessoa {


    public Professor(String nome, long numero) {
        this(numero, nome, new LinkedList<>());
    }

    public Professor(long numero, String nome, LinkedList<Aula> aulas) {
        super(nome, numero, aulas);
        for (Aula aula : aulas) {
            adicionar(aula);
        }
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        assinarSumario(aula);
        for (Pessoa aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    public void associar(Aula aula) {

        aula.setProfessor(this);
    }


    public void desassociar(Aula aula) {
        //confirmar se temos de criar um aux para caso de haver um erro não se perder a aula
        Aula aulaARmover = aula;
        aulas.remove(aula);
        aula.desassociarProfessor();
        this.aulas.remove(aulaARmover);
    }
}
