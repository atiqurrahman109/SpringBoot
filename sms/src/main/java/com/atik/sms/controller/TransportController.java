package com.atik.sms.controller;

import com.atik.sms.entity.Transport;
import com.atik.sms.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public List<Transport> getAllVehicles() {
        return transportService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Transport getVehicle(@PathVariable Long id) {
        return transportService.getVehicleById(id);
    }

    @PostMapping
    public Transport addVehicle(@RequestBody Transport transport) {
        return transportService.saveVehicle(transport);
    }

    @PutMapping("/{id}")
    public Transport updateVehicle(@PathVariable Long id, @RequestBody Transport transport) {
        transport.setId(id);
        return transportService.saveVehicle(transport);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        transportService.deleteVehicle(id);
    }
}
