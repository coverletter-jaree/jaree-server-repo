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
@Node("WorkExperience")
public class WorkExperience {
    @Id @GeneratedValue
    private Long id;

    String companyName;

    LocalDate startDate;

    LocalDate endDate;

    String position;

    String description;
}
