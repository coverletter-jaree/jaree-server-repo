package org.jaree.api.application.repository;

import java.util.List;

import org.jaree.api.application.entity.ApplicationVersion;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationVersionRepository extends Neo4jRepository<ApplicationVersion, Long> {
    @org.springframework.data.neo4j.repository.query.Query("""
        MATCH (a:Application {id: $appId})-[:HAS_VERSION]->(latest:ApplicationVersion)
        OPTIONAL MATCH path = (latest)-[:CHANGED_FROM*0..]->(v:ApplicationVersion)
        RETURN collect(DISTINCT v) AS versions
        ORDER BY v.createdAt DESC
    """)
    List<ApplicationVersion> findAllVersionsByApplicationId(Long appId);
}
