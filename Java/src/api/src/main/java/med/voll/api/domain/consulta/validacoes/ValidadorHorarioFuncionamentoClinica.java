package med.voll.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorHorarioFuncionamentoClinica {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberuraDaClinica = dataConsulta.getHour() < 7;
        var depoisDoFechamentoDaClinica = dataConsulta.getHour() > 18;
        if(domingo || antesDaAberuraDaClinica || depoisDoFechamentoDaClinica){
            throw new ValidacaoException("Horário de funcionamento da clínica: Segunda a Sexta das 7h às 18h");
        }

    }
}
