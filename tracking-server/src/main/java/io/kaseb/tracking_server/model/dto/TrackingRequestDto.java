package io.kaseb.tracking_server.model.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Data
public class TrackingRequestDto {
    private JsonNode trackData;
}
