package com.bugtracker.bugmngmodule.service;

import java.util.List;

import com.bugtracker.bugmngmodule.dto.BugEntryDto;
import com.bugtracker.bugmngmodule.entity.Bugs;

public interface BugService {

	void createBug(BugEntryDto bugdata);

	Bugs getBugById(Long bugId);

	List<Bugs> getAllBugs();

	List<Bugs> getBugsByStatus(String status);

	void deleteBugById(Long bugId);

	void updateBugById(Long bugId, BugEntryDto updateBugData);

	List<Bugs>  getBugByCustId(int custId);



}
