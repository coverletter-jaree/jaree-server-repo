package org.jaree.api.resume.entity;

import java.time.LocalDate;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("Project")
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    LocalDate startDate;

    LocalDate endDate;

    private String title;

    private String description;

    private String position;
}
