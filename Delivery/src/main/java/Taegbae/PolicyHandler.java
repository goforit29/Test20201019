package Taegbae;

import Taegbae.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_CreateDelivery(@Payload Paid paid){

        if(paid.isMe()){
            //System.out.println("##### listener CreateDelivery : " + paid.toJson());
            //Optional<Delivery> deliveryOptional = deliveryRepository.findById(paid.getRequestId());
            //Delivery delivery = deliveryOptional.get();
            //delivery.setRequestId(paid.getRequestId());
            //delivery.setStatus("BeforeChecked");
            Delivery delivery = new Delivery();
            delivery.setRequestId(paid.getRequestId());
            delivery.setStatus("BeforeChecked");

            deliveryRepository.save(delivery);




        }
    }

}
