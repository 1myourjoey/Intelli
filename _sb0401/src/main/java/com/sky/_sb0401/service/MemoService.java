package com.sky._sb0401.service;

import com.sky._sb0401.entity.Memo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MemoService {
@PersistenceContext
    EntityManager em;

    @Transactional
   public void emInsert(){
        Memo memo = Memo.builder()
                .memoText("이건 EM테스트").build();
        em.persist(memo);
    }

    public Memo emselectOne(Long mno) {
        return em.find(Memo.class, mno);

    }
}
