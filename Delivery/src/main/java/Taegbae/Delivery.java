package Taegbae;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long requestId;
    private String status;
    private String courierName;

    @PostPersist
    public void onPostUpdate(){
        Checked checked = new Checked();
        BeanUtils.copyProperties(this, checked);
        checked.publishAfterCommit();


        Picked picked = new Picked();
        BeanUtils.copyProperties(this, picked);
        picked.publishAfterCommit();


        Finished finished = new Finished();
        BeanUtils.copyProperties(this, finished);
        finished.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }




}
