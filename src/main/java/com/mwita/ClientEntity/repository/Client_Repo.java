package com.mwita.ClientEntity.repository;

import com.mwita.ClientEntity.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface Client_Repo extends JpaRepository<client,Long> {
}
