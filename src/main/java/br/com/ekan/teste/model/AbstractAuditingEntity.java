package br.com.ekan.teste.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity {


    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant dataInclusao = Instant.now();


    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant dataAtualizacao = Instant.now();

}