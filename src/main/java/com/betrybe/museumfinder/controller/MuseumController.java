package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.exception.MuseumNotFoundExpection;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /**
   * Gets museum.
   *
   * @param latitude  the latitude
   * @param longitude the longitude
   * @param maxDist   the max dist
   * @return the museum
   * @throws MuseumNotFoundExpection the museus not found expection
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getMuseum(
      @RequestParam("lat") double latitude,
      @RequestParam("lng") double longitude,
      @RequestParam("max_dist_km") double maxDist
  ) throws MuseumNotFoundExpection {
    Coordinate coordinate = new Coordinate(latitude, longitude);
    MuseumDto museumDto = ModelDtoConverter.modelToDto(
        museumServiceInterface.getClosestMuseum(coordinate, maxDist)
    );
    return ResponseEntity.ok(museumDto);
  }

}
