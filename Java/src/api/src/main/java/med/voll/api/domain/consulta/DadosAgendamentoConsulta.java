package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DadosAgendamentoConsulta(
    Long idMedico,
    
    @NotNull
    Long idPaciente,

    @NotNull
    @Future
    LocalDateTime data
) {

    public Long medicoId() {
        return idMedico;
    }

    public Long pacienteId() {
        return idPaciente;
    }

    public LocalDateTime data() {
        return data;
    }
}