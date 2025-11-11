package com.crud.demo.book.Service;

import com.crud.demo.book.Model.BookModel;
import com.crud.demo.book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
     private BookRepository bookRepository;


    public List<BookModel> findAll(){
        return  bookRepository.findAll();
    }

    public BookModel criarLivro(BookModel bookModel){
        return bookRepository.save(bookModel);
    }

    public void deletarLivro(Long id){
        bookRepository.deleteById(id);
    }

    public BookModel update(Long id, BookModel bookMode){
        BookModel newbook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));

        newbook.setCategoria(bookMode.getCategoria());
        newbook.setNome(bookMode.getNome());
        return bookRepository.save(newbook);
    }

}
