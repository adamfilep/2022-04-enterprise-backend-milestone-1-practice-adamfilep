package com.codecool.library.repository;

import com.codecool.library.repository.model.Writer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WriterDaoMem implements WriterDao {

    private List<Writer> writerList;

    public WriterDaoMem(List<Writer> writerList) {
        this.writerList = writerList;
    }

    public WriterDaoMem() {
        writerList = new ArrayList<>();
    }

    @Override
    public void addWriter(Writer writer) {
        writerList.add(writer);
    }
}
