package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;

public interface RackService {
    RackResponse addRacks(RackRequest request, String blockId);
}
