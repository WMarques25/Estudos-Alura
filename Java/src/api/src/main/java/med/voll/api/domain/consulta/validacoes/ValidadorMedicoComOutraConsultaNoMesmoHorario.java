package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuOutraConsultaNoMesmoHorario = repository.existsByMedicoAndData(dados.idMedico(),dados.data());
        if(medicoPossuOutraConsultaNoMesmoHorario){
            throw new RuntimeException("Médico já possui ");
        }
    }
}
