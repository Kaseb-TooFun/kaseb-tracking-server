package io.kaseb.tracking_server.service;

import io.kaseb.tracking_server.domain.TrackingEntity;
import io.kaseb.tracking_server.model.dto.TrackingRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        TrackingEntity trackingEntity = createTrackingEntity(requestDto);
        logger.info("trying to add tracking request to queue");
        try {
            rabbitTemplate.convertAndSend(exchangeName, "tracking.user", trackingEntity);
        } catch (Exception ex) {
            logger.error("error in adding tracking request to queue ", ex);
        }
        return null;
    }

    private TrackingEntity createTrackingEntity(TrackingRequestDto requestDto) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        return new TrackingEntity()
                .setEntityId(requestDto.getEntityId())
                .setEventType(requestDto.getEventType())
                .setProperties(requestDto.getProperties())
                .setTargetEntityId(requestDto.getTargetEntityId())
                .setWebsiteId(requestDto.getWebsiteId())
                .setEventTime(simpleDateFormat.format(new Date()));
    }

}
