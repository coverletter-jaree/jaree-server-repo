package org.jaree.api.jobopening.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.jaree.api.application.entity.Application;
import org.jaree.api.company.entity.Company;
import org.springframework.data.annotation.CreatedDate;
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
@Node("JobOpening")
public class JobOpening {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String contentS3Url;

    private LocalDateTime startsAt;

    private LocalDateTime endsAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Company company;

    @Relationship(type = "APPLIED_TO", direction = Relationship.Direction.INCOMING)
    private List<Application> applications;

}
