package org.jaree.api.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.jaree.api.application.entity.Application;
import org.jaree.api.resume.entity.Resume;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("User")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime registeredAt;

    @Relationship(type = "WRITTEN_BY", direction = Relationship.Direction.INCOMING)
    private List<Application> applications;

    @Relationship(type = "WRITTEN_BY", direction = Relationship.Direction.INCOMING)
    private Resume resume;
}
