package com.RestApi.Rest.repository;

import com.RestApi.Rest.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

    Optional<Client> findByName(String name);
}
