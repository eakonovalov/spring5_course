package com.eakonovalov.spring5petclinic.data.services;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;

public interface OwnerService {

    void rename(Long id, String firsName);
}
