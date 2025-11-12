package org.jaree.api.application.dto;

import java.time.LocalDateTime;

import org.jaree.api.application.entity.ApplicationVersion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationVersionDTO {
    private Long id;
    private String commitMessage;     // 자소서 커밋 제목
    private LocalDateTime createdAt;  // 자소서 커밋 생성일자
    private Long previousVersionId;   // 직전 커밋 ID (엔티티 전체 대신 ID만 전달)

    public static ApplicationVersionDTO fromEntity(ApplicationVersion entity) {
        return ApplicationVersionDTO.builder()
            .id(entity.getId())
            .commitMessage(entity.getCommitMessage())
            .createdAt(entity.getCreatedAt())
            .previousVersionId(
                entity.getPreviousVersion() != null ? entity.getPreviousVersion().getId() : null
            )
            .build();
    }
}

