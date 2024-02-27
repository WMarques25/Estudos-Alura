package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
    @NotNull
    Long idConsulta,

    @NotNull
    MotivoCancelamento motivo
){

    public DadosCancelamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMotivoCancelamento());
    }
}
