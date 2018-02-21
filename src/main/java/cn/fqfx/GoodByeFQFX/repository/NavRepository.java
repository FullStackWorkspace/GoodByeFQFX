package cn.fqfx.GoodByeFQFX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.fqfx.GoodByeFQFX.domain.Title;

public interface NavRepository extends JpaRepository<Title,Long>{
	
	Title findByName(String name);
}
