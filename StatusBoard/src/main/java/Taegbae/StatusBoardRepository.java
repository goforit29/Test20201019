package Taegbae;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusBoardRepository extends CrudRepository<StatusBoard, Long> {

    List<StatusBoard> findByRequstId(Long requstId);
    List<StatusBoard> findByRequstId(Long requstId);
    List<StatusBoard> findByRequstId(Long requstId);
    List<StatusBoard> findByRequstId(Long requstId);
    List<StatusBoard> findByRequstId(Long requstId);
    List<StatusBoard> findByRequstId(Long requstId);

}