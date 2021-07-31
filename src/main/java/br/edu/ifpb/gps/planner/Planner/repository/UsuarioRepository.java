package br.edu.ifpb.gps.planner.Planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.gps.planner.Planner.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
    public boolean existsByEmail(String email);

    public List<Usuario> findByEmail(String email);

    @Query("select max(u.id) from Usuario u")
    public Integer findMaxId();
}
