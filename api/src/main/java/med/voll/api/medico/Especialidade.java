package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public enum Especialidade {
    ORTOPEDIA, CARDIOLOGIA, GINECOLOGIA, DERMATOLOGIA;

    public static interface MedicoRepository extends JpaRepository<Medico, Long> {
    }
}
