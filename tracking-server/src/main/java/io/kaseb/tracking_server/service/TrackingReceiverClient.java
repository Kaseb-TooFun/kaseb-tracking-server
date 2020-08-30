package io.kaseb.tracking_server.service;

import io.kaseb.tracking_server.domain.TrackingEntity;
import io.kaseb.tracking_server.service.infrastructure.harness.HarnessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TrackingReceiverClient {
    private final HarnessService harnessService;

    @RabbitListener(queues = "${tracking-service.queue.name}")
    public void receiveMessage(final TrackingEntity trackingEntity) {
        logger.info("received tracking from queue : {}", trackingEntity);
        harnessService.createEvent(trackingEntity);
    }
}
