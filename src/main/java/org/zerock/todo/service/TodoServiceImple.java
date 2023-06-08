package org.zerock.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.todo.dto.PageRequestDTO;
import org.zerock.todo.dto.PageResponseDTO;
import org.zerock.todo.dto.TodoDTO;
import org.zerock.todo.mappers.TodoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImple implements TodoService {
    
    private final TodoMapper mapper;

    @Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        List<TodoDTO> list = mapper.getList(pageRequestDTO);
        long total = mapper.listCount(pageRequestDTO);
        
        return PageResponseDTO.<TodoDTO>withAll()
                .list(list)
                .total(total)
                .build();
    }

}
