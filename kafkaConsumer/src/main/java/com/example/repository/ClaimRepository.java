package com.example.repository;

import com.example.elasticsearch.Claim;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends ElasticsearchRepository<Claim, String> {

}
