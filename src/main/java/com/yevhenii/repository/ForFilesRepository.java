package com.yevhenii.repository;

import com.yevhenii.model.ForFiles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yevhenii on 29.11.2017.
 */
@Repository
public interface ForFilesRepository extends CrudRepository<ForFiles, Integer> {
    @Transactional
    @Query(value = "select f from ForFiles f where f.name = ?1")
    ForFiles findByName(String name);
}
