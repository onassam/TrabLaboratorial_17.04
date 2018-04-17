import java.util.LinkedList;

public class Aula extends Identificador{
    private String sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    public Aula(String nome, long numero, Horario horario) {
        this(nome, numero, horario, null, new LinkedList<>());
    }


    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos) {
        super(nome, numero);
        this.sumario = "";
        this.horario = horario;
        setProfessor(professor);
        this.alunos = new LinkedList<>(alunos);
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
    }

    public void adicionar(Aluno aluno) {
        if(aluno == null || alunos.contains(aluno)) {
            return;
        }
        this.alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Pessoa aluno) {
        if(!alunos.contains(aluno) || aluno == null){
            return;
        }
        Pessoa alunoARemover = aluno;
        alunos.remove(alunoARemover);
        this.remover(alunoARemover);
    }

    public void adicionarLinhaSumario(String linha) {
        StringBuilder sb = new StringBuilder();
        sb.append(linha).append("\n");
        sumario = sb.toString();
    }

    public String getSumario() {
        return sumario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null || this.professor == professor) {
            return;
        }
        if (this.professor != null) { //se já tem um professor temos de remover
            this.professor.remover(this);
        }
        this.professor = professor;
        this.professor.adicionar(this);
    }

    public void desassociarProfessor(){
        if(professor == null){
            return;
        }
        Professor professorARemover = professor;
        professor = null;
        professorARemover.remover(this);
    }

    public LinkedList<Pessoa> getAlunos() {
        return new LinkedList<>(alunos);
    }

    public Horario getHorario() {
        return horario;
    }




}
