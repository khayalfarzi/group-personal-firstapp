package az.coders.grouppersonal.dao.repository;

import az.coders.grouppersonal.dao.entity.ERole;
import az.coders.grouppersonal.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}