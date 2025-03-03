package com.example.demo.Exceptions.handler;

import com.example.demo.Exceptions.abrigo.AbrigoException;
import com.example.demo.Exceptions.cd.CdException;
import com.example.demo.Exceptions.endereco.EnderecoException;
import com.example.demo.Exceptions.pedido.PedidoException;
import com.example.demo.models.endereco.EnderecoModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(EnderecoException.class)
    public ResponseEntity<String> handleEnderecoException(EnderecoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PedidoException.class)
    public ResponseEntity<String> handlePedidoException(PedidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(CdException.class)
    public ResponseEntity<String> handleCdException(CdException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(AbrigoException.class)
    public ResponseEntity<String> handleAbrigoException(AbrigoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
