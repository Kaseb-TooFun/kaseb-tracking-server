package io.kaseb.tracking_server.service;

import io.kaseb.tracking_server.domain.TrackingEntity;
import io.kaseb.tracking_server.model.dto.TrackingRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TrackingService {
    private final RabbitTemplate rabbitTemplate;
    @Value("${tracking-service.exchange.name}")
    public String exchangeName;

    public Void track(TrackingRequestDto requestDto) {
        TrackingEntity trackingEntity = new TrackingEntity()
                .setTrackingData(requestDto.getTrackData());
        logger.info("adding tracking request to queue");
        rabbitTemplate.convertAndSend(exchangeName, "tracking", trackingEntity);
        return null;
    }

}
