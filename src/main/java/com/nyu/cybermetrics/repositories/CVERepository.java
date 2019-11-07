package com.nyu.cybermetrics.repositories;

import com.nyu.cybermetrics.entities.CVEEntity;
import org.springframework.data.repository.CrudRepository;

public interface CVERepository extends CrudRepository<CVEEntity, String> {
}
