package cz.fi.muni.pa036.cachingapp;

import cz.fi.muni.pa036.cachingapp.service.BranchService;
import cz.fi.muni.pa036.cachingapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CachingAppApplication implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(CachingAppApplication.class);

  private final UserService userService;
  private final BranchService branchService;

  public CachingAppApplication(UserService userService,
      BranchService branchService) {
    this.userService = userService;
    this.branchService = branchService;
  }

  public static void main(String[] args) {
    SpringApplication.run(CachingAppApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
   /* List<User> results = userService.listAllUsers();
    logger.info("Users size: {}", results.size());
    User firstResult = results.get(0);
    logger.info("The first record {} with name: {} {}", firstResult.getId(), firstResult.getName(), firstResult.getSurname());
    Branch usersBranch = firstResult.getBranch();
    logger.info("His branch {}  in the city {}", usersBranch.getName(), usersBranch.getCity());

    List<Branch> branches = branchService.listAllBranches();*/
  }
}
