package com.br.bb.beleza.service;

import com.br.bb.beleza.model.entity.Schedule;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {

	Schedule save(Schedule schedule);

	Schedule update(Schedule schedule);
	
	void delete(Schedule schedule);
	
	List<Schedule> find(Schedule scheduleFilter);
	
	void updateStatus(Schedule schedule);
	
	void verify(Schedule schedule);
	
	Optional<Schedule> findById(Long id);

}