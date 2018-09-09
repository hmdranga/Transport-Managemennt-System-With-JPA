package lk.ijse.tpmgt.entity;

import java.math.BigDecimal;

public class CustomEntity {
    private BigDecimal total;

    public CustomEntity(BigDecimal total) {
        this.setTotal(total);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
