package com.bugtracker.bugmngmodule.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracker.bugmngmodule.dto.BugEntryDto;
import com.bugtracker.bugmngmodule.entity.Bugs;
import com.bugtracker.bugmngmodule.entity.CustomerEntity;
import com.bugtracker.bugmngmodule.entity.Project;
import com.bugtracker.bugmngmodule.exceptions.BugNotFoundException;
import com.bugtracker.bugmngmodule.repository.BugRepository;
import com.bugtracker.bugmngmodule.repository.CustomerRepository;
import com.bugtracker.bugmngmodule.repository.ProjectRepository;
import com.bugtracker.bugmngmodule.service.BugService;

@Service
public class BugServiceImpl implements BugService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BugServiceImpl.class);

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createBug(BugEntryDto bugdata) {
        LOGGER.info("Creating a new bug");

        Project project = new Project();
        project.setProjName(bugdata.getProjectName());
//        project.setProjStatus("OPEN");
        projectRepository.save(project);

        Bugs bugs = new Bugs();
        bugs.setTitle(bugdata.getTitle());
        bugs.setDescription(bugdata.getDescription());
        bugs.setType(bugdata.getType());
        bugs.setPriority(bugdata.getPriority());
        bugs.setStatus("OPEN");
        bugs.setStartDate(Date.valueOf(LocalDate.now()));
        bugs.setProject(project);
        
        Optional<CustomerEntity> custOptional =  customerRepository.findById(bugdata.getCustomerId());
        if (custOptional.isEmpty()) {
        	throw new BugNotFoundException("Customer Not found in DataBase with Id: " + bugdata.getCustomerId());
        }
        CustomerEntity cust = custOptional.get();
        bugs.setCustomerEntity(cust);;
        
        bugRepository.save(bugs);

        LOGGER.info("New bug created successfully");
    }

    @Override
    public Bugs getBugById(Long bugId) {
        LOGGER.info("Fetching bug by ID: {}", bugId);

        Optional<Bugs> bugOpt = bugRepository.findById(bugId);
        if (bugOpt.isPresent()) {
            Bugs bug = bugOpt.get();
            return bug;
        } else {
            throw new BugNotFoundException("Bug Not found in DataBase with Id: " + bugId);
        }
    }

    @Override
    public List<Bugs> getAllBugs() {
        LOGGER.info("Fetching all bugs");

        List<Bugs> allBugs = bugRepository.findAll();
        return allBugs;
    }

    @Override
    public List<Bugs> getBugsByStatus(String status) {
        LOGGER.info("Fetching bugs by status: {}", status);

        List<Bugs> allBugs = bugRepository.findAll();
        List<Bugs> filteredBugs = allBugs.stream()
                .filter(b -> b.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());

        if (filteredBugs.isEmpty()) {
            throw new BugNotFoundException("Bug Not found in DataBase with status: " + status);
        }

        return filteredBugs;
    }

    @Override
    public void deleteBugById(Long bugId) {
        LOGGER.info("Deleting bug with ID: {}", bugId);

        Optional<Bugs> optionalBug = bugRepository.findById(bugId);

        if (optionalBug.isPresent()) {
            Bugs bug = optionalBug.get();
            bugRepository.delete(bug);
        } else {
            throw new BugNotFoundException("Bug Not found in DataBase with Id: " + bugId);
        }
    }

    @Override
    public void updateBugById(Long bugId, BugEntryDto updateBugData) {
        LOGGER.info("Updating bug with ID: {}", bugId);

        Optional<Bugs> optionalBug = bugRepository.findById(bugId);

        if (optionalBug.isPresent()) {
            Bugs bug = optionalBug.get();
            bug.setTitle(updateBugData.getTitle());
            bug.setDescription(updateBugData.getDescription());
            bug.setType(updateBugData.getType());
            bug.setPriority(updateBugData.getPriority());
            bugRepository.save(bug);
        } else {
            throw new BugNotFoundException("Bug Not found in DataBase with Id: " + bugId);
        }
    }

	@Override
	public List<Bugs>  getBugByCustId(int custId) {
		List<Bugs> bugs = bugRepository.findAll();
		List<Bugs> bug =  bugs.stream().filter(b->b.getCustomerEntity().getCustomerId()== custId).collect(Collectors.toList());
		return bug;
	}

}
