package br.com.maratona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.maratona.models.Maratona;

@Repository
public interface MaratonaRepository extends JpaRepository<Maratona, Long> {

}
