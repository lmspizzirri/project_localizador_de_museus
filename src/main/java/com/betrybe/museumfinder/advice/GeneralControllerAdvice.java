package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundExpection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerAdvice {
  @ExceptionHandler
  public ResponseEntity<String> handlerInvalidCoordinateException(
      InvalidCoordinateException exception
  ) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Coordenada Inválida!");
  }

  @ExceptionHandler
  public ResponseEntity<String> handlerNotFoundException(
      MuseumNotFoundExpection exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("Museu não encontrado!");
  }

  @ExceptionHandler
  public ResponseEntity<String> handlerException(
      Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
