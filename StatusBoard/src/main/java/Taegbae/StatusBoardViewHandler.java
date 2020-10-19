package Taegbae;

import Taegbae.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusBoardViewHandler {


    @Autowired
    private StatusBoardRepository statusBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequseted_then_CREATE_1 (@Payload Requseted requseted) {
        try {
            if (requseted.isMe()) {
                // view 객체 생성
                StatusBoard statusBoard = new StatusBoard();
                // view 객체에 이벤트의 Value 를 set 함
                statusBoard.setRequstId(requseted.getId());
                statusBoard.setStatus(requseted.getStatus());
                // view 레파지 토리에 save
                statusBoardRepository.save(statusBoard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_1(@Payload Canceled canceled) {
        try {
            if (canceled.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(canceled.getId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(canceled.getStatus());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_2(@Payload Paid paid) {
        try {
            if (paid.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(paid.getCustomerId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(paid.getStatus());
                    statusBoard.setDoDt(paid.getRegDate());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaycanceld_then_UPDATE_3(@Payload Paycanceld paycanceld) {
        try {
            if (paycanceld.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(paycanceld.getCustomerId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(paycanceld.getStatus());
                    statusBoard.setDoDt(paycanceld.getRegDate());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenChecked_then_UPDATE_4(@Payload Checked checked) {
        try {
            if (checked.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(checked.getRequestId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(checked.getStatus());
                    statusBoard.setDoDt(checked.getDoDt());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_5(@Payload Picked picked) {
        try {
            if (picked.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(picked.getRequestId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(picked.getStatus());
                    statusBoard.setDoDt(picked.getDoDt());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenFinished_then_UPDATE_6(@Payload Finished finished) {
        try {
            if (finished.isMe()) {
                // view 객체 조회
                List<StatusBoard> statusBoardList = statusBoardRepository.findByRequstId(finished.getRequestId());
                for(StatusBoard statusBoard : statusBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusBoard.setStatus(finished.getStatus());
                    statusBoard.setDoDt(finished.getDoDt());
                    // view 레파지 토리에 save
                    statusBoardRepository.save(statusBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}