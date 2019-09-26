package com.tomhor.garagevinylstore.controller;

import com.tomhor.garagevinylstore.model.Author;
import com.tomhor.garagevinylstore.service.AuthorService;
import com.tomhor.garagevinylstore.service.VinylService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private static final String AUTHOR_FORM_URL = "author/authorForm";
    private final AuthorService authorService;
    private final VinylService vinylService;

    public AuthorController(AuthorService authorService, VinylService vinylService) {
        this.authorService = authorService;
        this.vinylService = vinylService;
    }

    @GetMapping("/getAll")
    public String getAllAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author/getAll";
    }

    @GetMapping("/getAll/vinyls")
    public String getAllAuthorsWitchVinyls(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "author/getAllWitchVinyls";
    }

    @GetMapping("/addNewAuthor")
    public String addNewAuthor(Model model) {
        model.addAttribute("author", new Author());
        return AUTHOR_FORM_URL;
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ("redirect:/author/getAll");
    }

    @GetMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        Author authorToEdit = authorService.findById(id);
        model.addAttribute("author", authorToEdit);
        return AUTHOR_FORM_URL;
    }

    @PostMapping("/saveAuthor")
    public String saveNewAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(objectError -> {
                model.addAttribute("errorMessage", objectError.toString());
            });
            return AUTHOR_FORM_URL;

        } else {
            authorService.save(author);
            return ("redirect:/author/getAll");
        }
    }
}
