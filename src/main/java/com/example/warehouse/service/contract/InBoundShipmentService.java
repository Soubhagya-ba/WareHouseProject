package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.InBoundShipmentRequest;
import com.example.warehouse.dto.response.InBoundShipmentResponse;

public interface InBoundShipmentService {
    InBoundShipmentResponse receiveProductInWareHouse(InBoundShipmentRequest request,String wareHouseId);
}
