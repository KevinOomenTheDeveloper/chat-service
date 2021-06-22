package nl.fontys.s3.chatservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    @Column(length=500)
    private String description;
    @Column(length=36)
    private String userId;

    public Message(String description, String userId) {
        this.description = description;
        this.userId = userId;
    }

}
