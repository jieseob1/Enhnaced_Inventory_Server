package enhanced_inventory.server.service.WMS;

import enhanced_inventory.server.domain.WMS.ExpectedReceipt;
import enhanced_inventory.server.repository.WMS.ExpectedReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpectedReceiptService {
    //입고 예정 서비스
    private ExpectedReceiptRepository expectedReceiptRepository;

    public ExpectedReceiptService(ExpectedReceiptRepository expectedReceiptRepository) {
        this.expectedReceiptRepository = expectedReceiptRepository;
    }

    public ExpectedReceipt createExpectedReceipt(ExpectedReceipt expectedReceipt) {
        return expectedReceiptRepository.save(expectedReceipt);
    }

    // 기타 메서드들
}

