package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundExpection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type General controller advice.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handler invalid coordinate exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handlerInvalidCoordinateException(
      InvalidCoordinateException exception
  ) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Coordenada Inválida!");
  }

  /**
   * Handler not found exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handlerNotFoundException(
      MuseumNotFoundExpection exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Museu não encontrado!");
  }

  /**
   * Handler exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler
  public ResponseEntity<String> handlerException(
      Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
