package com.codebuddies.ticketservice.model;
import java.util.UUID;
public class TicketCodeGeneration {
    public static String genarateCode(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        String code = uuid.substring(0,6);

        return code;

    }

}
