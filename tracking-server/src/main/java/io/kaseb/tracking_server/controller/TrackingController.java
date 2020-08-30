package io.kaseb.tracking_server.controller;

import io.kaseb.tracking_server.model.dto.TrackingRequestDto;
import io.kaseb.tracking_server.service.TrackingService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author mahdiyar
 */
@Api
@RestController
@RequestMapping("api/v1/tracking")
@RequiredArgsConstructor
public class TrackingController {
    private final TrackingService trackingService;

    @PostMapping
    public ResponseEntity<Void> track(@RequestBody TrackingRequestDto requestDto) {
        return ok(trackingService.track(requestDto));
    }
}
