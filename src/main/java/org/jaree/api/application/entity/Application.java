package org.jaree.api.application.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.jaree.api.jobopening.entity.JobOpening;
import org.jaree.api.user.entity.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
@Node("Application")
public class Application {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String position;

    private Boolean isAccepted;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime dueAt;

    @Relationship(type = "HAS_ITEM", direction = Relationship.Direction.OUTGOING)
    private List<ApplicationQuestion> questions;

    @Relationship(type = "WRITTEN_BY", direction = Relationship.Direction.OUTGOING)
    private User user;

    @Relationship(type = "APPLIED_TO", direction = Relationship.Direction.OUTGOING)
    private JobOpening jobOpening;

    @Relationship(type = "HAS_VERSION", direction = Relationship.Direction.OUTGOING)
    private List<ApplicationVersion> versions;

    @Relationship(type = "LATEST_VERSION", direction = Relationship.Direction.OUTGOING)
    private ApplicationVersion latestVersion;
}
