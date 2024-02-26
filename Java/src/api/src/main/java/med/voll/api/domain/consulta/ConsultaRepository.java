package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

    boolean existsByMedicoAndData(Long idMedico, @NotNull @Future LocalDateTime data);

    boolean existsByPacienteAndDataBetween(@NotNull Long idPaciente, LocalDateTime primeiroHorario,
            LocalDateTime ultimoHorario);

    

}
