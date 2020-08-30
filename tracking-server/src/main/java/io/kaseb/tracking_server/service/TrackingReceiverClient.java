package io.kaseb.tracking_server.service;

import com.fasterxml.jackson.databind.JsonNode;
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
    @RabbitListener(queues = "${tracking-service.queue.name}")
    public void receiveMessage(final JsonNode jsonNode) {
        logger.info("received tracking from queue : {}", jsonNode);
    }
}
