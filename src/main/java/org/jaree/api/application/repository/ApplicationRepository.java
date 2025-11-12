package org.jaree.api.application.repository;

import java.util.List;

import org.jaree.api.application.entity.Application;
import org.jaree.api.application.entity.ApplicationVersion;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ApplicationRepository extends Neo4jRepository<Application, Long> {
    @org.springframework.data.neo4j.repository.query.Query("""
        MATCH path = (v:ApplicationVersion {id: $id})-[:CHANGED_FROM*0..]->(prev)
        RETURN nodes(path) AS versions
    """)
    List<ApplicationVersion> findAllPreviousVersions(Long id);
}
