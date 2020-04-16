package com.fss.empdb.repos;

import com.fss.empdb.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long>, JpaSpecificationExecutor<Region> {

}
