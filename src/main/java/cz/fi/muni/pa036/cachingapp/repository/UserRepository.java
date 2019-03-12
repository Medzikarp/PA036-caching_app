package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
