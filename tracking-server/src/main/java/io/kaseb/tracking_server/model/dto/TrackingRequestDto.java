package io.kaseb.tracking_server.model.dto;

import com.fasterxml.jackson.databind.JsonNode;
import io.kaseb.tracking_server.domain.enums.EventType;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class TrackingRequestDto {
    private String websiteId;
    private EventType eventType;
    private String entityId;
    private String targetEntityId;
    private JsonNode properties;
}
