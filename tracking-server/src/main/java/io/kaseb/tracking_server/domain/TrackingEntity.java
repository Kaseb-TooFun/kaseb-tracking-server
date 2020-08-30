package io.kaseb.tracking_server.domain;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class TrackingEntity {
    private JsonNode trackingData;
}
