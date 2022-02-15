package com.ytyler.questdexbe.controller;

import com.ytyler.questdexbe.entity.Quest;
import com.ytyler.questdexbe.exception.ResourceNotFoundException;
import com.ytyler.questdexbe.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quests")
@CrossOrigin
public class QuestController {

    QuestService questService;

    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping
    public ResponseEntity<List<Quest>> getAll() {
        return new ResponseEntity<>(questService.readAll(), HttpStatus.OK);
    }
    @GetMapping(path="{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(questService.readById(id), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Object> postQuest(@RequestBody Quest quest) {
        return new ResponseEntity<>(questService.create(quest), HttpStatus.OK);
    }

    @PutMapping(path="{id}")
    public ResponseEntity<Object> putQuest(@PathVariable Long id, @RequestBody Quest quest) throws ResourceNotFoundException {
        return new ResponseEntity<>(questService.update(id, quest), HttpStatus.OK);
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<Object> deleteQuest(@PathVariable long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(questService.delete(id), HttpStatus.OK);
    }
}
