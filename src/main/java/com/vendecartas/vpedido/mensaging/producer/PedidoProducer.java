package com.vendecartas.vpedido.mensaging.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.vendecartas.vpedido.mensaging.event.PedidoCriadoEvent;

@Component
public class PedidoProducer {

    private static final String TOPIC = "pedido-criado";

    private final KafkaTemplate<String, PedidoCriadoEvent> kafkaTemplate;

    public PedidoProducer(KafkaTemplate<String, PedidoCriadoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(PedidoCriadoEvent event) {
        kafkaTemplate.send(
            TOPIC,
            event.id().toString(),
            event
        );
    }
}
