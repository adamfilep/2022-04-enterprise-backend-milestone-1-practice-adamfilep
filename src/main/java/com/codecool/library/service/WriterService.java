package com.codecool.library.service;

import com.codecool.library.repository.WriterDao;
import com.codecool.library.repository.model.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService {
    private WriterDao writerDao;

    @Autowired
    public WriterService(WriterDao writerDao) {
        this.writerDao = writerDao;
    }

    public void addWriter(Writer writer) {
        writerDao.addWriter(writer);
    }
}
