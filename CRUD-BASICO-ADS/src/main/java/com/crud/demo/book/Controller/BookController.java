package com.crud.demo.book.Controller;

import com.crud.demo.book.Model.BookModel;
import com.crud.demo.book.Service.BookService;
import com.crud.demo.book.DTO.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    private ResponseEntity<List<BookModel>> listarLivros(){
       List<BookModel> list = bookService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    private ResponseEntity<BookModel> criarLivro(@RequestBody BookDTO bookDTO){
        BookModel response = bookService.criarLivro(bookDTO.transformaParaObjeto());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletarLivro(@PathVariable Long id){
        bookService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<BookModel> update(@PathVariable Long id, @RequestBody BookModel bookModel){
         BookModel response  = bookService.update(id, bookModel);
        return ResponseEntity.ok().body(response);
    }

}
