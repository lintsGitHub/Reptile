package priv.lint.policyreptaile.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.lint.policyreptaile.Entity.PolicyRaw;

@Repository
public interface PolicyJPA  extends JpaRepository<PolicyRaw,Long> {
}
