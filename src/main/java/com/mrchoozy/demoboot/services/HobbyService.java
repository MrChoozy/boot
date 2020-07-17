package com.mrchoozy.demoboot.services;

import com.mrchoozy.demoboot.entity.Hobby;
import com.mrchoozy.demoboot.repositories.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyService {
    private HobbyRepository hobbyRepository;

    @Autowired
    public HobbyRepository getHobbyRepository() {
        return hobbyRepository;
    }

    public void setHobbyRepository(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public void save (Hobby hobby){
        hobbyRepository.save(hobby);
    }


}
