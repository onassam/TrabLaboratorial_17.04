import java.util.LinkedList;

public class Horario{
    private DiaSemana diaSemana;
    private int duracao;
    private int horaInicio;

    public Horario(DiaSemana diaSemana, int duracao, int horaInicio) {
        this.diaSemana = diaSemana;
        this.duracao = duracao;
        this.horaInicio = horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public boolean isSobreposto(Horario horario) {
        if(this.diaSemana ==  horario.getDiaSemana()){
            if(this.horaInicio + duracao > horario.getHoraInicio()
                    || horario.getHoraInicio() + horario.getDuracao() > this.horaInicio)
            {
                return false;
            }

        }
        return true;
    }
}
