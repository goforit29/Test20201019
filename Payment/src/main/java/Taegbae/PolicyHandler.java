package Taegbae;

import Taegbae.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_PaymentCancel(@Payload Canceled canceled){

        if(canceled.isMe()){
            //System.out.println("##### listener PaymentCancel : " + canceled.toJson());
            Optional<Payment> paymentOptional = paymentRepository.findById(canceled.getId());
            Payment payment = paymentOptional.get();
            payment.setStatus("Payment Cancelled");
            payment.setRequestId(canceled.getId());

            paymentRepository.save(payment);
        }
    }

}
