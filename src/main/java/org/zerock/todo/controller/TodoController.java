package org.zerock.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.todo.dto.PageRequestDTO;
import org.zerock.todo.dto.PageResponseDTO;
import org.zerock.todo.dto.TodoDTO;
import org.zerock.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todo/")
@RequiredArgsConstructor
public class TodoController {
    
    private final TodoService service;

    @GetMapping("list")
    public void list(PageRequestDTO request, Model model){
        PageResponseDTO<TodoDTO> response = service.list(request);
        model.addAttribute("pageResponseDTO", response);
    }

}
