import java.util.LinkedList;

abstract class Pessoa extends Identificador {
    protected LinkedList<Aula> aulas;


    public Pessoa(String nome, long numero, LinkedList<Aula> aulas) {
        super(nome, numero);
        this.aulas = new LinkedList<>();
    }


    public void preencherSumario(Aula aula) {
        if(aula == null || !aulas.contains(aula)){
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    protected abstract void associar(Aula aula);

    public void remover(Aula aula) {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        desassociar(aula);
    }

    protected abstract void desassociar(Aula aula);

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();
        for (Aula aula : aulas){
            if(aula.getHorario().isSobreposto(horario)){
                aulasHorario.add(aula);
            }
        }
        return aulasHorario;
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

}
