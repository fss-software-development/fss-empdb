package com.fss.empdb.repos;

import com.fss.empdb.domain.Academics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicsRepository extends JpaRepository<Academics,Long>, JpaSpecificationExecutor<Academics> {

}
