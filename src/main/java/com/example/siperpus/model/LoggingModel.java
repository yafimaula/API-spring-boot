package com.example.siperpus.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Document("logging")
public class LoggingModel implements Serializable {

    private static final long serialVersionUID = 3646839845931428958L;

    @Id
    private String id;

    private HashMap<String, Object> data;

    private String type;
}

