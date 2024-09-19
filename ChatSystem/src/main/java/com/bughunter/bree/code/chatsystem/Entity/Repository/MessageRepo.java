package com.bughunter.bree.code.chatsystem.Entity.Repository;

import com.bughunter.bree.code.chatsystem.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {

    List<Message> findMessagesByTimestamp(LocalDateTime startOfDay, LocalDateTime endOfDay);

}
