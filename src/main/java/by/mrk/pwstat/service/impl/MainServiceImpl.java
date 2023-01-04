package by.mrk.pwstat.service.impl;

import by.mrk.pwstat.repository.PointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MainServiceImpl implements by.mrk.pwstat.service.MainService {
    private final PointRepository pointRepository;

    @Override
    public Integer getOnline(){
        return pointRepository.online(1);
    }
}
