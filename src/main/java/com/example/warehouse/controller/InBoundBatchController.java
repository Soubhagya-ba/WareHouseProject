package com.example.warehouse.controller;

import com.example.warehouse.dto.request.InBoundBatchRequest;
import com.example.warehouse.dto.response.InBoundBatchResponse;
import com.example.warehouse.dto.wrapper.ResponseStructure;
import com.example.warehouse.service.contract.InBoundBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InBoundBatchController {

    @Autowired
    private InBoundBatchService inBoundBatchService;

    @PostMapping("/batch/{shipmentId}")
    public ResponseEntity<ResponseStructure<InBoundBatchResponse>> createInboundBatch(@RequestBody InBoundBatchRequest request, @PathVariable String shipmentId){
     InBoundBatchResponse inBoundBatchResponse =  inBoundBatchService.receiveProductUnit(request,shipmentId);
      ResponseStructure<InBoundBatchResponse> responseStructure = new ResponseStructure<>(HttpStatus.CREATED.value(), "Units Are Added !!",inBoundBatchResponse);
      return new ResponseEntity<ResponseStructure<InBoundBatchResponse>>(responseStructure,HttpStatus.CREATED);
    }

    @GetMapping("/QrCode")
    public ResponseEntity<byte[]> generateQrCodeForProduct(@RequestParam String unitId){
       byte[] bytes = inBoundBatchService.generateQrForProduct(unitId);
       return ResponseEntity.status(HttpStatus.CREATED)
               .header(HttpHeaders.CONTENT_TYPE,MediaType.IMAGE_PNG.toString())
               .body(bytes);
    }
}
