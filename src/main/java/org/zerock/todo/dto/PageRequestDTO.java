package org.zerock.todo.dto;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class PageRequestDTO {
    
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;  // 게시물 몇 개씩 볼 건지

    public void setPage(int page){
        if(page<=0){
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setSize(int size){
        // 22000개씩 로드해서 서버 뻗게 하는 공격을 막기 위한 안전장치
        if(size > 100 || size < 0){     
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    public int getSkip(){
        return (this.page - 1) * size;
    }

    public int getEnd(){
        return this.page * this.size;
    }

    public int getCountEnd(){
        int temp = (int)(Math.ceil(this.page/10.0)) *100;
        return temp+1;
    }
}
