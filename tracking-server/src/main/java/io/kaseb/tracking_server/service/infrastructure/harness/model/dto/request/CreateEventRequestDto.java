package io.kaseb.tracking_server.service.infrastructure.harness.model.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import io.kaseb.tracking_server.domain.enums.EventType;
import io.kaseb.tracking_server.model.dto.TrackingRequestDto;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class CreateEventRequestDto {
    private EventType eventType;
    private String entityType;
    private String entityId;
    private String targetEntityType;
    private String targetEntityId;
    private JsonNode properties;
    private String eventTime;

    public CreateEventRequestDto(TrackingRequestDto requestDto, String eventTime) {
        this.eventType = requestDto.getEventType();
        this.entityType = "user";
        this.entityId = requestDto.getEntityId();
        this.targetEntityType = "item";
        this.targetEntityId = requestDto.getTargetEntityId();
        this.properties = requestDto.getProperties();
        this.eventTime = eventTime;
    }
}
