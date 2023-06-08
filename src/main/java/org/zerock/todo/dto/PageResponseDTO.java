package org.zerock.todo.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO<E> {
    
    private List<E> list;   // 투두리스트
    private long total;     // 총 투두 갯수

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> list, long total){
        this.list = list;
        this.total = total;
    }

}
