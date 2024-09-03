package br.com.ekan.teste.repository;

import br.com.ekan.teste.model.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Long> {
}
