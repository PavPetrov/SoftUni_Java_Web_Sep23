package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodEnum;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {

        if(moodRepository.count() != 0){
            return;
        }

        Arrays.stream(MoodEnum.values()).forEach( moodEnum -> {
              Mood mood = new Mood().setMoodsName(moodEnum);
              moodRepository.save(mood);
        });
    }
}
