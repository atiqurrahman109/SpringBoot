package com.atik.sms.service;

import com.atik.sms.entity.Fee;
import com.atik.sms.entity.Result;
import com.atik.sms.repository.AttendanceRepository;
import com.atik.sms.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository repo;

    public ResultService(ResultRepository repo) {
        this.repo = repo;
    }
    public List<Result> getAll() {
        return repo.findAll();
    }

    public Result save(Result result) {
        return repo.save(result);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
