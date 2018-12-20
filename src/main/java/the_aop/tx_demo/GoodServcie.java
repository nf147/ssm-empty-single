package the_aop.tx_demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GoodServcie {

    @Transactional(timeout = 1000, readOnly = false)
    public void saveGood(String good) {
        // 1. 保存日志

        // 2. 查询货物状态

        // 3. 保存货物
    }

    public void lingwaiyige() {

    }
}
