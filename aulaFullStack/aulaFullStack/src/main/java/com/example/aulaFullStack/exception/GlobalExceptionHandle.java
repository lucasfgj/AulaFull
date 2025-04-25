package com.example.aulaFullStack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", "Ação invalida "));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", "Ação não reconhecida favor tente novamente"));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "Recurso não encontrado"));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> NoResourceFoundException(NoResourceFoundException erro){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "URL invalida ou incompleta, por favor corrigir e tentar novamente"));
    }

}


