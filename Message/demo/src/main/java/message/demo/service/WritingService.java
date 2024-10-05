package message.demo.service;

import lombok.RequiredArgsConstructor;
import message.demo.domain.writing;
import message.demo.repository.WritingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WritingService {

    private final WritingRepository writingRepository;

    public Long join(writing writing) {
        writingRepository.save(writing);
        return writing.getId();
    }

    public List<writing> findWriting() {
        return writingRepository.findAll();
    }

    public writing findOne(Long id) {
        return writingRepository.findOne(id);
    }
}
