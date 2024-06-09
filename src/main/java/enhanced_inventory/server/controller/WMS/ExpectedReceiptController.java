package enhanced_inventory.server.controller.WMS;

import enhanced_inventory.server.domain.WMS.ExpectedReceipt;
import enhanced_inventory.server.service.WMS.ExpectedReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expected-receipts")
public class ExpectedReceiptController {
    @Autowired
    private ExpectedReceiptService expectedReceiptService;

    @PostMapping
    public ResponseEntity<ExpectedReceipt> createExpectedReceipt(@RequestBody ExpectedReceipt expectedReceipt) {
        ExpectedReceipt createdExpectedReceipt = expectedReceiptService.createExpectedReceipt(expectedReceipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpectedReceipt);
    }

    // 기타 엔드포인트들
}

