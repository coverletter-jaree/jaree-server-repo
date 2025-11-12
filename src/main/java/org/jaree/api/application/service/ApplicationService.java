package org.jaree.api.application.service;

import java.util.List;

import org.jaree.api.application.dto.ApplicationVersionDTO;
import org.jaree.api.application.dto.ApplicationVersionListDTO;
import org.jaree.api.application.entity.ApplicationVersion;
import org.jaree.api.application.repository.ApplicationVersionRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationVersionRepository applicationVersionRepository;

    /**
     * 특정 Application에 연결된 모든 버전(브랜치 포함)을 조회합니다.
     *
     * @param applicationId Application ID
     * @return 해당 Application의 모든 ApplicationVersion 목록
     */
    public List<ApplicationVersionListDTO> getAllVersionsByApplicationId(Long applicationId) {
        List<ApplicationVersion> verions = applicationVersionRepository.findAllVersionsByApplicationId(applicationId);

    }

    /**
     * 특정 Application의 최신(leaf) 버전만 조회합니다.
     *
     * @param applicationId Application ID
     * @return 최신 버전 목록
     */
    public List<ApplicationVersion> getLatestVersionsByApplicationId(Long applicationId) {
        return applicationVersionRepository.findAllLatestVersionsByApplicationId(applicationId);
    }
}
