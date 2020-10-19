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
    RequestRepository RequestRepositroty;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaycanceld_Cancel(@Payload Paycanceld paycanceld){

        if(paycanceld.isMe()){

                //System.out.println("##### listener Cancel : " + paycanceld.toJson());
                Optional<Request> requestOptional = RequestRepositroty.findById(paycanceld.getId());
                Request request = requestOptional.get();
                request.setStatus(paycanceld.getStatus());
                RequestRepositroty.save(request);


        }
    }

}
