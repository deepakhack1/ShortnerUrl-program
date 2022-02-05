package com.RestApi.Rest.repository;

import com.RestApi.Rest.entity.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<Url,Long> {
}
