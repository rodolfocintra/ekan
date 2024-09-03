package br.com.ekan.teste.repository;


import br.com.ekan.teste.model.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Set;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {


    @Query("select d from DocumentoEntity d where d.beneficiario.id = :idBeneficiario")
    Set<DocumentoEntity> findByBeneficiarioId(Long idBeneficiario);
}
