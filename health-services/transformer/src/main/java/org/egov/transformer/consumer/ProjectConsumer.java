package org.egov.transformer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.transformer.enums.Operation;
import org.egov.transformer.handler.TransformationHandler;
import org.egov.transformer.models.upstream.Project;
import org.egov.transformer.models.upstream.ProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProjectConsumer {

    private final TransformationHandler<Project> transformationHandler;

    private final ObjectMapper objectMapper;

    @Autowired
    public ProjectConsumer(TransformationHandler<Project> transformationHandler,
                           @Qualifier("objectMapper") ObjectMapper objectMapper) {
        this.transformationHandler = transformationHandler;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${transformer.consumer.create.project.topic}")
    public void bulkCreate(ConsumerRecord<String, Object> payload,
                           @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        try {
            ProjectRequest request = objectMapper
                    .readValue((String) payload.value(),
                            ProjectRequest.class);
            transformationHandler.handle(request.getProjects(), Operation.PROJECT);
        } catch (Exception exception) {
            log.error("error in project consumer bulk create", exception);
        }
    }
}