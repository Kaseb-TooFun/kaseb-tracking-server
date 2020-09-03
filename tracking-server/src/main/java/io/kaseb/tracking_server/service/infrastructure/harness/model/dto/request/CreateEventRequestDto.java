package io.kaseb.tracking_server.service.infrastructure.harness.model.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import io.kaseb.tracking_server.domain.TrackingEntity;
import io.kaseb.tracking_server.domain.enums.EventType;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class CreateEventRequestDto {
    private EventType event;
    private String entityType;
    private String entityId;
    private String targetEntityType;
    private String targetEntityId;
    private JsonNode properties;
    private String eventTime;

    public CreateEventRequestDto(TrackingEntity trackingEntity) {
        this.event = trackingEntity.getEventType();
        this.entityType = "user";
        this.entityId = trackingEntity.getEntityId();
        this.targetEntityType = "item";
        this.targetEntityId = trackingEntity.getTargetEntityId();
        this.properties = trackingEntity.getProperties();
        this.eventTime = trackingEntity.getEventTime();
    }
}
