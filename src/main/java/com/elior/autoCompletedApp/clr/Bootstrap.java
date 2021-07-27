package com.elior.autoCompletedApp.clr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elior.autoCompletedApp.entities.Name;
import com.elior.autoCompletedApp.repos.NameRepository;
import com.elior.autoCompletedApp.services.IOService;

import lombok.RequiredArgsConstructor;

@Component
@Order(1)
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

	private final NameRepository nameRepository;

	private final IOService iOService;

	@Override
	public void run(String... args) throws Exception {
		List<Name> names = new ArrayList<Name>();
		iOService.getNamesFromTextFile().forEach(name -> {
			Name currName = Name.builder().name(name).build();
			names.add(currName);
		});
		nameRepository.saveAll(names);
	}
}
