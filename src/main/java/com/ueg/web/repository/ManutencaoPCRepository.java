package com.ueg.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ueg.web.model.ManutencaoPC;

@Repository
public interface ManutencaoPCRepository extends JpaRepository<ManutencaoPC, Long> {}
