package com.fss.empdb.repos;

import com.fss.empdb.domain.ProjectTagging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaggingRepository extends JpaRepository<ProjectTagging,Long>, JpaSpecificationExecutor<ProjectTagging> {

}
