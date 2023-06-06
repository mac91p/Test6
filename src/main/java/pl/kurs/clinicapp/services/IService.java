package pl.kurs.clinicapp.services;

import pl.kurs.clinicapp.exceptions.InvalidDataException;

import java.io.Serializable;

public interface IService<T extends Serializable> {

    void saveAll() throws InvalidDataException;





}
