package org.jaree.api.application.entity;


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
@Node("ApplicationQuestion")
public class ApplicationQuestion {
    @Id
    @GeneratedValue
    private Long id;

    private String question;

    private String description;

    private String answer;

    private int order;
}
