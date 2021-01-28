package com.example.demo.repository.computerRespositories;

import com.example.demo.model.ComputerPartsModel.GPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = {"http://localhost:3000"})
//path is the route ex: path = "abc -> localhost8080/abc
@RepositoryRestResource(collectionResourceRel = "cpu", path = "gpu")
public interface GPURepository extends JpaRepository<GPU,Integer> {
    
}
