package io.kaseb.tracking_server.service.infrastructure.harness;

import io.kaseb.tracking_server.domain.TrackingEntity;
import io.kaseb.tracking_server.service.infrastructure.harness.model.dto.request.CreateEventRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HarnessService {
    private final HarnessRestTemplate restTemplate;
    @Value("${services.infrastructure.harness.base-url}")
    private String baseUrl;

    public void createEvent(TrackingEntity trackingEntity) {
        CreateEventRequestDto requestDto = new CreateEventRequestDto(trackingEntity);
        HttpEntity<CreateEventRequestDto> httpEntity = new HttpEntity<>(requestDto);
        String url = String.format("%s/engines/%s/events", baseUrl, trackingEntity.getWebsiteId());
        try {
            String response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class).getBody();
            logger.info("create engine response : {}", response);
        } catch (Exception ex) {
            logger.error("error in creating engine ", ex);
        }
    }

}
