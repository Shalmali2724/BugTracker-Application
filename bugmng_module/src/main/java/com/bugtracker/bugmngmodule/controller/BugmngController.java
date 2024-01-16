package com.bugtracker.bugmngmodule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracker.bugmngmodule.dto.BugEntryDto;
import com.bugtracker.bugmngmodule.entity.Bugs;
import com.bugtracker.bugmngmodule.service.BugService;

@RestController
@RequestMapping("api/bugmng")
public class BugmngController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BugmngController.class);

    @Autowired
    private BugService bugService;

    // Creating New Bug
    @PostMapping("/create-bug")
    public ResponseEntity<String> createBug(@RequestBody BugEntryDto bugdata) {
        LOGGER.info("Creating a new bug");
        bugService.createBug(bugdata);
        LOGGER.info("Bug created successfully");
        return ResponseEntity.status(HttpStatus.OK).body("Bug Data is saved");
    }
    
    

    // Updating an existing bug by its Id
    @PutMapping("/update-bug/{bugId}")
    public ResponseEntity<?> updateBugById(@PathVariable("bugId") Long bugId, @RequestBody BugEntryDto updateBugData) {
        LOGGER.info("Updating bug with ID: {}", bugId);
        bugService.updateBugById(bugId, updateBugData);
        LOGGER.info("Bug updated successfully");
        return null;
    }

    // Fetching a particular bug by its Id
    @GetMapping("/get-bug/{bugId}")
    public ResponseEntity<?> getBugById(@PathVariable("bugId") Long bugId) {
        LOGGER.info("Fetching bug by ID: {}", bugId);
        Bugs bug = bugService.getBugById(bugId);
        LOGGER.info("Bug fetched successfully");
        return ResponseEntity.status(HttpStatus.OK).body(bug);
    }

    // Get all Bugs
    @GetMapping("/get-allbugs")
    public ResponseEntity<?> getAllBugs() {
        LOGGER.info("Fetching all bugs");
        List<Bugs> allbugs = bugService.getAllBugs();
        LOGGER.info("All bugs fetched successfully");
        return ResponseEntity.status(HttpStatus.OK).body(allbugs);
    }

    // Get all Bugs By Status
    @GetMapping("/getbugs-by-status/{status}")
    public ResponseEntity<?> getBugsByStatus(@PathVariable("status") String status) {
        LOGGER.info("Fetching bugs by status: {}", status);
        List<Bugs> bugs = bugService.getBugsByStatus(status);
        LOGGER.info("Bugs fetched successfully");
        return ResponseEntity.status(HttpStatus.OK).body(bugs);
    }

    // Delete Bug By BugId
    @DeleteMapping("/delbug/{bugId}")
    public ResponseEntity<?> deleteBugById(@PathVariable("bugId") Long bugId) {
        LOGGER.info("Deleting bug with ID: {}", bugId);
        bugService.deleteBugById(bugId);
        LOGGER.info("Bug deleted successfully");
        return null;
    }
    @GetMapping("/bugcustid/{custId}")
    public ResponseEntity<?> getBugByCustId(@PathVariable("custId") int custId){
    	List<Bugs> bugs =  bugService.getBugByCustId(custId);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(bugs);
    }
}
