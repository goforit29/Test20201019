package Taegbae;

public class Paycanceld extends AbstractEvent {

    private Long id;
    private Long requestId;
    private Long customerId;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return requestId;
    }

    public void setCustomerId(Long requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}