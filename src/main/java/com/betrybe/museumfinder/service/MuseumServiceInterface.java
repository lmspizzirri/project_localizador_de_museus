package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;

/**
 * Interface for Museum service class.
 */
public interface MuseumServiceInterface {

  Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) throws MuseumNotFoundException;

  Museum createMuseum(Museum museum);

  Museum getMuseum(Long id);
}
