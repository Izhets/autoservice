package ru.redcollar.autoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.redcollar.autoservice.model.dto.OrderListDto;

import java.util.List;

@Service
public class WebClientService {
    @Value("${microservices.ordersService.url.get.orders}")
    private String getOrders;

    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<OrderListDto> getOrdersList() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(getOrders)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<OrderListDto>>() {
                }).block();
    }
}