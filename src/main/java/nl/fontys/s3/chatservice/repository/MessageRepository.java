package nl.fontys.s3.chatservice.repository;

import nl.fontys.s3.chatservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}