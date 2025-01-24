package com.example.demo.dataLoader;

import com.example.demo.models.cd.Cd;
import com.example.demo.repositories.cd.CdRp;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {


    private final CdRp cdRp;

    @Override
    public void run(String... args) throws Exception {

        if (cdRp.count() == 0) {

            Cd centro1 = new Cd("A");
            Cd centro2 = new Cd("B");
            Cd centro3 = new Cd("C");


            cdRp.save(centro1);
            cdRp.save(centro2);
            cdRp.save(centro3);

        }
    }
}
