package com.elior.autoCompletedApp.services;

import java.util.List;

public interface AutoCompletedNamesService {

	List<String> getAllMatchingNames(String prefix);
}
