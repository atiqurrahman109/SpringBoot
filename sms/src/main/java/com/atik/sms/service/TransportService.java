package com.atik.sms.service;

import com.atik.sms.entity.Transport;
import com.atik.sms.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final TransportRepository transportRepo;

    public TransportService(TransportRepository transportRepo) {
        this.transportRepo = transportRepo;
    }

    public List<Transport> getAllVehicles() {
        return transportRepo.findAll();
    }

    public Transport getVehicleById(Long id) {
        return transportRepo.findById(id).orElse(null);
    }

    public Transport saveVehicle(Transport transport) {
        return transportRepo.save(transport);
    }

    public void deleteVehicle(Long id) {
        transportRepo.deleteById(id);
    }
}
