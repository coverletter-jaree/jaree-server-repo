package org.jaree.api.company.entity;

import java.util.List;

import org.jaree.api.jobopening.entity.JobOpening;
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
@Node("Resume")
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String category;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<JobOpening> jobOpenings;
}
