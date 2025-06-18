package com.indexer.revindex.repo;

import com.indexer.revindex.entity.RevData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevIndexRepository extends JpaRepository<RevData,String> {

}
