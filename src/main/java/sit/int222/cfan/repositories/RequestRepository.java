package sit.int222.cfan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int222.cfan.entities.Request;

public interface RequestRepository extends JpaRepository<Request,Long> {
}