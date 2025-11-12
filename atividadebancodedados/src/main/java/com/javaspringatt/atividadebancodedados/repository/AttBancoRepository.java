package com.javaspringatt.atividadebancodedados.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
public interface AttBancoRepository extends JpaRepository<AttBancoModel,Integer>{

}
