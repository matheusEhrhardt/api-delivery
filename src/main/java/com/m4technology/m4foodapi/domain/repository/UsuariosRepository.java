package com.m4technology.m4foodapi.domain.repository;

import com.m4technology.m4foodapi.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario,Long> {
}
