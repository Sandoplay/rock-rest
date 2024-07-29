package org.sandopla.rockrest.repository;

import org.sandopla.rockrest.Score;
import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ScoreRepositoryCrud extends CrudRepository<Score, Long> {

}