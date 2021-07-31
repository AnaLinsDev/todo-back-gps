package br.edu.ifpb.gps.planner.Planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.gps.planner.Planner.model.Task;



@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findByUsuarioId(int id);
    
    public boolean existsById(int id);
    
    @Query("select max(t.id) from Task t")
    public Integer findMaxId();
	
}
