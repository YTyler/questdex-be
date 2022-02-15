package com.ytyler.questdexbe.repository;

import com.ytyler.questdexbe.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepo extends JpaRepository<Quest, Long> {

}
