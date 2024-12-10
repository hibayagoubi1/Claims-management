package com.example.searchapi.repository;
import com.example.searchapi.model.Claim;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends ElasticsearchRepository<Claim, String> {
    // Méthodes de recherche personnalisées si nécessaire
}
