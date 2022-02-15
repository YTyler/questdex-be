package com.ytyler.questdexbe.service;

import com.ytyler.questdexbe.entity.Quest;
import com.ytyler.questdexbe.exception.ResourceNotFoundException;
import com.ytyler.questdexbe.repository.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {

    private final QuestRepo questRepo;

    @Autowired
    public QuestService(QuestRepo questRepo) {
        this.questRepo = questRepo;
    }

    //get all Quests
    public List<Quest> readAll() { return questRepo.findAll(); }

    //get a Quest by id
    public Quest readById(Long id) throws ResourceNotFoundException {
        Optional<Quest> questOptional = questRepo.findById(id);
        if(questOptional.isEmpty()) {
            throw new ResourceNotFoundException("Quest ID: " + id + " was not found");
        } else {
            return questOptional.get();
        }
    }

    //create a new Account
    public Quest create(Quest quest) {
        return questRepo.save(quest);
    }

    //update an existing Quest through id
    @Transactional
    public Quest update(long id, Quest quest) throws ResourceNotFoundException {
        Optional<Quest> questOptional = questRepo.findById(id);
        if (questOptional.isEmpty()) {
            throw new ResourceNotFoundException("Quest ID: " + id + " was not found");
        } else {
            Quest questEdit = questOptional.get();
            //if a particular value is given replace it, else keep original value
            questEdit.setName(quest.getName().length() > 0 ? quest.getName() : questEdit.getName());
            questEdit.setGame_title(quest.getGame_title().length() > 0 ? quest.getGame_title() : questEdit.getGame_title());
            questEdit.setNotes(quest.getNotes().length > 0 ? quest.getNotes() : questEdit.getNotes());
            questRepo.save(questEdit); //save and return the edited quest
            return questEdit;
        }
    }

    //delete an Quest
    public Quest delete(Long id) throws ResourceNotFoundException {
        Optional<Quest> questOptional = questRepo.findById(id);
        if (questOptional.isEmpty()) {
            throw new ResourceNotFoundException("Quest ID: " + id + " was not found");
        }
        Quest quest = questOptional.get();
        questRepo.deleteById(id);
        return quest;
    }
}
