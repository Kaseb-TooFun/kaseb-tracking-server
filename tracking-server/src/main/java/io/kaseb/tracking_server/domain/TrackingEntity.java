package io.kaseb.tracking_server.domain;

import com.fasterxml.jackson.databind.JsonNode;
import io.kaseb.tracking_server.domain.enums.EventType;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class TrackingEntity {
    private String websiteId;
    private EventType eventType;
    private String entityId;
    private String targetEntityId;
    private JsonNode properties;
    private String eventTime;
}
