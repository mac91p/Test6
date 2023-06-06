package pl.kurs.clinicapp.services;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
//@Profile("dev")
public interface IDeserializeService <T extends Serializable > {

    List<T> importFromTxt(String filePath);

}
