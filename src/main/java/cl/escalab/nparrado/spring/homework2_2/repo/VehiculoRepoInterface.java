package cl.escalab.nparrado.spring.homework2_2.repo;

import cl.escalab.nparrado.spring.homework2_2.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepoInterface extends JpaRepository<Vehiculo, Integer> {
}
