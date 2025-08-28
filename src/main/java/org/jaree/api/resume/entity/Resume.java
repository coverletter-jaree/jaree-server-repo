package org.jaree.api.resume.entity;

import java.util.List;

import org.jaree.api.user.entity.User;
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
public class Resume {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "WRITTEN_BY", direction = Relationship.Direction.OUTGOING)
    private User user;

    private String middleSchoolName;
    private String highSchoolName;
    private String universityName;
    private String mastersUniversityName;
    private String phdUniversityName;

    @Relationship(type = "HAS_WORK_EXPERIENCE", direction = Relationship.Direction.OUTGOING)
    private List<WorkExperience> workExperiences;

    @Relationship(type = "HAS_PROJECT", direction = Relationship.Direction.OUTGOING)
    private List<Project> projects;
}
