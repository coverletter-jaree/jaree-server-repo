package org.jaree.api.application.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("ApplicationVersion")
public class ApplicationVersion {
    @Id
    @GeneratedValue
    private Long id;

    private String commitMessage;

    @CreatedDate
    private LocalDateTime createdAt;

    @Relationship(type = "CHANGED_FROM", direction = Relationship.Direction.OUTGOING)
    private ApplicationVersion previousVersion;

    @Relationship(type = "HAS_ITEM", direction = Relationship.Direction.OUTGOING)
    private List<ApplicationQuestion> questions;
}
