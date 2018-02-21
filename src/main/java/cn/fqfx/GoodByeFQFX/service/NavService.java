package cn.fqfx.GoodByeFQFX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fqfx.GoodByeFQFX.domain.Title;
import cn.fqfx.GoodByeFQFX.domain.dto.BaseDTO;
import cn.fqfx.GoodByeFQFX.repository.NavRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class NavService {

	@Autowired
	private NavRepository navRepository;

	/*
	 * 获取所有导航
	 */
	public List<Title> getAllTitle() {

		return navRepository.findAll();

	}

	public BaseDTO addNewNav(Title title) {
		if (navRepository.findByName(title.getName()) != null) {
			return BaseDTO.error(1, "该导航已存在");
		}

		navRepository.save(title);

		return BaseDTO.ok();
	}
}
