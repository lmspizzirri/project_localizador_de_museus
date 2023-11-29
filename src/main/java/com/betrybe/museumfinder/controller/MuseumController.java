package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Museum controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  /**
   * The Museum service interface.
   */
  MuseumServiceInterface museumServiceInterface;

  /**
   * Instantiates a new Museum controller.
   *
   * @param museumServiceInterface the museum service interface
   */
  @Autowired
  public MuseumController(MuseumServiceInterface museumServiceInterface) {
    this.museumServiceInterface = museumServiceInterface;
  }

  /**
   * New museum response entity.
   *
   * @param museumCreationDto the museum creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Museum> newMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum dtoToModel = ModelDtoConverter.dtoToModel((museumCreationDto));
    Museum createdMuseum = museumServiceInterface.createMuseum(dtoToModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdMuseum);
  }

}
